package com.project.datasyncservice.repository;

import com.project.datasyncservice.entity.ProductDetail;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductDetailRepository extends MongoRepository<ProductDetail, String> {

    Optional<ProductDetail> findByProductId(Long productId);
}
