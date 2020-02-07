package com.ezypay.test.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTimeConstants;
import org.joda.time.LocalDate;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Subscription implements Serializable {
  private static final long serialVersionUID = 0x62A6DA99AABDA8A8L;
  @Column
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Integer subscriptionId;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<InvoiceDate> invoiceDate= new LinkedList<>();

  @Column
  private String chargeAmount;

  @Column
  private String frequency;

  @Column
  private String day;

  @Column
  private Date startDate;

  @Column
  private Date endDate;

  public Subscription(String chargeAmount, String frequency, String day, List<InvoiceDate> invoiceDate, Date startDate, Date endDate) {
    this.chargeAmount = chargeAmount;
    this.frequency = frequency;
    this.day = day;
    this.invoiceDate = invoiceDate;
    this.startDate = startDate;
    this.endDate = endDate;
  }
}