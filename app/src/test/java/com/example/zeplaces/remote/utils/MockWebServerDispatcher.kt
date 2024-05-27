package com.example.zeplaces.remote.utils

import com.example.zeplaces.remote.invalidRequestResponse
import com.example.zeplaces.remote.mockOkResponse
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest

class MockWebServerDispatcher {
    internal inner class RequestDispatcher : Dispatcher() {
        override fun dispatch(request: RecordedRequest): MockResponse {
            return MockResponse().setBody(mockOkResponse)
                .addHeader("Content-Type", "application/json")
        }
    }

    internal inner class InvalidRequestDispatcher : Dispatcher() {
        override fun dispatch(request: RecordedRequest): MockResponse {
            return MockResponse().setResponseCode(400)
                .setBody(invalidRequestResponse)
                .addHeader("Content-Type", "application/json")
        }
    }
}