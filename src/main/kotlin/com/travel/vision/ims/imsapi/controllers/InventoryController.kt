package com.travel.vision.ims.imsapi.controllers

import com.travel.vision.ims.imsapi.interfaces.InventoryService
import com.travel.vision.ims.imsapi.models.Inventory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.hateoas.server.ExposesResourceFor
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/inventory")
//@ExposesResourceFor(Inventory::class)
class InventoryController @Autowired constructor(
        private val inventoryService: InventoryService
) {
    /*
    @GetMapping("/{warehouse}", produces = [MediaTypes.HAL_JSON_VALUE])
    fun getBooking(@PathVariable("reference") reference: String
    ): ResponseEntity<Inventory> {
    }
    */

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