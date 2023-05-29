package com.prosky.homeworkspringmockito.service;

public class EmployeeAlreadyAddedException extends RuntimeException {
    public EmployeeAlreadyAddedException(String massage) {
        super(massage);
    }
}
