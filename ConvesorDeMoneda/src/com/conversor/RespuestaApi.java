package com.conversor;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;
import java.net.http.HttpResponse.BodyHandlers;

public class RespuestaApi {
	public String llamada(String conversor1,String conversor2 ,Double cantidad ) {
		try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://currency-converter-by-api-ninjas.p.rapidapi.com/v1/convertcurrency?have="+conversor1+"&want="+conversor2+"&amount="+cantidad))
                    .header("X-RapidAPI-Key", "7fac5f38ddmsh677b0cf7b7ae985p16fdb3jsnc8bda8c7f876")
                    .header("X-RapidAPI-Host", "currency-converter-by-api-ninjas.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();

            HttpResponse<String> response = HttpClient.newHttpClient().send(request, BodyHandlers.ofString());
            return  response.body();
        } catch (IOException | InterruptedException e) {
            return e+"";
        }
	}
}
