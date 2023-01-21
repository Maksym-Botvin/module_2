package com.botvin.model;

import com.botvin.util.Time;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Setter
@Getter
public class Order extends Invoice {

    private Time time;

    public Order(List<Objects> objectsList, Customer customer, InvoiceType invoiceType, Time time) {
        super(objectsList, customer, invoiceType);
        this.time = time;
    }

    @Override
    public String toString() {
        return String.format("[%s] [%s] [%s, %s]", getTime(), getCustomer(), getObjectsList(), getInvoiceType());
    }

}
