package com.xyx.responsibilityPatternChain;

public class ConcreteHandler2 extends Handler {
    @Override
    public void handleRequest(String request) {
        if (request.equals("Request2")) {
            System.out.println("ConcreteHandler2 handled the request.");
        } else if (next != null) {
            next.handleRequest(request);
        }
    }
}