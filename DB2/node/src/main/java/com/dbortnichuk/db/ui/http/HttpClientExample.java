package com.dbortnichuk.db.ui.http;

import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

/**
 * User: dbortnichuk
 * Date: 2/23/14
 */
public class HttpClientExample {

    public static void main(String[] args) throws URISyntaxException, IOException, HttpException {

        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet("http://localhost:9000/");
        HttpResponse response = client.execute(request);

        // Get the response
        BufferedReader rd = new BufferedReader
                (new InputStreamReader(response.getEntity().getContent()));

        String line = "";
        while ((line = rd.readLine()) != null) {
            System.out.println(line);
        }
    }

}
