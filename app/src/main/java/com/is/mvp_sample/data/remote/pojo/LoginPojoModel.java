package com.is.mvp_sample.data.remote.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Islam on 10/11/2018.
 */

public class LoginPojoModel {


    @Expose
    @SerializedName("user")
    public UserEntity user;
    @Expose
    @SerializedName("uid")
    public String uid;
    @Expose
    @SerializedName("message")
    public String message;
    @Expose
    @SerializedName("status")
    public boolean status;

    public static class UserEntity {
        @Expose
        @SerializedName("created_at")
        public String created_at;
        @Expose
        @SerializedName("email")
        public String email;
        @Expose
        @SerializedName("name")
        public String name;
    }
}
