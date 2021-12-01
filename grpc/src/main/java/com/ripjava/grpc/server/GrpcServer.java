package com.ripjava.grpc.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;


public class GrpcServer {
    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder
                .forPort(8080)
                .addService(new HelloServiceImpl()).build();

        server.start();
        server.awaitTermination();
    }
}
