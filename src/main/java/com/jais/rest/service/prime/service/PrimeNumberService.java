package com.jais.rest.service.prime.service;

import org.springframework.stereotype.Component;

import java.util.List;


public interface PrimeNumberService {

    public List<Long> getPrimeSequence(Long primeSequence);
}
