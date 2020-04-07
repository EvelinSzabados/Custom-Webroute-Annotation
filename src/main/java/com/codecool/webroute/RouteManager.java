package com.codecool.webroute;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.codecool.webroute.HttpMethod.GET;
import static com.codecool.webroute.HttpMethod.POST;


public class RouteManager {

    @WebRoute(method = GET, path = "/test")
    public void onTest(HttpExchange httpExchange) throws IOException {
        String response = "<html><body><h1>Test response</h1><form action=\"/test2\" method=\"post\"><input type=\"submit\" value=\"Post request\"></input></form></body></html>";
        displayResponse(response, httpExchange);

    }

    @WebRoute(method = POST, path = "/test2")
    public void onTest2(HttpExchange httpExchange) throws IOException {
        String response = "Response on test2 page";
        displayResponse(response, httpExchange);

    }

    private void displayResponse(String response, HttpExchange httpExchange) throws IOException {

        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
