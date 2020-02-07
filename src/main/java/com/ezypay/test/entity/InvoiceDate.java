package com.ezypay.test.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class InvoiceDate {
  @Column
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Integer invoiceDateId;
  @Column
  private Date invoiceDate;
  @ManyToOne
  private Subscription subscription;
}
