package com.julian.javatest.fizzbuzz;

import com.julian.javatest.util.DateUtil;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FizzBuzzTest {
    @Test
    public void return_fizz_if_is_divisible_for_3() {
        assertThat( FizzBuzz.fizzBuzz(3), is("Fizz") );
    }

    @Test
    public void return_fizzbuzz_if_is_divisible_for_3_and_5() {
        assertThat( FizzBuzz.fizzBuzz(15), is("FizzBuzz") );
    }

    @Test
    public void return_buzz_if_is_divisible_for_5() {
        assertThat( FizzBuzz.fizzBuzz(10), is("Buzz") );
    }
}