package com.tesco.spring.graphql.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tesco.spring.graphql.api.entity.Store;

public interface StoreRepository extends JpaRepository<Store, String> {

}
