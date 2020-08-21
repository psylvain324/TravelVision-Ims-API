package com.travel.vision.ims.imsapi.services

import com.travel.vision.ims.imsapi.interfaces.OrderService
import com.travel.vision.ims.imsapi.models.Customer
import com.travel.vision.ims.imsapi.models.Order
import com.travel.vision.ims.imsapi.repositories.CustomerRepository
import com.travel.vision.ims.imsapi.repositories.OrderRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*


@Service
class OrderServiceImpl(@Autowired private val orderRepository: OrderRepository,
   @Autowired private val customerRepository: CustomerRepository,
   private val customerMap: HashMap<String, Customer>) : OrderService {

    override fun getAllOrder(): ResponseEntity<List<Order>> {
        return ResponseEntity(orderRepository.findAll(), HttpStatus.OK);
    }

    override fun getOrderById(id: Long): ResponseEntity<Optional<Order>> {
        return ResponseEntity(orderRepository.findById(id), HttpStatus.OK);
    }

    override fun saveOrder(order: Order): ResponseEntity<Order> {
        return ResponseEntity(orderRepository.save(order), HttpStatus.OK)
    }

    override fun updateOrderById(id: Long, newOrder: Order): ResponseEntity<Order> {
        assert(newOrder.id == id)
        return ResponseEntity(orderRepository.save(newOrder), HttpStatus.OK)
    }

    override fun deleteOrderById(id: Long): ResponseEntity<Unit> {
        orderRepository.deleteById(id)
        return ResponseEntity.noContent().build()
    }

    override fun getAllOrdersForCustomer(customerId: Long?): List<Order?>? {
        return orderRepository.findAllByCustomerId(customerId)
    }

    override fun getOrderByIdForCustomer(orderId: Long?, customerId: Long?): Order? {
        return orderRepository.findAllByIdAndCustomerId(orderId, customerId)
    }

}