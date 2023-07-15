package com.example.al_falakmain.data.remote

import com.example.al_falakmain.data.models.dtomodels.dtoLoginModel
import okhttp3.ResponseBody
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface WebServiceInterface {

    @POST("abcurl")
    suspend fun loginAdmin(dtoLoginModel: dtoLoginModel):ResponseBody
}