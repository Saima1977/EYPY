package com.ezypay.test.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionDto {
  Integer subscriptionId;
  String chargeAmount;
  String frequency;
  String day;
  List<InvoiceDateDto> invoiceDateDtos= new ArrayList<>();
  Date startDate;
  Date endDate;
}
