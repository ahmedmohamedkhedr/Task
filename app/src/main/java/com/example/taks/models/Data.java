package com.example.taks.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("api_token")
    @Expose
    private String apiToken;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("mobile")
    @Expose
    private String mobile;
    @SerializedName("outlets")
    @Expose
    private Integer outlets;
    @SerializedName("email_verified_at")
    @Expose
    private Object emailVerifiedAt;
    @SerializedName("user_type")
    @Expose
    private String userType;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("deleted_at")
    @Expose
    private Object deletedAt;
    @SerializedName("time")
    @Expose
    private String time;

    public Integer getId() {
        return id;
    }


    public String getApiToken() {
        return apiToken;
    }


    public String getName() {
        return name;
    }


    public String getEmail() {
        return email;
    }


    public String getMobile() {
        return mobile;
    }


    public Integer getOutlets() {
        return outlets;
    }


    public Object getEmailVerifiedAt() {
        return emailVerifiedAt;
    }


    public String getUserType() {
        return userType;
    }


    public String getCreatedAt() {
        return createdAt;
    }


    public String getUpdatedAt() {
        return updatedAt;
    }


    public Object getDeletedAt() {
        return deletedAt;
    }


    public String getTime() {
        return time;
    }


}
