package com.Mardanyan.Zooshop.repository;

import com.Mardanyan.Zooshop.models.ProductType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeRepository extends CrudRepository<ProductType, Long> {}