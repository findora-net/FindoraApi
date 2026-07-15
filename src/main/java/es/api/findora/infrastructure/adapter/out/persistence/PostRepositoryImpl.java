package es.api.findora.infrastructure.adapter.out.persistence;

import es.api.findora.domain.model.PageModel;
import es.api.findora.domain.query.ListPostQuery;
import es.api.findora.domain.query.PaginationQuery;
import es.api.findora.domain.model.Post;
import es.api.findora.domain.port.out.PostRepository;
import es.api.findora.infrastructure.mapper.PostMapper;
import es.api.findora.infrastructure.persistence.entity.*;
import es.api.findora.infrastructure.persistence.repository.PostRepositoryJPA;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class PostRepositoryImpl implements PostRepository {

    private EntityManager entityManager;
    private final PostMapper postMapper;
    private final PostRepositoryJPA jpa;


    @Override
    public PageModel<Post> list(PaginationQuery paginationQuery, ListPostQuery listPostQuery) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<PostEntity> cq = cb.createQuery(PostEntity.class);
        Root<PostEntity> root = cq.from(PostEntity.class);

        List<Predicate> predicates = processFilters(cb,cq,root,listPostQuery);

        cq.select(root).where(cb.and(predicates));
        processOrder(paginationQuery,cb,cq,root);
        TypedQuery<PostEntity> query = entityManager.createQuery(cq);

        query.setFirstResult(paginationQuery.getFirstResult());
        query.setMaxResults(paginationQuery.getPageSize());


        return paginate(paginationQuery, listPostQuery, query);
    }

    @Override
    public Optional<Post> findById(Long id) {
        return jpa.findById(id).map(postMapper::toDomain);
    }

    @Override
    public boolean existsPost(Long id) {
        return jpa.existsById(id);
    }

    private void processOrder(PaginationQuery paginationQuery, CriteriaBuilder cb, CriteriaQuery<PostEntity> cq, Root<PostEntity> root){
        if (paginationQuery.getSortBy() != null || !paginationQuery.getSortBy().isBlank()) {
            Order order = paginationQuery.isAsc() ?
                    cb.asc(root.get(paginationQuery.getSortBy())) :
                    cb.desc(root.get(paginationQuery.getSortBy()));
            cq.orderBy(order);
        }
    }

    private long getTotalElement( ListPostQuery listPostQuery){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        Root<PostEntity> countRoot = countQuery.from(PostEntity.class);

        List<Predicate> countPredicates = processFilters(cb, countQuery, countRoot, listPostQuery);

        countQuery.select(cb.count(countRoot)).where(countPredicates);

        return entityManager.createQuery(countQuery).getSingleResult();
    }

    private List<Predicate> processFilters(CriteriaBuilder cb, CriteriaQuery<?> cq, Root<PostEntity> root, ListPostQuery listPostQuery){
        List<Predicate> predicates = new ArrayList<>();

        processUserFilter(cb,root,listPostQuery,predicates);
        processTagsFilter(cb,cq,root,listPostQuery,predicates);
        processCategoriesFilter(cb,root,listPostQuery,predicates);
        processLocationFilter(cb,root,listPostQuery,predicates);


        return predicates;
    }

    private void processLocationFilter(CriteriaBuilder cb, Root<PostEntity> root, ListPostQuery listPostQuery, List<Predicate> predicates) {
        if(listPostQuery.getLocation() != null && listPostQuery.getLocation() != 0){
            Join<PostEntity, LocationEntity> joinLocation = root.join("locationPost", JoinType.INNER);
            predicates.add(cb.equal(joinLocation.get("id"),listPostQuery.getLocation()));
        }
    }

    private void processCategoriesFilter(CriteriaBuilder cb, Root<PostEntity> root, ListPostQuery listPostQuery, List<Predicate> predicates) {
        if (listPostQuery.getCategories() != null && !listPostQuery.getCategories().isEmpty()) {
            Join<PostEntity, CategoryEntity> joinCategory = root.join("categoryPost",JoinType.INNER);
            Predicate predicate = cb.or(
                    listPostQuery
                            .getCategories()
                            .stream()
                            .map(id -> cb.equal(joinCategory.get("id"),id))
                            .toList());

            predicates.add(predicate);
        }
    }

    private void processTagsFilter(CriteriaBuilder cb, CriteriaQuery<?> cq, Root<PostEntity> root, ListPostQuery listPostQuery, List<Predicate> predicates) {
        if (listPostQuery.getTags() != null && !listPostQuery.getTags().isEmpty()) {
            for (Long tagId : listPostQuery.getTags()) {
                Subquery<Long> sq = cq.subquery(Long.class);
                Root<TagPostEntity> sqRoot = sq.from(TagPostEntity.class);

                sq.select(sqRoot.get("id"));
                sq.where(
                        cb.equal(sqRoot.get("postTags"), root),
                        cb.equal(sqRoot.get("tag").get("id"), tagId)
                );

                predicates.add(cb.exists(sq));
            }
        }
    }

    private void processUserFilter(CriteriaBuilder cb, Root<PostEntity> root, ListPostQuery listPostQuery, List<Predicate> predicates){
        if(listPostQuery.getUserId() != null && listPostQuery.getUserId() != 0){
            Join<PostEntity, UserEntity> joinUser = root.join("postOwner", JoinType.INNER);
            predicates.add(cb.equal(joinUser.get("id"),listPostQuery.getUserId()));

        }
    }

    private PageModel<Post> paginate(PaginationQuery paginationQuery, ListPostQuery listPostQuery, TypedQuery<PostEntity> query){

        long totalElements = this.getTotalElement(listPostQuery);
        int totalPages = paginationQuery.getTotalPages(totalElements);

        PageModel<Post> page = new PageModel<>(
                paginationQuery.getPageKey(),
                paginationQuery.getPageSize(),
                totalPages,
                (int) totalElements,
                query.getResultList().stream().map(postMapper::toModel).toList()
        );

        return page;
    }
}
