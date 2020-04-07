package com.codecool.webroute;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.codecool.webroute.HttpMethod.GET;

public class RouteManager {

    @WebRoute(method = GET, path = "/test")
    public void onTest(HttpExchange httpExchange) throws IOException {
        InputStream is = httpExchange.getRequestBody();
        is.read();
        String response = "Test response";
        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
        System.out.println("/test works");
    }
}
