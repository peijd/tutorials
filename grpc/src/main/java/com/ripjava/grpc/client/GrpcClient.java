package com.ripjava.grpc.client;

import com.ripjava.grpc.HelloRequest;
import com.ripjava.grpc.HelloResponse;
import com.ripjava.grpc.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
    public static void main(String[] args) {

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub
                = HelloServiceGrpc.newBlockingStub(channel);

        HelloResponse helloResponse = stub.hello(
                HelloRequest.newBuilder()
                .setFirstName("ripjava.com")
                .setLastName("gRPC")
                .build());

        System.out.println(helloResponse.getGreeting());

        channel.shutdown();
    }
}