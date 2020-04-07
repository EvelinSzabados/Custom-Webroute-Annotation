package com.codecool.webserver;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        WebServer webServer = new WebServer();
        webServer.start();
    }
}
