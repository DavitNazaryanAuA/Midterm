package com.aua.davitnazaryan.midtermapp.model

data class User(
    val email: String,
    val nat: String,
    val name: Name
) {
    data class Name(
        val title: String,
        val first: String,
        val last: String
    )
}
