package com.github.iamwee.livedataunittestingsample

import androidx.lifecycle.*
import com.github.iamwee.livedataunittestingsample.data.*
import com.github.iamwee.livedataunittestingsample.utils.CoroutineContextProvider
import com.github.iamwee.livedataunittestingsample.utils.CoroutineContextProviderImpl

class MainViewModel(
    private val userStorage: UserStorage,
    private val repoDataSource: RepoDataSource,
    private val contextProvider: CoroutineContextProvider
) : ViewModel() {

    private val userId = MutableLiveData<String>()

    val user: LiveData<User> = Transformations.switchMap(userId) {
        liveData(contextProvider.main) { emit(userStorage.get(it)) }
    }

    val repos: LiveData<List<Repo>> = Transformations.switchMap(userId) {
        liveData(contextProvider.main) { emit(repoDataSource.getList()) }
    }

    fun getUser(userId: String) {
        this.userId.value = userId
    }

    class Factory : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(
                userStorage = UserStorageImpl(),
                repoDataSource = RepoDataSourceImpl(),
                contextProvider = CoroutineContextProviderImpl.create()
            ) as T
        }

    }

}