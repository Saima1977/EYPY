package com.ezypay.test.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.ezypay.test.dto.InvoiceDateDto;
import com.ezypay.test.dto.SubscriptionDto;
import com.ezypay.test.entity.InvoiceDate;
import com.ezypay.test.entity.Subscription;
import com.ezypay.test.repository.SubscriptionRepository;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SubscriptionServiceimplTest {

  private SubscriptionServiceimpl subscriptionServiceimplUnderTest;

  @BeforeEach
  void setUp() {
    subscriptionServiceimplUnderTest = new SubscriptionServiceimpl();
    subscriptionServiceimplUnderTest.subscriptionRepository = mock(
        SubscriptionRepository.class);
  }

  @Test
  void testGetSubscriptionById() {
    // Setup
    final SubscriptionDto expectedResult = new SubscriptionDto(0, "chargeAmount", "frequency",
        "day", Arrays
        .asList(new InvoiceDateDto(0, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime())),
        new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(),
        new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime());

    // Configure SubscriptionRepository.getOne(...).
    final Subscription subscription = new Subscription(0, Arrays.asList(
        new InvoiceDate(0, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), null)),
        "chargeAmount", "frequency", "day",
        new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(),
        new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime());
    when(subscriptionServiceimplUnderTest.subscriptionRepository.getOne(0))
        .thenReturn(subscription);

    // Run the test
    final SubscriptionDto result = subscriptionServiceimplUnderTest.getSubscriptionById(0);

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

    // Configure SubscriptionRepository.save(...).
    final Subscription subscription = new Subscription(0, Arrays.asList(
        new InvoiceDate(0, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), null)),
        "chargeAmount", "frequency", "day",
        new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(),
        new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime());
    when(subscriptionServiceimplUnderTest.subscriptionRepository.save(new Subscription(0, Arrays
        .asList(
            new InvoiceDate(0, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), null)),
        "chargeAmount", "frequency", "day",
        new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(),
        new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime()))).thenReturn(subscription);

    // Run the test
    subscriptionServiceimplUnderTest.saveSubscription(subscriptionDto);

    // Verify the results
  }

  @Test
  void testGetAllSubscriptions() {
    // Setup
    final List<SubscriptionDto> expectedResult = Arrays.asList(
        new SubscriptionDto(0, "chargeAmount", "frequency", "day", Arrays.asList(
            new InvoiceDateDto(0, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime())),
            new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(),
            new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime()));

    // Configure SubscriptionRepository.findAll(...).
    final List<Subscription> subscriptions = Arrays.asList(new Subscription(0, Arrays.asList(
        new InvoiceDate(0, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), null)),
        "chargeAmount", "frequency", "day",
        new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(),
        new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime()));
    when(subscriptionServiceimplUnderTest.subscriptionRepository.findAll())
        .thenReturn(subscriptions);

    // Run the test
    final List<SubscriptionDto> result = subscriptionServiceimplUnderTest.getAllSubscriptions();

    // Verify the results
    assertEquals(expectedResult, result);
  }

  @Test
  void testGetDateList() {
    // Setup
    final List<InvoiceDateDto> expectedResult = Arrays
        .asList(new InvoiceDateDto(0, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime()));

    // Run the test
    final List<InvoiceDateDto> result = subscriptionServiceimplUnderTest
        .getDateList("day", new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(),
            new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime());

    // Verify the results
    assertEquals(expectedResult, result);
  }
}
