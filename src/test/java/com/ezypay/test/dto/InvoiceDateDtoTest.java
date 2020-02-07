package com.ezypay.test.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.ezypay.test.dto.InvoiceDateDto.InvoiceDateDtoBuilder;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InvoiceDateDtoTest {

  private InvoiceDateDto invoiceDateDtoUnderTest;

  @BeforeEach
  void setUp() {
    invoiceDateDtoUnderTest = new InvoiceDateDto(0,
        new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime());
  }

  @Test
  void testSetInvoiceDateId() {
    // Setup

    // Run the test
    invoiceDateDtoUnderTest.setInvoiceDateId(0);

    // Verify the results
  }

  @Test
  void testSetInvoiceDate() {
    // Setup

    // Run the test
    invoiceDateDtoUnderTest
        .setInvoiceDate(new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime());

    // Verify the results
  }

  @Test
  void testEquals() {
    // Setup

    // Run the test
    final boolean result = invoiceDateDtoUnderTest.equals("o");

    // Verify the results
    assertTrue(result);
  }

  @Test
  void testHashCode() {
    // Setup

    // Run the test
    final int result = invoiceDateDtoUnderTest.hashCode();

    // Verify the results
    assertEquals(0, result);
  }

  @Test
  void testToString() {
    // Setup

    // Run the test
    final String result = invoiceDateDtoUnderTest.toString();

    // Verify the results
    assertEquals("result", result);
  }

  @Test
  void testBuilder() {
    // Setup

    // Run the test
    final InvoiceDateDtoBuilder result = InvoiceDateDto.builder();

    // Verify the results
  }
}
