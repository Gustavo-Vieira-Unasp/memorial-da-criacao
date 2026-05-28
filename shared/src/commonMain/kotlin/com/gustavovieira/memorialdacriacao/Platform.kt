package com.gustavovieira.memorialdacriacao

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform