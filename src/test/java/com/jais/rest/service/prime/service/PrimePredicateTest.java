package com.jais.rest.service.prime.service;


import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PrimePredicateTest {

    @Test
    public void testcheckPrime(){
        assertThat(true, is(PrimePredicate.checkPrime(499L)));

    }

    @Test
    public void testcheckPrimeOne(){
        assertThat(true, is(PrimePredicate.checkPrime(1L)));

    }

    @Test
    public void testcheckPrimeTwo(){
        assertThat(true, is(PrimePredicate.checkPrime(2L)));

    }

    @Test
    public void testcheckPrimeFour(){
        assertThat(false, is(PrimePredicate.checkPrime(4L)));

    }

    @Test
    public void testcheckNotPrime(){
        assertThat(false, is(PrimePredicate.checkPrime(500L)));

    }
}
