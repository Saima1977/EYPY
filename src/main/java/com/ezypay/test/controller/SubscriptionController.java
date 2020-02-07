package com.ezypay.test.controller;

import com.ezypay.test.dto.SubscriptionDto;
import com.ezypay.test.service.SubscriptionService;
import com.ezypay.test.utils.Constants;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/subscription")
@RestController
public class SubscriptionController {
  @Autowired
  SubscriptionService subscriptionService;
  @RequestMapping(Constants.GET_SUBSCRIPTION_BY_ID)
  public SubscriptionDto getSubscriptionById(@PathVariable Integer subscriptionId) {
    return subscriptionService.getSubscriptionById(subscriptionId);
  }
  @RequestMapping(Constants.GET_ALL_SUBSCRIPTIONS)
  public List< SubscriptionDto > getAllSubscriptions() {
    return subscriptionService.getAllSubscriptions();
  }
  @RequestMapping(value = Constants.SAVE_SUBSCRIPTION, method = RequestMethod.POST)
  public void saveSubscription(@RequestBody SubscriptionDto subscriptionDto) {
    subscriptionService.saveSubscription(subscriptionDto);
  }
}