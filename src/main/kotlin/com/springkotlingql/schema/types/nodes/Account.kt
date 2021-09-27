package com.springkotlingql.schema.types.nodes

import com.expediagroup.graphql.generator.scalars.ID
import com.springkotlingql.schema.DBAccount

data class Account(
    val id: ID,
    val lastName: String?,
    val createdAt: String,
    val firstName: String?,
    val email: String,
    val displayName: String
) : Node

fun DBAccount.toAccount(): Account {
    return Account(
        email = email,
        lastName = lastName,
        firstName = firstName,
        createdAt = createdAt,
        id = ID(id.toString()),
        displayName = "$firstName $lastName"
    )
}