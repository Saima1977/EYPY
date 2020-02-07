package com.ezypay.test.service;

import com.ezypay.test.dto.SubscriptionDto;
import java.util.List;

public interface SubscriptionService {
  SubscriptionDto getSubscriptionById(Integer userId);
  void saveSubscription(SubscriptionDto subscriptionDto);
  List< SubscriptionDto > getAllSubscriptions();
}