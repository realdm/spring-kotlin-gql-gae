package com.springkotlingql.schema.types

data class UserErrors(val message: String, val code: ErrorCode? = null) {
    companion object {
        fun unauthorizedUserErrors(): UserErrors {
            return UserErrors("Unauthorized to perform operation", code = ErrorCode.UNAUTHORIZED)
        }
        
        fun resourceNotFoundErrors(resourceName: String): UserErrors {
            return UserErrors(message = "$resourceName with specified id was not found", code = ErrorCode.NOT_FOUND)
        }
    }
}
