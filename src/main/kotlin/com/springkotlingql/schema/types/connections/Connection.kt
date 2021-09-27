package com.springkotlingql.schema.types.connections

import com.springkotlingql.schema.types.Edge
import com.springkotlingql.schema.types.PageInfo
import com.springkotlingql.schema.types.nodes.Node

data class Connection<T : Node>(val edges: List<Edge<T>>, val pageInfo: PageInfo) {
    companion object {
        fun <T : Node> emptyConnection(): Connection<T> {
            return Connection<T>(edges = emptyList(), pageInfo = PageInfo(pageSize = 0, nextPage = -1))
        }
    }
}