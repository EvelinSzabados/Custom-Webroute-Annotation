package com.codecool.webserver;

import com.codecool.webroute.RootController;
import com.codecool.webroute.RouteManager;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class WebServer {
    RouteManager routeManager = new RouteManager();

    void start() throws IOException {

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/", new RootController(routeManager));
        server.setExecutor(null);
        server.start();
    }
}
