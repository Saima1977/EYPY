package com.ezypay.test.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.ezypay.test.dto.SubscriptionDto.SubscriptionDtoBuilder;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SubscriptionDtoTest {

  private SubscriptionDto subscriptionDtoUnderTest;

  @BeforeEach
  void setUp() {
    subscriptionDtoUnderTest = new SubscriptionDto(0, "chargeAmount", "frequency", "day",
        Arrays.asList(
            new InvoiceDateDto(0, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime())),
        new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(),
        new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime());
  }

  @Test
  void testSetSubscriptionId() {
    // Setup

    // Run the test
    subscriptionDtoUnderTest.setSubscriptionId(0);

    // Verify the results
  }

  @Test
  void testSetChargeAmount() {
    // Setup

    // Run the test
    subscriptionDtoUnderTest.setChargeAmount("chargeAmount");

    // Verify the results
  }

  @Test
  void testSetFrequency() {
    // Setup

    // Run the test
    subscriptionDtoUnderTest.setFrequency("frequency");

    // Verify the results
  }

  @Test
  void testSetDay() {
    // Setup

    // Run the test
    subscriptionDtoUnderTest.setDay("day");

    // Verify the results
  }

  @Test
  void testSetInvoiceDateDtos() {
    // Setup
    final List<InvoiceDateDto> invoiceDateDtos = Arrays
        .asList(new InvoiceDateDto(0, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime()));

    // Run the test
    subscriptionDtoUnderTest.setInvoiceDateDtos(invoiceDateDtos);

    // Verify the results
  }

  @Test
  void testSetStartDate() {
    // Setup

    // Run the test
    subscriptionDtoUnderTest
        .setStartDate(new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime());

    // Verify the results
  }

  @Test
  void testSetEndDate() {
    // Setup

    // Run the test
    subscriptionDtoUnderTest.setEndDate(new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime());

    // Verify the results
  }

  @Test
  void testEquals() {
    // Setup

    // Run the test
    final boolean result = subscriptionDtoUnderTest.equals("o");

    // Verify the results
    assertTrue(result);
  }

  @Test
  void testHashCode() {
    // Setup

    // Run the test
    final int result = subscriptionDtoUnderTest.hashCode();

    // Verify the results
    assertEquals(0, result);
  }

  @Test
  void testToString() {
    // Setup

    // Run the test
    final String result = subscriptionDtoUnderTest.toString();

    // Verify the results
    assertEquals("result", result);
  }

  @Test
  void testBuilder() {
    // Setup

    // Run the test
    final SubscriptionDtoBuilder result = SubscriptionDto.builder();

    // Verify the results
  }
}
