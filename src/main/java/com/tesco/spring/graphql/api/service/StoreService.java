package com.tesco.spring.graphql.api.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tesco.spring.graphql.api.entity.Store;
import com.tesco.spring.graphql.api.repository.StoreRepository;

@Service
public class StoreService {
	@Autowired
	private StoreRepository repository;

	@PostConstruct
	public void initStores() {
		List<Store> stores = new ArrayList<>();
		Store str = new Store();
		str.setStoreId("9876");
		str.setStoreName("Tesco Store");
		str.setRegion("Irvine");
		str.setEstablishedDate("12-06-1992");
		str.setOwner("Mr Michel Disoza");
		String[] deps1 = {"food", "kids", "medicine"};
		str.setDepartments(deps1);
		stores.add(str);
		
		str = new Store();
		str.setStoreId("6754");
		str.setStoreName("Tesco Small Store");
		str.setRegion("California");
		str.setEstablishedDate("22-01-2002");
		str.setOwner("Mrs Daina Smith");
		String[] deps2 = {"food", "kids", "medicine"};
		str.setDepartments(deps2);
		stores.add(str);
		repository.save(stores);
	}

	public List<Store> findAllStores() {
		return repository.findAll();
	}

	public Store findStoreById(String movieId) {
		return repository.findOne(movieId);
	}
}
