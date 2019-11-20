package com.github.iamwee.livedataunittestingsample.data

interface RepoDataSource {

    suspend fun getList(): List<Repo>
}

class RepoDataSourceImpl: RepoDataSource {

    override suspend fun getList(): List<Repo> {
        return emptyList()
    }
}

data class Repo(
    val id: Long,
    val name: String
)