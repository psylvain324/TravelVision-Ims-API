package com.travel.vision.imsapi.services

import com.travel.vision.imsapi.models.Inventory
import org.springframework.http.ResponseEntity
import java.util.*

interface InventoryService {
    fun getAllInventory(): ResponseEntity<List<Inventory>>
    fun getInventoryById(id: Long): ResponseEntity<Optional<Inventory>>
    fun saveInventory(inventory: Inventory): ResponseEntity<Inventory>
    fun updateInventoryById(id: Long, newInventory: Inventory): ResponseEntity<Inventory>
    fun deleteInventoryById(id: Long): ResponseEntity<Unit>
}