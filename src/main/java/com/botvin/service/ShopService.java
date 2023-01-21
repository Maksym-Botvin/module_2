package com.botvin.service;

import com.botvin.exception.IncorrectLineException;
import com.botvin.model.DeviceType;
import com.botvin.model.MobileTelephone;
import com.botvin.model.SmartTelevision;
import com.botvin.repository.ArrayRepository;
import lombok.Getter;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Random;

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

    public LinkedList<String> readCsvCreateList(final String path) { //FIXME: равильно обробити виняток!
        final LinkedList<String> list = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String str;
            while ((str = br.readLine()) != null) {
                if (str.contains(",,")) {
                    throw new IncorrectLineException(str);
                }
                list.add(str);
            }
        } /*catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }*/ catch (IOException e) {
            throw new RuntimeException(e);
        } /*catch (IncorrectLineException e) {
            throw new RuntimeException(e);
        }*/
        return list;
    }

    public LinkedList<MobileTelephone> listOfTelephones(final LinkedList<String> list) {
        final LinkedList<MobileTelephone> listOfTelephones = new LinkedList<>();
        for (int line = 0; line < list.size(); line++) {
            final String[] words = list.get(line).split(",");
            for (int i = 0; i < words.length; i++) {
                if (words[i].contains("Telephone")) {
                    MobileTelephone telephone = new MobileTelephone();
                    telephone.setDeviceType(DeviceType.TELEPHONE);
                    telephone.setSeries(words[1]);
                    telephone.setModel(words[2]);
                    telephone.setDiagonal(Double.parseDouble(words[3]));
                    telephone.setScreenType(words[4]);
                    telephone.setCountry(words[5]);
                    telephone.setPrice(Double.parseDouble(words[6]));
                    listOfTelephones.add(telephone);
                }
            }
        }
        return listOfTelephones;
    }

    public LinkedList<SmartTelevision> listOfTelevisions(final LinkedList<String> list) {
        final LinkedList<SmartTelevision> listOfTelevisions = new LinkedList<>();
        for (int line = 0; line < list.size(); line++) {
            final String[] words = list.get(line).split(", | ");
            for (int i = 0; i < words.length; i++) {
                if (words[i].contains("Television")) {
                    SmartTelevision television = new SmartTelevision();
                    television.setDeviceType(DeviceType.TELEVISION);
                    television.setSeries(words[1]);
                    television.setModel(words[2]);
                    television.setDiagonal(Double.parseDouble(words[3]));
                    television.setScreenType(words[4]);
                    television.setCountry(words[5]);
                    television.setPrice(Double.parseDouble(words[6]));
                }
            }
        }
        return listOfTelevisions;
    }


}
