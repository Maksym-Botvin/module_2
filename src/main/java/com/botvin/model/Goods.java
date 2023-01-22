package com.botvin.model;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;

@Setter
@Getter
public class Goods {

    private LinkedList<MobileTelephone> mobileTelephoneLinkedList;
    private LinkedList<SmartTelevision> smartTelevisionLinkedList;

    public Goods() {

    }

    public Goods(LinkedList<MobileTelephone> mobileTelephoneLinkedList, LinkedList<SmartTelevision> smartTelevisionLinkedList) {
        this.mobileTelephoneLinkedList = mobileTelephoneLinkedList;
        this.smartTelevisionLinkedList = smartTelevisionLinkedList;
    }
}
