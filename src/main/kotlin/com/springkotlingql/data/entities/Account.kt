package com.springkotlingql.data.entities

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("accounts")
data class Account(
    @Id val id: Int?,
    @Column("email") val email: String,
    @Column("last_name") val lastName: String?,
    @Column("created_at") val createdAt: String,
    @Column("first_name") val firstName: String?
)