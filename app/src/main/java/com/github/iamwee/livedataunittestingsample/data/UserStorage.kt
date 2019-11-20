package com.github.iamwee.livedataunittestingsample.data

interface UserStorage {
    fun get(userId: String): User
}

class UserStorageImpl: UserStorage {

    override fun get(userId: String): User {
        return User(
            id = userId,
            fullName = "name [$userId]"
        )
    }
}

