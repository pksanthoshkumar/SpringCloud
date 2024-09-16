package com.example.cloud.domain;

public record Account (String id, String clientId, Currency currency, Float balance, String status) {}