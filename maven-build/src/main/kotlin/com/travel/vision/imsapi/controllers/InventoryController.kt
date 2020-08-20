package com.travel.vision.imsapi.controllers

import com.travel.vision.imsapi.services.InventoryService
import com.travel.vision.imsapi.models.Inventory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/inventory")
class InventoryController @Autowired constructor(
        private val inventoryService: InventoryService
) {

    @GetMapping("/all")
    fun getAllArticles(): ResponseEntity<List<Inventory>> =
        inventoryService.getAllInventory();

    @PostMapping("/save")
    fun createNewInventory(@RequestBody inventory: Inventory): ResponseEntity<Inventory> =
        inventoryService.saveInventory(inventory)

    @GetMapping("/{id}")
    fun getInventoryById(@PathVariable(value = "id") id: Long): ResponseEntity<Optional<Inventory>> {
        return inventoryService.getInventoryById(id)
    }

    @PutMapping("/{id}")
    fun updateInventoryById(@PathVariable(value = "id") id: Long, @RequestBody newInventory: Inventory): ResponseEntity<Inventory> {
        return inventoryService.updateInventoryById(id, newInventory)
    }

    @DeleteMapping("/articles/{id}")
    fun deleteInventoryById(@PathVariable(value = "id") id: Long): ResponseEntity<Unit> {
        return inventoryService.deleteInventoryById(id)
    }
}