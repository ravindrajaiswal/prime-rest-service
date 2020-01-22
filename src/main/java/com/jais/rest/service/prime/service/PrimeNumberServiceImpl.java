package com.jais.rest.service.prime.service;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@Component
public class PrimeNumberServiceImpl implements PrimeNumberService {

  @Value("${prime.threshold:1000}")
  private String primeThreshold;

  @Override
  public List<Long> getPrime(Long primeSequence, String algorithm) {
    if(Long.compare(primeSequence, Long.valueOf(primeThreshold)) > 0 || StringUtils.equals("FASTER",algorithm)){
      return getPrimeFaster(primeSequence);
    }
    return getPrimeSimple(primeSequence);
  }

  @Override
  @Cacheable
  public List<Long> getPrimeSimple(Long primeSequence) {
    return LongStream.rangeClosed(1, primeSequence)
        .filter(PrimePredicate::checkPrime)
        .boxed()
        .collect(Collectors.toList());
  }


  @Override
  @Cacheable
  public List<Long> getPrimeFaster(Long primeSequence) {
    return LongStream.rangeClosed(1, primeSequence)
            .parallel()
            .filter(PrimePredicate::checkPrime)
            .boxed()
            .collect(Collectors.toList());
  }
}
