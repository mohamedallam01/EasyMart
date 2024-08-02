package com.ecommerce.domain

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform


