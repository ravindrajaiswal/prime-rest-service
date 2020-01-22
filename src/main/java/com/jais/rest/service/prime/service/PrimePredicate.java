package com.jais.rest.service.prime.service;

import java.util.stream.LongStream;

public class PrimePredicate  {

  public static boolean checkPrime(Long prime) {
    return LongStream.rangeClosed(2, (long) Math.sqrt(prime)).parallel().allMatch(i -> prime % i != 0);
  }
}
