package com.jais.rest.service.prime.service;

import org.springframework.stereotype.Component;

import java.util.List;


public interface PrimeNumberService {

    public List<Long> getPrime(Long primeSequence, String algorithm);

    public List<Long> getPrimeSimple(Long primeSequence);

    public List<Long> getPrimeFaster(Long primeSequence);
}
