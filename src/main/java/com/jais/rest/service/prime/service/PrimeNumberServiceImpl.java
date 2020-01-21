package com.jais.rest.service.prime.service;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@Component
public class PrimeNumberServiceImpl implements PrimeNumberService {

  @Override
  public List<Long> getPrimeSequence(Long primeSequence) {
    return LongStream.rangeClosed(1, primeSequence)
        .filter(PrimePredicate::checkPrime)
        .boxed()
        .collect(Collectors.toList());
  }
}
