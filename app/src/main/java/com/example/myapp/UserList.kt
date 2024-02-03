package com.example.myapp

import com.google.gson.annotations.SerializedName

class ListResponse (
    @SerializedName("status"      ) var status      : Boolean?            = null,
    @SerializedName("message"     ) var message     : String?             = null,
    @SerializedName("userList"    ) var userList    : ArrayList<UserList> = arrayListOf(),
    @SerializedName("currentPage" ) var currentPage : Int?                = null,
    @SerializedName("lastPage"    ) var lastPage    : Int?                = null,
    @SerializedName("total"       ) var total       : Int?                = null,
    @SerializedName("perPage"     ) var perPage     : Int?                = null
)

data class UserList (

    @SerializedName("id"           ) var id          : Int?    = null,
    @SerializedName("first_name"   ) var firstName   : String? = null,
    @SerializedName("last_name"    ) var lastName    : String? = null,
    @SerializedName("email"        ) var email       : String? = null,
    @SerializedName("country_code" ) var countryCode : String? = null,
    @SerializedName("phone_no"     ) var phoneNo     : String? = null,
    @SerializedName("status"       ) var status      : String? = null

)