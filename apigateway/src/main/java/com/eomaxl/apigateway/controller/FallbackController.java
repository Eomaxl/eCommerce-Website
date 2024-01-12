package com.eomaxl.apigateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/orderServiceFallback")
    public String orderServiceFallback() {
        return "Order Service is taking too long to respond or is down. Please try again later";
    }

    @GetMapping("/paymentServiceFallback")
    public String paymentServiceFallback() {
        return "Payment Service is taking too long to respond or is down. Please try again later";
    }

    @GetMapping("/productServiceFallback")
    public String productServiceFallback() {
        return "Product Service is taking too long to respond or is down. Please try again later";
    }

    @GetMapping("/authServiceFallback")
    public String authServiceFallback() {
        return "Auth Service is taking too long to respond or is down. Please try again later";
    }
}
