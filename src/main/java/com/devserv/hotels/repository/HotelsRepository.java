package com.devserv.hotels.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.devserv.hotels.entity.Hotels;

@RepositoryRestResource()
public interface HotelsRepository extends JpaRepository<Hotels, Integer>, JpaSpecificationExecutor<Hotels>, QuerydslPredicateExecutor<Hotels> {}
