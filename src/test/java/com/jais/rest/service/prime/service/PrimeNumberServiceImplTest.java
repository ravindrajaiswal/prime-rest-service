package com.jais.rest.service.prime.service;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PrimeNumberServiceImplTest {

  private PrimeNumberServiceImpl service = new PrimeNumberServiceImpl();

  @Test
  public void testCheckPrimeSequence() {
    assertThat(Arrays.asList(1L), is(service.getPrimeSequence(1L)));
  }

  @Test
  public void testCheckPrimeSequenceOne() {
    assertThat(Arrays.asList(1L, 2L), is(service.getPrimeSequence(2L)));
  }

  @Test
  public void testCheckPrimeSequenceTwo() {
    assertThat(Arrays.asList(1L, 2L, 3L, 5L), is(service.getPrimeSequence(5L)));
  }

  @Test
  public void testCheckPrimeSequenceThree() {
    assertThat(Arrays.asList(1L, 2L, 3L, 5L), is(service.getPrimeSequence(6L)));
  }
}
