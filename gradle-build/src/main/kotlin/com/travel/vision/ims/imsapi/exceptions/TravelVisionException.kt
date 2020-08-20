package com.travel.vision.ims.imsapi.exceptions

import com.fasterxml.jackson.annotation.JsonInclude
import org.springframework.http.HttpStatus

abstract class TravelVisionException(
        private val code: Int,
        val httpStatus: HttpStatus,
        val context: Map<String, Any>? = null,
        override val message: String? = null,
        override val cause: Throwable? = null
) :
        Exception(message, cause) {

    abstract val namespace: Int

    fun code(): Int =
            namespace.xor(code)
}

data class TravelVisionError(
        val code: Int,
        val message: String,
        @field: JsonInclude(JsonInclude.Include.NON_NULL)
        val context: Map<String, Any>? = null
) {
    companion object {
        fun fromTravelVisionException(travelVisionException: TravelVisionException): TravelVisionError {
            return TravelVisionError(travelVisionException.namespace + travelVisionException.code(), travelVisionException.message!!, travelVisionException.context)
        }
    }
}