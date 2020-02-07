package com.ezypay.test.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.ezypay.test.dto.InvoiceDateDto;
import com.ezypay.test.dto.SubscriptionDto;
import com.ezypay.test.service.SubscriptionService;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SubscriptionControllerTest {

  private SubscriptionController subscriptionControllerUnderTest;

  @BeforeEach
  void setUp() {
    subscriptionControllerUnderTest = new SubscriptionController();
    subscriptionControllerUnderTest.subscriptionService = mock(SubscriptionService.class);
  }

  @Test
  void testGetSubscriptionById() {
    // Setup
    final SubscriptionDto expectedResult = new SubscriptionDto(0, "chargeAmount", "frequency",
        "day", Arrays
        .asList(new InvoiceDateDto(0, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime())),
        new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(),
        new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime());

    // Configure SubscriptionService.getSubscriptionById(...).
    final SubscriptionDto subscriptionDto = new SubscriptionDto(0, "chargeAmount", "frequency",
        "day", Arrays
        .asList(new InvoiceDateDto(0, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime())),
        new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(),
        new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime());
    when(subscriptionControllerUnderTest.subscriptionService.getSubscriptionById(0))
        .thenReturn(subscriptionDto);

    // Run the test
    final SubscriptionDto result = subscriptionControllerUnderTest.getSubscriptionById(0);

    // Verify the results
    assertEquals(expectedResult, result);
  }

  @Test
  void testGetAllSubscriptions() {
    // Setup
    final List<SubscriptionDto> expectedResult = Arrays.asList(
        new SubscriptionDto(0, "chargeAmount", "frequency", "day", Arrays.asList(
            new InvoiceDateDto(0, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime())),
            new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(),
            new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime()));

    // Configure SubscriptionService.getAllSubscriptions(...).
    final List<SubscriptionDto> subscriptionDtos = Arrays.asList(
        new SubscriptionDto(0, "chargeAmount", "frequency", "day", Arrays.asList(
            new InvoiceDateDto(0, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime())),
            new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(),
            new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime()));
    when(subscriptionControllerUnderTest.subscriptionService.getAllSubscriptions())
        .thenReturn(subscriptionDtos);

    // Run the test
    final List<SubscriptionDto> result = subscriptionControllerUnderTest.getAllSubscriptions();

    // Verify the results
    assertEquals(expectedResult, result);
  }

  @Test
  void testSaveSubscription() {
    // Setup
    final SubscriptionDto subscriptionDto = new SubscriptionDto(0, "chargeAmount", "frequency",
        "day", Arrays
        .asList(new InvoiceDateDto(0, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime())),
        new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(),
        new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime());

    // Run the test
    subscriptionControllerUnderTest.saveSubscription(subscriptionDto);

    // Verify the results
    verify(subscriptionControllerUnderTest.subscriptionService).saveSubscription(
        new SubscriptionDto(0, "chargeAmount", "frequency", "day", Arrays.asList(
            new InvoiceDateDto(0, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime())),
            new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(),
            new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime()));
  }
}
