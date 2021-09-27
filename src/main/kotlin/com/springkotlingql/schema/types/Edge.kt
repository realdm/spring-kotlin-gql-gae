package com.springkotlingql.schema.types

import com.springkotlingql.schema.types.nodes.Node

data class Edge<T: Node>(val node: T)
