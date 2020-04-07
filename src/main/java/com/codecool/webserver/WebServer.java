package com.codecool.webserver;

import com.codecool.webroute.RootController;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class WebServer {

    void start() throws IOException {

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/", new RootController());
        server.setExecutor(null);
        server.start();
    }
}
