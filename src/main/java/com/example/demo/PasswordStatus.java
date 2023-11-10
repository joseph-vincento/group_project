package com.example.demo;

public record PasswordStatus(String password, int length, boolean isValidPassword) {}