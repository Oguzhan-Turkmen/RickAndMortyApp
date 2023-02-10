package com.rickandmortyapp.data.api

import com.google.common.truth.Truth.assertThat
import com.rickandmortyapp.SAMPLE_RESPONSE_FILE_NAME
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RickAndMortyApiTest {

    private lateinit var api: RickAndMortyApi

    private val mockWebServer = MockWebServer()

    @Before
    fun setup() {
        mockWebServer.start(8080)
        api = Retrofit.Builder().baseUrl(mockWebServer.url(""))
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(RickAndMortyApi::class.java)
    }

    @Test
    fun when_firstRequest_is_response_NotNull(){
        runBlocking {
            enqueueResponse(SAMPLE_RESPONSE_FILE_NAME)
            val response = api.getCharacters()
            val request = mockWebServer.takeRequest()
            assertThat(response).isNotNull()
        }
    }

    private fun enqueueResponse(fileName: String) {
        javaClass.classLoader?.let {
            val inputStream = it.getResourceAsStream(fileName)
            val source = inputStream.source().buffer()
            val mockResponse = MockResponse()
            mockResponse.setBody(source.readString(Charsets.UTF_8))
            mockWebServer.enqueue(mockResponse)
        }
    }

    @After
    fun shutDown() {
        mockWebServer.shutdown()
    }
}