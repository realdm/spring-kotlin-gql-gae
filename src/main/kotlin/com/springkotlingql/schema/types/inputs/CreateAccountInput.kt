package com.springkotlingql.schema.types.inputs

data class CreateAccountInput(val email: String, val firstName: String? = null, val lastName: String?)
