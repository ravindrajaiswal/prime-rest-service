package com.jais.rest.service.prime.delegate;

import com.jais.rest.service.prime.api.PrimeNumberController;
import com.jais.rest.service.prime.api.model.PrimeResponse;
import com.jais.rest.service.prime.service.PrimeNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PrimeNumberDelegateImpl implements PrimeNumberController {

  @Autowired private PrimeNumberService primeNumberService;

  @Override
  public ResponseEntity<PrimeResponse> getPrimeResponseByPrimeNumber(Long primeNumber) {

    List<Long> primes = primeNumberService.getPrimeSequence(primeNumber);
    PrimeResponse response = new PrimeResponse();
    response.setInitial(primeNumber);
    response.setPrimes(primes);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
