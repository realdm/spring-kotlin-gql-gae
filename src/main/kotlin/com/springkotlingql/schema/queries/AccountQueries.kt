package com.springkotlingql.schema.queries

import com.expediagroup.graphql.generator.scalars.ID
import com.expediagroup.graphql.server.operations.Query
import com.springkotlingql.data.repositories.AccountRepository
import com.springkotlingql.schema.types.Edge
import com.springkotlingql.schema.types.PageInfo
import com.springkotlingql.schema.types.connections.Connection
import com.springkotlingql.schema.types.nodes.Account
import com.springkotlingql.schema.types.nodes.toAccount
import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Component

@Component
class AccountQueries(val accountRepository: AccountRepository) : Query {
    suspend fun account(id: ID): Account {
        return accountRepository.findById(Integer.valueOf(id.value)).map {
            it.toAccount()
        }.awaitSingle()
    }
    
    suspend fun accounts(firstName: String, first: Int, page: Int): Connection<Account> {
        val accounts =
            accountRepository.findByFirstName(firstName, PageRequest.of(page, first)).collectList().awaitSingle()
        return Connection(
            edges = accounts.map { Edge(it.toAccount()) },
            pageInfo = PageInfo(pageSize = first, nextPage = page + 1)
        )
    }
}

