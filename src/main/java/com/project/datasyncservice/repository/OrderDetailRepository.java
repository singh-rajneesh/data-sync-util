package com.project.datasyncservice.repository;

import com.project.datasyncservice.entity.OrderDetail;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderDetailRepository extends MongoRepository<OrderDetail, String> {

    Optional<OrderDetail> findByOrderId(String orderId);

    List<OrderDetail> findByFarmerPhoneNumber(String phoneNumber);

    Optional<OrderDetail> findByOrderIntentId(String orderIntentId);

    @Query(value = "{ 'registeredUserInternalId' : ?0 }")
    List<OrderDetail> findByRegisteredUserInternalId(Integer registeredUserInternalId);

    @Query(value = "{ 'advisorUserId':?0, 'registeredUserInternalId' : ?1 }", count = true)
    Long getOrderCountByAdvisorAndUser(String advisorUserId, Integer registeredUserInternalId);
}

