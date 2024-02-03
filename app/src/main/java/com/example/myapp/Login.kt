package com.example.myapp

import com.google.gson.annotations.SerializedName

class Login (
    @SerializedName("status"  ) var status  : Boolean? = null,
    @SerializedName("message" ) var message : String?  = null,
    @SerializedName("record"  ) var record  : Record?  = Record()
)

data class Record (

    @SerializedName("id"         ) var id         : Int?    = null,
    @SerializedName("firstName"  ) var firstName  : String? = null,
    @SerializedName("lastName"   ) var lastName   : String? = null,
    @SerializedName("email"      ) var email      : String? = null,
    @SerializedName("phoneNo"    ) var phoneNo    : String? = null,
    @SerializedName("profileImg" ) var profileImg : String? = null,
    @SerializedName("authtoken"  ) var authtoken  : String? = null

)