package com.example.myapplicationthree.model.networking

import com.example.myapplicationthree.model.Payload
import retrofit2.http.GET
import retrofit2.http.Query

interface GovtTrackService {
    //https://www.govtrack.us/api/v2/role?current=true&role_type=senator

    @GET("api/v2/role")
    suspend fun getSenators(@Query("current") current: String, @Query("role_type") roleType: String ): Payload
}