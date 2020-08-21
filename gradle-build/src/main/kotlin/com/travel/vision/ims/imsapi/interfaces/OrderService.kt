package com.travel.vision.ims.imsapi.interfaces

import com.travel.vision.ims.imsapi.models.Order
import org.springframework.http.ResponseEntity
import java.util.*

interface OrderService {
    fun getAllOrder(): ResponseEntity<List<Order>>
    fun getOrderById(id: Long): ResponseEntity<Optional<Order>>
    fun saveOrder(order: Order): ResponseEntity<Order>
    fun updateOrderById(id: Long, newOrder: Order): ResponseEntity<Order>
    fun deleteOrderById(id: Long): ResponseEntity<Unit>
    fun getAllOrdersForCustomer(customerId: Long?): List<Order?>?
    fun getOrderByIdForCustomer(orderId: Long?, customerId: Long?): Order?
}