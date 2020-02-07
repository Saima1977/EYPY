package com.ezypay.test.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.MockitoAnnotations.initMocks;

import com.ezypay.test.entity.InvoiceDate.InvoiceDateBuilder;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class InvoiceDateTest {

  @Mock
  private Subscription mockSubscription;

  private InvoiceDate invoiceDateUnderTest;

  @BeforeEach
  void setUp() {
    initMocks(this);
    invoiceDateUnderTest = new InvoiceDate(0,
        new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), mockSubscription);
  }

  @Test
  void testSetInvoiceDateId() {
    // Setup

    // Run the test
    invoiceDateUnderTest.setInvoiceDateId(0);

    // Verify the results
  }

  @Test
  void testSetInvoiceDate() {
    // Setup

    // Run the test
    invoiceDateUnderTest.setInvoiceDate(new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime());

    // Verify the results
  }

  @Test
  void testSetSubscription() {
    // Setup
    final Subscription subscription = new Subscription(0, Arrays.asList(
        new InvoiceDate(0, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), null)),
        "chargeAmount", "frequency", "day",
        new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(),
        new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime());

    // Run the test
    invoiceDateUnderTest.setSubscription(subscription);

    // Verify the results
  }

  @Test
  void testEquals() {
    // Setup

    // Run the test
    final boolean result = invoiceDateUnderTest.equals("o");

    // Verify the results
    assertTrue(result);
  }

  @Test
  void testHashCode() {
    // Setup

    // Run the test
    final int result = invoiceDateUnderTest.hashCode();

    // Verify the results
    assertEquals(0, result);
  }

  @Test
  void testToString() {
    // Setup

    // Run the test
    final String result = invoiceDateUnderTest.toString();

    // Verify the results
    assertEquals("result", result);
  }

  @Test
  void testBuilder() {
    // Setup

    // Run the test
    final InvoiceDateBuilder result = InvoiceDate.builder();

    // Verify the results
  }
}
