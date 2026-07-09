package es.api.findora.infrastructure.mapper;

import es.api.findora.domain.model.PageModel;
import es.api.findora.infrastructure.adapter.in.dto.PageResponse;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class PageMapper {

    public <S, T> PageResponse<T> toPageResponse(PageModel<S> page, Function<S, T> contentMapper) {
        List<T> content = page.getContent().stream()
                .map(contentMapper)
                .collect(Collectors.toList());

        return new PageResponse<>(
                page.getPageKey(),
                page.getPageSize(),
                page.getTotalPages(),
                page.getTotalElements(),
                content
                );
    }

    public <S, T> PageModel<T> toPageModel(Page<S> page, Function<S, T> contentMapper) {
        List<T> content = page.getContent().stream()
                .map(contentMapper)
                .collect(Collectors.toList());

        return new PageModel<>(
                page.getNumber(),
                page.getSize(),
                page.getTotalPages(),
                page.getTotalElements(),
                content
        );
    }
}
