package com.reference.microservices.shoppingcartservice;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderDetailRepository extends MongoRepository<OrderDetail, String>{

}
