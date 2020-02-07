package com.ezypay.test.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.ezypay.test.entity.Subscription.SubscriptionBuilder;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SubscriptionTest {

  private Subscription subscriptionUnderTest;

  @BeforeEach
  void setUp() {
    subscriptionUnderTest = new Subscription(0,
        Arrays.asList(new InvoiceDate(0, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(),
            new Subscription(0, Arrays.asList(), "chargeAmount", "frequency", "day",
                new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(),
                new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime()))), "chargeAmount",
        "frequency", "day", new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(),
        new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime());
  }

  @Test
  void testSetSubscriptionId() {
    // Setup

    // Run the test
    subscriptionUnderTest.setSubscriptionId(0);

    // Verify the results
  }

  @Test
  void testSetInvoiceDate() {
    // Setup
    final List<InvoiceDate> invoiceDate = Arrays.asList(
        new InvoiceDate(0, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(),
            new Subscription(0, Arrays.asList(), "chargeAmount", "frequency", "day",
                new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(),
                new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime())));

    // Run the test
    subscriptionUnderTest.setInvoiceDate(invoiceDate);

    // Verify the results
  }

  @Test
  void testSetChargeAmount() {
    // Setup

    // Run the test
    subscriptionUnderTest.setChargeAmount("chargeAmount");

    // Verify the results
  }

  @Test
  void testSetFrequency() {
    // Setup

    // Run the test
    subscriptionUnderTest.setFrequency("frequency");

    // Verify the results
  }

  @Test
  void testSetDay() {
    // Setup

    // Run the test
    subscriptionUnderTest.setDay("day");

    // Verify the results
  }

  @Test
  void testSetStartDate() {
    // Setup

    // Run the test
    subscriptionUnderTest.setStartDate(new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime());

    // Verify the results
  }

  @Test
  void testSetEndDate() {
    // Setup

    // Run the test
    subscriptionUnderTest.setEndDate(new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime());

    // Verify the results
  }

  @Test
  void testEquals() {
    // Setup

    // Run the test
    final boolean result = subscriptionUnderTest.equals("o");

    // Verify the results
    assertTrue(result);
  }

  @Test
  void testHashCode() {
    // Setup

    // Run the test
    final int result = subscriptionUnderTest.hashCode();

    // Verify the results
    assertEquals(0, result);
  }

  @Test
  void testToString() {
    // Setup

    // Run the test
    final String result = subscriptionUnderTest.toString();

    // Verify the results
    assertEquals("result", result);
  }

  @Test
  void testBuilder() {
    // Setup

    // Run the test
    final SubscriptionBuilder result = Subscription.builder();

    // Verify the results
  }
}
