package es.api.findora.infrastructure.config.bean;

import es.api.findora.application.usecase.GetAllCategoriesUseCaseImpl;
import es.api.findora.domain.port.in.GetAllCategoriesUseCase;
import es.api.findora.infrastructure.adapter.out.persistence.CategoryRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoryControllerConfig {

    @Bean
    public GetAllCategoriesUseCase getAllCategoriesUseCase(){
        return new GetAllCategoriesUseCaseImpl(new CategoryRepositoryImpl());
    }
}
