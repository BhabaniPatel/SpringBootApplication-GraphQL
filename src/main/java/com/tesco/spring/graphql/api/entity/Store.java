package com.tesco.spring.graphql.api.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table
@Entity
@Data
public class Store {

	@Id
	private String storeId;
	private String storeName;
	private String region;
	private String establishedDate;
	private String[] departments;
	private String owner;

}
