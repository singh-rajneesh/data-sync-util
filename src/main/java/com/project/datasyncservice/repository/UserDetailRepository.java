package com.project.datasyncservice.repository;

import com.project.datasyncservice.entity.UserDetail;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailRepository extends MongoRepository<UserDetail, String> {

    Optional<UserDetail> findByMobileNumber(String mobileNumber);
}
