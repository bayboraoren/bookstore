package com.bookstore.repository.builder;

import org.springframework.stereotype.Component;

import com.bookstore.domain.Category;

/**
 * Builds {@link Category} domain objects
 * 
 * @author Marten Deinum
 * @author Koen Serneels
 * 
 */
@Component
public class CategoryBuilder extends EntityBuilder<Category> {

	@Override
	void initProduct() {
	}

	@Override
	Category assembleProduct() {
		return this.product;
	}

	public CategoryBuilder name(String name) {
		this.product = new Category(name);
		return this;
	}

}
