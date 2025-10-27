package com.team2.hrbank.common.config;

import io.github.openfeign.querydsl.jpa.spring.repository.config.EnableQuerydslRepositories;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableQuerydslRepositories
public class QuerydslConfig {

    /*@Bean
    public JPAQueryFactory jpaQueryFactory(EntityManager em) {
        return new JPAQueryFactory(em);
    }*/

}
