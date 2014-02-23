package com.dbortnichuk.db.ui.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;

/**
 * User: dbortnichuk
 * Date: 2/23/14
 */
public class HttpServerExchange implements HttpHandler {

    public static void main(String[] args) throws IOException {
       HttpServer server = HttpServer.create(new InetSocketAddress(9000), 10);
        server.createContext("/", new HttpServerExchange());
        server.start();
        System.out.println("server started. Press any key to stop");
        System.in.read();
        server.stop(0);
        System.out.println("Server stopped");
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        httpExchange.sendResponseHeaders(200, 0);
        PrintWriter out = new PrintWriter(httpExchange.getResponseBody());
        out.write("Hello!");
        out.write("SUP!");
        out.close();
        httpExchange.close();
    }
}
