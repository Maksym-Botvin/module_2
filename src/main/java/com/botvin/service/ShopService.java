package com.botvin.service;

import com.botvin.exception.IncorrectLineException;
import com.botvin.model.*;
import com.botvin.repository.ArrayRepository;
import lombok.Getter;
import lombok.Setter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Setter
@Getter
public class ShopService {

    private final Random random = new Random();
    private ArrayRepository arrayRepository;

    public ShopService() {// тимчасовий конструктор

    }

    /*public ShopService(ArrayRepository arrayRepository) { // потім використовувати цей
        this.arrayRepository = arrayRepository;
    }*/

    public LinkedList<String> readCsvCreateList(final String path) { //FIXME: щоб можна було вказати відносний шлях
        final LinkedList<String> list = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String s;
            while ((s = br.readLine()) != null) {
                if (s.contains(",,")) {
                    throw new IncorrectLineException(s);//FIXME: правильно обробити виняток!
                }
                list.add(s);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    //TODO: readCsvCreateList замінити на цей "недороблений"
    /*public LinkedList<String> readCsvCreateList1(final String path) {
        final ClassLoader loader = Thread.currentThread().getContextClassLoader();
        final BufferedInputStream input = (BufferedInputStream) loader.getResourceAsStream(path);
        String s;
        while ((s = input.read()) )

    }*/

    public LinkedList<MobileTelephone> listOfTelephones(final LinkedList<String> list) {
        final LinkedList<MobileTelephone> listOfTelephones = new LinkedList<>();
        for (int line = 0; line < list.size(); line++) {
            final String[] words = list.get(line).split(",");//FIXME: "," || ", && \s"
            for (int i = 0; i < words.length; i++) {
                if (words[i].contains("Telephone")) {
                    MobileTelephone telephone = new MobileTelephone();
                    //telephone.setDeviceType(DeviceType.TELEPHONE);
                    telephone.setSeries(words[1]);
                    telephone.setModel(words[2]);
                    //telephone.setDiagonal(Integer.parseInt(words[3]));
                    telephone.setScreenType(words[4]);
                    telephone.setCountry(words[5]);
                    telephone.setPrice(Integer.parseInt(words[6]));
                    listOfTelephones.add(telephone);
                }
            }
        }
        return listOfTelephones;
    }

    public LinkedList<SmartTelevision> listOfTelevisions(final LinkedList<String> list) {
        final LinkedList<SmartTelevision> listOfTelevisions = new LinkedList<>();
        for (int line = 0; line < list.size(); line++) {
            final String[] words = list.get(line).split(",");//FIXME: "," || ", && \s"
            for (int i = 0; i < words.length; i++) {
                if (words[i].contains("Television")) {
                    SmartTelevision television = new SmartTelevision();
                    //television.setDeviceType(DeviceType.TELEVISION);
                    television.setSeries(words[1]);
                    television.setModel(words[2]);
                    television.setDiagonal(Integer.parseInt(words[3]));
                    television.setScreenType(words[4]);
                    television.setCountry(words[5]);
                    television.setPrice(Integer.parseInt(words[6]));
                    listOfTelevisions.add(television);
                }
            }
        }
        return listOfTelevisions;
    }

    public void createOrder(final LinkedList<MobileTelephone> telephones, LinkedList<SmartTelevision> televisions, int limit) {
        final List list = Stream.concat(telephones.stream(), televisions.stream()).toList();// combine telephones and televisions into one List
        Integer sum1 = telephones.stream()
                .mapToInt(x -> x.getPrice())
                .sum();

        Integer sum2 = televisions.stream()
                .mapToInt(x -> x.getPrice())
                .sum();

        List<Goods> goodsList = new ArrayList<>(random.nextInt(1,6));
        goodsList.add((Goods) list.get(random.nextInt(0, list.size())));
        Integer sum = (Integer) goodsList.stream()
                        .mapToInt(x-> x.getMobileTelephoneLinkedList()
                                .stream()
                                .mapToInt(y->y.getPrice())
                                .sum())
                                .sum();

        System.out.println(sum1);
        System.out.println(sum2);
        System.out.println(sum);



        final Object[] objects = new Object[random.nextInt(0, 5)];//generate random array's size of objects
        for (int i = 0; i < objects.length; i++) {
            objects[i] = list.get(random.nextInt(0, list.size()));//add random device to the list
        }
        final List goods = Arrays.asList(objects);//convert array of objects to list of goods
        /*Integer sum2 = goods.stream()
                .filter((s) -> )*/
        /*Integer sum1 = goods.stream()
                .mapToInt()*/

        /*int sum = goods.stream()
                .mapToInt(g -> goods.getClass().getField("Price").s*/




    }




}
