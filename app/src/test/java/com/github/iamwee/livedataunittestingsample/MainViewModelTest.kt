package com.github.iamwee.livedataunittestingsample

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.github.iamwee.livedataunittestingsample.data.RepoDataSource
import com.github.iamwee.livedataunittestingsample.data.UserStorageImpl
import com.github.iamwee.livedataunittestingsample.utils.TestCoroutineContextProvider
import com.github.iamwee.livedataunittestingsample.utils.CoroutineTestRule
import com.github.iamwee.livedataunittestingsample.utils.valueTest
import io.mockk.coEvery
import io.mockk.mockk
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    @Test
    fun getUser() = coroutineTestRule.runBlocking {

        val userStorage = UserStorageImpl()
        val dataSource = mockk<RepoDataSource>()

        coEvery { dataSource.getList() } returns listOf()

        val viewModel = MainViewModel(
            userStorage = userStorage,
            repoDataSource = dataSource,
            contextProvider = TestCoroutineContextProvider.create()
        )

        viewModel.getUser(1.toString())

        Assert.assertEquals("1", viewModel.user.valueTest().id)
        Assert.assertTrue(viewModel.repos.valueTest().isEmpty())
    }

}