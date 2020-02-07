package com.ezypay.test.service.impl;

import com.ezypay.test.converter.InvoiceDateConverter;
import com.ezypay.test.converter.SubscriptionConverter;
import com.ezypay.test.dto.InvoiceDateDto;
import com.ezypay.test.dto.SubscriptionDto;
import com.ezypay.test.entity.InvoiceDate;
import com.ezypay.test.repository.SubscriptionRepository;
import com.ezypay.test.service.SubscriptionService;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.joda.time.DateTimeConstants;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Service;

@Service
class SubscriptionServiceimpl implements SubscriptionService {
  @Autowired
  SubscriptionRepository subscriptionRepository;

  @Override
  public SubscriptionDto getSubscriptionById(Integer subscriptionId) {
    return SubscriptionConverter.entityToDto(subscriptionRepository.getOne(subscriptionId));
  }
  @Override
  public void saveSubscription(SubscriptionDto subscriptionDto) {
    List<InvoiceDateDto> listInvoice = getDateList(subscriptionDto.getDay(), subscriptionDto.getStartDate(), subscriptionDto.getEndDate());
    subscriptionDto.setInvoiceDateDtos(listInvoice);
    subscriptionRepository.save(SubscriptionConverter.dtoToEntity(subscriptionDto));
  }
  @Override
  public List< SubscriptionDto > getAllSubscriptions() {
    return subscriptionRepository.findAll().stream().map(SubscriptionConverter::entityToDto).collect(
        Collectors.toList());
  }

  public List<InvoiceDateDto> getDateList(String day, Date stDate, Date enDate){
    Map<String, Integer> dateMap= new HashMap<>();
    List<InvoiceDateDto> listInvoiceDate = new ArrayList<>();

    dateMap.put("SUNDAY", DateTimeConstants.SUNDAY);
    dateMap.put("MONDAY", DateTimeConstants.MONDAY);
    dateMap.put("TUESDAY", DateTimeConstants.TUESDAY);
    dateMap.put("WEDNESDAY", DateTimeConstants.WEDNESDAY);
    dateMap.put("THURSDAY", DateTimeConstants.THURSDAY);
    dateMap.put("FRIDAY", DateTimeConstants.FRIDAY);
    dateMap.put("SATURDAY", DateTimeConstants.SATURDAY);

    LocalDate startDate = new LocalDate(stDate);
    LocalDate endDate = new LocalDate(enDate);
    LocalDate thisDay;
    boolean weekly = false;

    if(dateMap.containsKey(day)) {
      thisDay = startDate.withDayOfWeek(dateMap.get(day));
      weekly = true;
    }
    else
    {
      thisDay = startDate;
    }

    if (startDate.isAfter(thisDay)) {
      startDate = thisDay.plusWeeks(1); // start on next monday
    } else {
      startDate = thisDay; // start on this monday
    }

    String pattern = "dd/MM/yyyy";
    SimpleDateFormat sdf = new SimpleDateFormat(pattern);

    while (startDate.isBefore(endDate)) {
      InvoiceDateDto inDate = new InvoiceDateDto();
      String tmp = null;
      Date tmpDate = new Date();
      try {
        tmp = sdf.format(startDate.toDate());
        tmpDate = new SimpleDateFormat("dd/MM/yyyy").parse(tmp);
      } catch (ParseException e) {
        e.printStackTrace();
      }
      inDate.setInvoiceDate(tmpDate);
      listInvoiceDate.add(inDate);
      if(weekly)
        startDate = startDate.plusWeeks(1);
      else
        startDate = startDate.plusMonths(1);
    }

    return listInvoiceDate;
  }

}