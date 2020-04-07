package com.codecool.webroute;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.lang.reflect.Method;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;


import java.io.IOException;

public class RootController implements HttpHandler {
    private RouteManager routeManager;

    public RootController(RouteManager routeManager) {
        this.routeManager = routeManager;
    }

    public void handle(HttpExchange t) throws IOException {

        String path = t.getRequestURI().getPath();
        String url = path.split("/").length == 0 ? "/" : "/" + path.split("/")[1];
        HttpMethod httpMethod = t.getRequestMethod().equals("GET") ? HttpMethod.GET : HttpMethod.POST;


        for (Method method : RouteManager.class.getMethods()) {

            if (method.isAnnotationPresent(WebRoute.class)) {
                if(method.getAnnotation(WebRoute.class).method().equals(httpMethod)){
                    if(method.getAnnotation(WebRoute.class).path().equals(url)){
                        try {
                            method.invoke(routeManager,t);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }
    }

}
