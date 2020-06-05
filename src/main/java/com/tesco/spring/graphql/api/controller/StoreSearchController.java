package com.tesco.spring.graphql.api.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tesco.spring.graphql.api.datafetcher.AllStoreDataFetcher;
import com.tesco.spring.graphql.api.datafetcher.StoreDataFetcher;
import com.tesco.spring.graphql.api.entity.Store;
import com.tesco.spring.graphql.api.service.StoreService;

import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@RestController
@RequestMapping("/tescostores")
public class StoreSearchController {

	@Autowired
	private StoreService service;

	// load graphqls file
	@Value("classpath:store.schema")
	private Resource schemaResource;

	@Autowired
	private AllStoreDataFetcher allStoreDataFetcher;

	@Autowired
	private StoreDataFetcher StoreDataFetcher;

	private GraphQL graphQL;

	// load schema at application start up
	@PostConstruct
	public void loadSchema() throws IOException {

		// get the schema
		File schemaFile = schemaResource.getFile();

		// parse schema
		TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
		RuntimeWiring wiring = buildRuntimeWiring();
		GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
		graphQL = GraphQL.newGraphQL(schema).build();
	}

	private RuntimeWiring buildRuntimeWiring() {
		return RuntimeWiring.newRuntimeWiring().type("Query", typeWiring -> typeWiring
				.dataFetcher("allStores", allStoreDataFetcher).dataFetcher("store", StoreDataFetcher)).build();
	}

	@GetMapping("/storesList")
	public List<Store> getStoresList() {
		return service.findAllStores();
	}

	/*
	 * In PostMan use Post URL: localhost:8080/tescostores/getAllStores and Body: as
	 * text query{ allStores{ storeId, storeName } }
	 */
	@PostMapping("/getAllStores")
	public ResponseEntity<Object> getAllStores(@RequestBody String query) {
		ExecutionResult result = graphQL.execute(query);
		return new ResponseEntity<Object>(result, HttpStatus.OK);
	}

	@GetMapping("/search/{storeId}")
	public Store getStoreInfo(@PathVariable String movieId) {
		return service.findStoreById(movieId);
	}

	@PostMapping("/getStoreById")
	public ResponseEntity<Object> getStoreById(@RequestBody String query) {
		ExecutionResult result = graphQL.execute(query);
		return new ResponseEntity<Object>(result, HttpStatus.OK);
	}
}
