package com.springkotlingql.schema.types.payloads

import com.springkotlingql.schema.types.nodes.Account
import com.springkotlingql.schema.types.UserErrors

data class CreateAccountPayload(val account: Account?, val userErrors: UserErrors?)