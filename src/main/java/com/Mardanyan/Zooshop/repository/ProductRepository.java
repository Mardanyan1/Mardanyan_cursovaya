package com.Mardanyan.Zooshop.repository;

import com.Mardanyan.Zooshop.models.Product;
import com.Mardanyan.Zooshop.models.ProductType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>
{
    public List<Product> findByProductType(ProductType productType);
}