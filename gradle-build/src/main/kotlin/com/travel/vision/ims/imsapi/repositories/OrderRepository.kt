package com.travel.vision.ims.imsapi.repositories

import com.travel.vision.ims.imsapi.models.Order
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository: MongoRepository<Order, Long> {
    fun findAllByCustomerId(customerId: Long?): List<Order>?
    fun findAllByIdAndCustomerId(orderId: Long?, customerId: Long?): Order?
}