package com.springkotlingql.data.repositories

import com.springkotlingql.data.entities.Account
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux

interface AccountRepository : ReactiveCrudRepository<Account, Int> {
    fun findByFirstName(firstName: String, pageable: Pageable): Flux<Account>
}