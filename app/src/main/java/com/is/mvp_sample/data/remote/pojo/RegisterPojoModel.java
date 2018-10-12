package com.is.mvp_sample.data.remote.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Islam on 10/11/2018.
 */

public class RegisterPojoModel {


    @Expose
    @SerializedName("user")
    private UserEntity user;
    @Expose
    @SerializedName("uid")
    private String uid;
    @Expose
    @SerializedName("error")
    private boolean error;

    public static class UserEntity {
        @Expose
        @SerializedName("created_at")
        private String created_at;
        @Expose
        @SerializedName("email")
        private String email;
        @Expose
        @SerializedName("name")
        private String name;
    }
}
