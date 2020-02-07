package com.ezypay.test.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.ezypay.test.dto.InvoiceDateDto;
import com.ezypay.test.dto.SubscriptionDto;
import com.ezypay.test.entity.InvoiceDate;
import com.ezypay.test.entity.Subscription;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.junit.jupiter.api.Test;

class SubscriptionConverterTest {

  @Test
  void testDtoToEntity() {
    // Setup
    final SubscriptionDto subscriptionDto = new SubscriptionDto(0, "chargeAmount", "frequency",
        "day", Arrays
        .asList(new InvoiceDateDto(0, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime())),
        new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(),
        new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime());
    final Subscription expectedResult = new Subscription(0, Arrays.asList(
        new InvoiceDate(0, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), null)),
        "chargeAmount", "frequency", "day",
        new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(),
        new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime());

    // Run the test
    final Subscription result = SubscriptionConverter.dtoToEntity(subscriptionDto);

    // Verify the results
    assertEquals(expectedResult, result);
  }

  @Test
  void testEntityToDto() {
    // Setup
    final Subscription subscription = new Subscription(0, Arrays.asList(
        new InvoiceDate(0, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), null)),
        "chargeAmount", "frequency", "day",
        new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(),
        new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime());
    final SubscriptionDto expectedResult = new SubscriptionDto(0, "chargeAmount", "frequency",
        "day", Arrays
        .asList(new InvoiceDateDto(0, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime())),
        new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(),
        new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime());

    // Run the test
    final SubscriptionDto result = SubscriptionConverter.entityToDto(subscription);

    // Verify the results
    assertEquals(expectedResult, result);
  }
}
