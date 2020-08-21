package com.travel.vision.ims.imsapi.interfaces

import com.travel.vision.ims.imsapi.models.Customer
import com.travel.vision.ims.imsapi.models.Inventory
import org.springframework.http.ResponseEntity
import java.util.*

interface CustomerService {
    fun getAllCustomer(): ResponseEntity<List<Customer>>
    fun getCustomerById(id: Long): ResponseEntity<Optional<Customer>>
    fun saveCustomer(customer: Customer): ResponseEntity<Customer>
    fun updateCustomerById(id: Long, newCustomer: Customer): ResponseEntity<Customer>
    fun deleteCustomerById(id: Long): ResponseEntity<Unit>
}