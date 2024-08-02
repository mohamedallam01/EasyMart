package com.ecommerce.shared

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform


