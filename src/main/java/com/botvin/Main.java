package com.botvin;

import com.botvin.service.ShopService;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        ShopService shopService = new ShopService(); // потім і якості аргументу передати ArrayRepository

        System.out.println();

        LinkedList linkedList = shopService.readCsvCreateList("D:\\Java\\Module_2\\Onl3\\src\\main\\resources\\csv\\data.csv");
        linkedList.forEach(System.out::println);

        System.out.println("~".repeat(20));













    }
}
