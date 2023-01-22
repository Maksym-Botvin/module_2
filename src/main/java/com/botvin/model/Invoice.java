package com.botvin.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Setter
@Getter
public class Invoice {

    private List<Objects> objectsList; // список товарів (Telephone/Television)
    private Customer customer;
    private InvoiceType invoiceType;

    public Invoice() {

    }

    public Invoice(List<Objects> objectsList, Customer customer, InvoiceType invoiceType) {
        this.objectsList = objectsList;
        this.customer = customer;
        this.invoiceType = invoiceType;
    }

    @Override
    public String toString() {
        return "list: " + objectsList + ", invoiceType: " + invoiceType;
    }
}