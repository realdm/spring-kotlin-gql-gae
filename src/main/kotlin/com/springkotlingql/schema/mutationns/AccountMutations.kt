package com.springkotlingql.schema.mutationns

import com.expediagroup.graphql.server.operations.Mutation
import com.springkotlingql.data.entities.Account
import com.springkotlingql.data.repositories.AccountRepository
import com.springkotlingql.schema.types.ErrorCode
import com.springkotlingql.schema.types.UserErrors
import com.springkotlingql.schema.types.inputs.CreateAccountInput
import com.springkotlingql.schema.types.nodes.toAccount
import com.springkotlingql.schema.types.payloads.CreateAccountPayload
import kotlinx.coroutines.reactor.awaitSingle
import org.joda.time.DateTime
import org.springframework.stereotype.Component

@Component
class AccountMutations(val accountRepository: AccountRepository) : Mutation {
    
    suspend fun createAccount(input: CreateAccountInput): CreateAccountPayload {
        val account = Account(
            id = null,
            email = input.email,
            lastName = input.lastName,
            firstName = input.firstName,
            createdAt = DateTime.now().toString()
        )
        val createdAccount = accountRepository.save(account).awaitSingle().toAccount()
        return CreateAccountPayload(account = createdAccount, userErrors = null)
    }
}