package com.tesco.spring.graphql.api.datafetcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tesco.spring.graphql.api.repository.StoreRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class StoreDataFetcher implements DataFetcher<com.tesco.spring.graphql.api.entity.Store> {
	@Autowired
	private StoreRepository repository;

	@Override
	public com.tesco.spring.graphql.api.entity.Store get(DataFetchingEnvironment environment) {
		String movieId = environment.getArgument("id");
		return repository.findOne(movieId);
	}

}
