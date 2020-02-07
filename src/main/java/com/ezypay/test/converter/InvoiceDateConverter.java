package com.ezypay.test.converter;

import com.ezypay.test.dto.InvoiceDateDto;
import com.ezypay.test.entity.InvoiceDate;

public class InvoiceDateConverter {
  public static InvoiceDate dtoToEntity(InvoiceDateDto invoiceDateDto) {
    InvoiceDate invoiceDate = new InvoiceDate();
    invoiceDate.setInvoiceDateId(invoiceDateDto.getInvoiceDateId());
    invoiceDate.setInvoiceDate(invoiceDateDto.getInvoiceDate());
    return invoiceDate;
  }

  public static InvoiceDateDto entityToDto(InvoiceDate invoiceDate) {
    return new InvoiceDateDto(invoiceDate.getInvoiceDateId(), invoiceDate.getInvoiceDate());
  }
}
