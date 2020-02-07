package com.ezypay.test.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.ezypay.test.dto.InvoiceDateDto;
import com.ezypay.test.entity.InvoiceDate;
import com.ezypay.test.entity.Subscription;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.junit.jupiter.api.Test;

class InvoiceDateConverterTest {

  @Test
  void testDtoToEntity() {
    // Setup
    final InvoiceDateDto invoiceDateDto = new InvoiceDateDto(0,
        new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime());
    final InvoiceDate expectedResult = new InvoiceDate(0,
        new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(),
        new Subscription(0, Arrays.asList(), "chargeAmount", "frequency", "day",
            new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(),
            new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime()));

    // Run the test
    final InvoiceDate result = InvoiceDateConverter.dtoToEntity(invoiceDateDto);

    // Verify the results
    assertEquals(expectedResult, result);
  }

  @Test
  void testEntityToDto() {
    // Setup
    final InvoiceDate invoiceDate = new InvoiceDate(0,
        new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(),
        new Subscription(0, Arrays.asList(), "chargeAmount", "frequency", "day",
            new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(),
            new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime()));
    final InvoiceDateDto expectedResult = new InvoiceDateDto(0,
        new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime());

    // Run the test
    final InvoiceDateDto result = InvoiceDateConverter.entityToDto(invoiceDate);

    // Verify the results
    assertEquals(expectedResult, result);
  }
}
