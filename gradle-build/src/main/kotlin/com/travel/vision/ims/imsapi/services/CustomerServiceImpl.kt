package com.travel.vision.ims.imsapi.services

import com.travel.vision.ims.imsapi.interfaces.CustomerService
import com.travel.vision.ims.imsapi.models.Customer
import com.travel.vision.ims.imsapi.repositories.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class CustomerServiceImpl(
    @Autowired private val customerRepository: CustomerRepository) : CustomerService {
    override fun getAllCustomer(): ResponseEntity<List<Customer>> {
        return ResponseEntity(customerRepository.findAll(), HttpStatus.OK);
    }

    override fun getCustomerById(id: Long): ResponseEntity<Optional<Customer>> {
        return ResponseEntity(customerRepository.findById(id), HttpStatus.OK);
    }

    override fun saveCustomer(customer: Customer): ResponseEntity<Customer> {
        return ResponseEntity(customerRepository.save(customer), HttpStatus.OK)
    }

    override fun updateCustomerById(id: Long, newCustomer: Customer): ResponseEntity<Customer> {
        assert(newCustomer.id == id)
        return ResponseEntity(customerRepository.save(newCustomer), HttpStatus.OK)
    }

    override fun deleteCustomerById(id: Long): ResponseEntity<Unit> {
        customerRepository.deleteById(id)
        return ResponseEntity.noContent().build()
    }

}