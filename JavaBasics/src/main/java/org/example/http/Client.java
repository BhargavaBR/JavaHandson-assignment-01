package org.example.http;

import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;


public class Client {

    OkHttpClient okhttpClient;

    public Client() {
        okhttpClient = new OkHttpClient();
    }
    public String get(String url){
        Request request = new Request.Builder().url(url).build();
        try{
            return okhttpClient.newCall(request).execute().body().toString();
        }catch(IOException ioe){
            System.out.println("Error"+ioe.getMessage());
            return null;
        }
    }
}
