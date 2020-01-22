package com.jais.rest.service.prime.delegate;

import com.jais.rest.service.prime.PrimeServiceApplication;
import com.jais.rest.service.prime.api.model.PrimeResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@SpringBootTest(
    classes = PrimeServiceApplication.class,
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PrimeNumberDelegateImplIT {

  @LocalServerPort private int port;

  @Autowired private TestRestTemplate restTemplate;

  @Test
  public void testPrimeResponse() {
    PrimeResponse primes = new PrimeResponse();
    primes.setInitial(10L);
    primes.setPrimes(Arrays.asList(1L, 2L, 3L, 5L, 7L));
    ResponseEntity<PrimeResponse> responseEntity =
        this.restTemplate.getForEntity(
            "http://localhost:" + port + "/api/v1.0/primes/10", PrimeResponse.class);
      assertEquals(200, responseEntity.getStatusCodeValue());
      assertEquals(primes.getInitial(), responseEntity.getBody().getInitial());
      assertEquals(primes.getPrimes(), responseEntity.getBody().getPrimes());
  }

  @Test
  public void testPrimeResponseOne() {
    PrimeResponse primes = new PrimeResponse();
    primes.setInitial(11L);
    primes.setPrimes(Arrays.asList(1L, 2L, 3L, 5L, 7L,11L));
    ResponseEntity<PrimeResponse> responseEntity =
            this.restTemplate.getForEntity(
                    "http://localhost:" + port + "/api/v1.0/primes/11", PrimeResponse.class);
    assertEquals(200, responseEntity.getStatusCodeValue());
    assertEquals(primes.getInitial(), responseEntity.getBody().getInitial());
    assertEquals(primes.getPrimes(), responseEntity.getBody().getPrimes());
  }



  @Test
  public void testPrimeResponseFaster() {
    PrimeResponse primes = new PrimeResponse();
    primes.setInitial(11L);
    primes.setPrimes(Arrays.asList(1L, 2L, 3L, 5L, 7L,11L));
    ResponseEntity<PrimeResponse> responseEntity =
            this.restTemplate.getForEntity(
                    "http://localhost:" + port + "/api/v1.0/primes/11?algorithm=FASTER", PrimeResponse.class);
    assertEquals(200, responseEntity.getStatusCodeValue());
    assertEquals(primes.getInitial(), responseEntity.getBody().getInitial());
    assertEquals(primes.getPrimes(), responseEntity.getBody().getPrimes());
  }
}
