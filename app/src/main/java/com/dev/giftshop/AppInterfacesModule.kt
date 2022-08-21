package com.dev.giftshop

import com.dev.giftshop.data.localapi.IPostsLocalApi
import com.dev.giftshop.data.localapi.IUsersLocalApi
import com.dev.giftshop.data.localapi.PostsLocalApi
import com.dev.giftshop.data.localapi.UsersLocalApi
import com.dev.giftshop.data.repository.IPostsRepository
import com.dev.giftshop.data.repository.IUsersRepository
import com.dev.giftshop.data.repository.PostsRepository
import com.dev.giftshop.data.repository.UsersRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppInterfacesModule {
    //region LocalApi
    @Binds
    abstract fun bindUsersLocalApi(impl: UsersLocalApi): IUsersLocalApi
    @Binds
    abstract fun bindPostsLocalApi(impl: PostsLocalApi): IPostsLocalApi
    //endregion

    //region Repositories
    @Binds
    abstract fun bindPostsRepository(impl: PostsRepository): IPostsRepository
    @Binds
    abstract fun bindUsersRepository(impl: UsersRepository): IUsersRepository
    //endregion
}