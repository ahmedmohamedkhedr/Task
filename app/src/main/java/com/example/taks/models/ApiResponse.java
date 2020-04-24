package com.example.taks.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiResponse {

    @SerializedName("return")
    @Expose
    private Boolean _return;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private Data data;

    public Boolean getReturn() {
        return _return;
    }


    public String getMessage() {
        return message;
    }


    public Data getData() {
        return data;
    }



}
