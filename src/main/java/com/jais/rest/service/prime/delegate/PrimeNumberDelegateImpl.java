package com.jais.rest.service.prime.delegate;

import com.jais.rest.service.prime.api.PrimeNumberController;
import com.jais.rest.service.prime.api.model.Algorithm;
import com.jais.rest.service.prime.api.model.PrimeResponse;
import com.jais.rest.service.prime.service.PrimeNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Objects;

@Component
public class PrimeNumberDelegateImpl implements PrimeNumberController {

  @Autowired private PrimeNumberService primeNumberService;

  @Override
  public ResponseEntity<PrimeResponse> getPrimeResponse(@Min(1L) Long primeNumber, @Valid Algorithm algorithm) {
    String algorithmString = "";

    if(Objects.nonNull(algorithm)){
      algorithmString = algorithm.value().toString();
    } else  {
      algorithmString = Algorithm.SIMPLE.toString();
    }

    List<Long> primes = primeNumberService.getPrime(primeNumber,algorithmString);
    PrimeResponse response = new PrimeResponse();
    response.setInitial(primeNumber);
    response.setPrimes(primes);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
