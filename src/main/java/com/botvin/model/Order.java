package com.botvin.model;

import com.botvin.util.Time;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Order extends Invoice {

    private Time time;

    public Order() {

    }

    public Order(final Invoice invoice, Time time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return String.format("[%s] [%s] [%s, %s]", getTime(), getCustomer(), getObjectsList(), getInvoiceType());
    }

}
