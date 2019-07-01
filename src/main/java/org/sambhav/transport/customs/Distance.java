package org.sambhav.transport.customs;

import java.io.IOException;

import org.springframework.stereotype.Component;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Component
public class Distance {



    private static final String API_KEY="AIzaSyCciuDWB9tpm809-MLRLplkukkTPrinCzQ";
    OkHttpClient client = new OkHttpClient();


public String calculate(String source ,String destination) throws IOException {
String url="https://maps.googleapis.com/maps/api/distancematrix/json?origins="+source+"&destinations="+destination+"&key="+ API_KEY;
            Request request = new Request.Builder()
                .url(url)
                .build();

            Response response = client.newCall(request).execute();
            return response.body().string();
          }


}