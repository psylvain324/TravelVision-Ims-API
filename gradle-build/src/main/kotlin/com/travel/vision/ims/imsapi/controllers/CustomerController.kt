package com.travel.vision.ims.imsapi.controllers

import com.travel.vision .ims.imsapi.interfaces.CustomerService
import com.travel.vision.ims.imsapi.interfaces.OrderService
import com.travel.vision.ims.imsapi.models.Customer
import com.travel.vision.ims.imsapi.models.Order
import com.travel.vision.ims.imsapi.repositories.CustomerRepository
import com.travel.vision.ims.imsapi.repositories.OrderRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.hateoas.CollectionModel
import org.springframework.hateoas.Link
import org.springframework.hateoas.config.EnableHypermediaSupport
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*


@RestController
@RequestMapping("/customers")
@EnableHypermediaSupport(type = [EnableHypermediaSupport.HypermediaType.HAL])
class CustomerController(
        @Autowired private val customerService: CustomerService,
        @Autowired private val orderService: OrderService,
        @Autowired private val customerRepository: CustomerRepository,
        @Autowired private val orderRepository: OrderRepository) {

    @GetMapping("/{customerId}")
    fun getCustomerById(@PathVariable customerId: Long): Optional<Customer> {
        return customerRepository.findById(customerId)
    }

    @GetMapping("/{customerId}/{orderId}")
    fun getOrderById(@PathVariable customerId: Long?, @PathVariable orderId: String): Order? {
        return orderService.getOrderByIdForCustomer(customerId, orderId.toLong())
    }

    @GetMapping(produces = ["application/hal+json"])
    fun getAllCustomers(): CollectionModel<Customer>? {
        val allCustomers: List<Customer> = customerRepository.findAll()
        for (customer in allCustomers) {
            val customerId: Long = customer.id
            val selfLink = linkTo(CustomerController::class.java).slash(customerId)
                    .withSelfRel()
            customer.add(selfLink)
            if (orderService.getAllOrdersForCustomer(customerId) != null) {
                val ordersLink = linkTo(methodOn(CustomerController::class.java).getOrdersForCustomer(customerId)!!)
                        .withRel("allOrders")
                customer.add(ordersLink)
            }
        }
        val link = linkTo(CustomerController::class.java).withSelfRel()
        return CollectionModel(allCustomers, link)
    }

    @GetMapping(value = ["/{customerId}/orders"], produces = ["application/hal+json"])
    fun getOrdersForCustomer(@PathVariable customerId: Long): CollectionModel<Order?>? {
        val orders: List<Order> = orderService.getAllOrdersForCustomer(customerId) as List<Order>
        for (order in orders) {
            val selfLink: Link? = methodOn(CustomerController::class.java)
                    .getOrderById(customerId, order.id.toString())?.let { linkTo(it).withSelfRel() }
            order.add(selfLink)
        }
        val link: Link? = methodOn(CustomerController::class.java)
                .getOrdersForCustomer(customerId)?.let { linkTo(it).withSelfRel() }
        return CollectionModel(orders, link)
    }
}