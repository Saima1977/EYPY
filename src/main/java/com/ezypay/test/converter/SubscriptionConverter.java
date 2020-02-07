package com.ezypay.test.converter;

import com.ezypay.test.dto.InvoiceDateDto;
import com.ezypay.test.dto.SubscriptionDto;
import com.ezypay.test.entity.Subscription;
import java.util.stream.Collectors;

public class SubscriptionConverter {
  public static Subscription dtoToEntity(SubscriptionDto subscriptionDto) {
    Subscription subscription = new Subscription(subscriptionDto.getChargeAmount(), null, null, null, null, null);
    subscription.setFrequency(subscriptionDto.getFrequency());
    subscription.setDay(subscriptionDto.getDay());
    subscription.setInvoiceDate(subscriptionDto.getInvoiceDateDtos().stream().map(InvoiceDateConverter::dtoToEntity).collect(
        Collectors.toList()));
    subscription.setStartDate(subscriptionDto.getStartDate());
    subscription.setEndDate(subscriptionDto.getEndDate());
    return subscription;
  }
  public static SubscriptionDto entityToDto(Subscription subscription) {
    SubscriptionDto subscriptionDto = new SubscriptionDto(subscription.getSubscriptionId(), subscription.getChargeAmount(),
        subscription.getFrequency(), subscription.getDay(), null,null, null);

    subscriptionDto.setInvoiceDateDtos(subscription.getInvoiceDate().stream().map(InvoiceDateConverter::entityToDto).collect(Collectors.toList()));
    subscriptionDto.setStartDate(subscription.getStartDate());
    subscriptionDto.setEndDate(subscription.getEndDate());

    return subscriptionDto;
  }
}