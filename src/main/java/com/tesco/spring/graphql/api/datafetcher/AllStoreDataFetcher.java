package com.tesco.spring.graphql.api.datafetcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tesco.spring.graphql.api.repository.StoreRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class AllStoreDataFetcher implements DataFetcher<List<com.tesco.spring.graphql.api.entity.Store>> {
	@Autowired
	private StoreRepository repository;

	@Override
	public List<com.tesco.spring.graphql.api.entity.Store> get(DataFetchingEnvironment environment) {
		return repository.findAll();
	}

}
