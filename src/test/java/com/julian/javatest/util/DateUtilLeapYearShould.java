package com.julian.javatest.util;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class DateUtilLeapYearShould {

    @Test
    public void return_true_when_year_is_divisible_by_400() {

        assertThat(DateUtil.isLeapYear(1600), is(true));
        assertThat(DateUtil.isLeapYear(2000), is(true));
    }

    @Test
    public void return_false_when_year_is_not_divisible_by_400() {
        assertThat(DateUtil.isLeapYear(2021), is(false));
    }
}