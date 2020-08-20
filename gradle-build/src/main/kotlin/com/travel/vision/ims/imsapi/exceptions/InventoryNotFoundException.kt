package com.travel.vision.ims.imsapi.exceptions

import org.springframework.http.HttpStatus

class InventoryNotFoundException(
        reference: String
) : InventoryException(1001, HttpStatus.NOT_FOUND, mapOf("reference" to reference), "Inventory not found")