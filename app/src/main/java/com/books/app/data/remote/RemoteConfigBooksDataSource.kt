package com.books.app.data.remote

import android.util.Log
import com.books.app.data.models.BookDto
import com.books.app.data.models.JsonData
import com.books.app.data.models.TopBannerSlideDto
import com.books.app.domain.remote.BooksDataSource
import com.google.firebase.Firebase
import com.google.firebase.remoteconfig.remoteConfig
import com.google.firebase.remoteconfig.remoteConfigSettings
import kotlinx.coroutines.tasks.await
import kotlinx.serialization.json.Json

class RemoteConfigBooksDataSource : BooksDataSource {
    private var jsonData: JsonData? = null
    private suspend fun fetchAndCacheData() {
        val remoteConfig = Firebase.remoteConfig
        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 3600
        }
        try {
            remoteConfig.setConfigSettingsAsync(configSettings)
            remoteConfig.fetchAndActivate().await()
            val jsonDataString = remoteConfig.getString("json_data")
            jsonData = Json.decodeFromString(jsonDataString)
            Log.d("MYLOG", "Data fetched and cached successfully")
        } catch (e: Exception) {
            Log.e("MYLOG", "Error fetching data: ${e.message}")
        }
    }

    private suspend fun getJsonData(): JsonData? {
        if (jsonData == null) {
            fetchAndCacheData()
        }
        return jsonData
//        return jsonData ?: throw IllegalStateException("Failed to load data")
    }

    override suspend fun getBooks(): List<BookDto> {
        return getJsonData()?.books ?: emptyList()
    }

    override suspend fun getTopBannerSlides(): List<TopBannerSlideDto> {
        return getJsonData()?.topBannerSlides ?: emptyList()
    }

    override suspend fun getYouWillLikeSection(): List<Long> {
        return getJsonData()?.youWillLikeSection ?: emptyList()
    }
}