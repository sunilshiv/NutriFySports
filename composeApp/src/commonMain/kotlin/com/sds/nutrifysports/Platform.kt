package com.sds.nutrifysports

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform