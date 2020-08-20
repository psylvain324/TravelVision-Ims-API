package com.travel.vision.imsapi.exceptions

import org.springframework.http.HttpStatus

open class InventoryException(
        code: Int,
        httpStatus: HttpStatus,
        context: Map<String, Any>? = null,
        message: String? = null
) : TravelVisionException(code, httpStatus, context, message) {
    override val namespace: Int = 1000
}