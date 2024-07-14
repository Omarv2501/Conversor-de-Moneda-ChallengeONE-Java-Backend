package com.vasquez.api;

import com.google.gson.Gson;
import com.vasquez.exception.RuntimeExceptionAPIConnection;
import com.vasquez.model.MonedaAPI;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * @author Jhonatan Vasquez
 * @version 1.0
 * @since 2024-07-14
 */
public class ExchangeRateAPI {

    private final String EXCHANGE_RATE_API_KEY = "fea24725b1d836de8e1f37a3";
    private final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public MonedaAPI ApiResponse(String from, String to, double amount) {
        /* URL to connect API */
        URI uri = URI.create(BASE_URL + EXCHANGE_RATE_API_KEY + "/pair/" + from + "/" + to + "/" + amount);

        /* Se Instancia Http Client */
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(uri).build();
        HttpResponse<String> response;

        /* Controlamos excepciones */
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String httpResponse = response.body();
            return new Gson().fromJson(httpResponse, MonedaAPI.class);
        }
        catch (RuntimeExceptionAPIConnection e) {
            System.out.println(e.getMessage());
        }
        catch (IOException | InterruptedException e) {
                System.out.println(e.getMessage());
                throw new RuntimeException("Error al usar la API");
        }
        return null;
    }
}
