package com.travel.vision.imsapi.services

import com.travel.vision.imsapi.models.Inventory
import com.travel.vision.imsapi.repositories.InventoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class InventoryServiceImpl(
    @Autowired private val inventoryRepository: InventoryRepository) : InventoryService {

    override fun getAllInventory(): ResponseEntity<List<Inventory>> {
        return ResponseEntity(inventoryRepository.findAll(), HttpStatus.OK);
    }

    override fun getInventoryById(id: Long): ResponseEntity<Optional<Inventory>> {
        return ResponseEntity(inventoryRepository.findById(id), HttpStatus.OK);
    }

    override fun saveInventory(inventory: Inventory): ResponseEntity<Inventory>  {
        return ResponseEntity(inventoryRepository.save(inventory), HttpStatus.OK)
    }

    override fun updateInventoryById(id: Long, newInventory: Inventory): ResponseEntity<Inventory> {
        assert(newInventory.id == id)
        return ResponseEntity(inventoryRepository.save(newInventory), HttpStatus.OK)
    }

    override fun deleteInventoryById(id: Long): ResponseEntity<Unit> {
        inventoryRepository.deleteById(id)
        return ResponseEntity.noContent().build()
    }
}