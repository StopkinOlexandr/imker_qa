package com.imker.fw;

import com.imker.model.Contact;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

  @DataProvider
  public Iterator<Object[]> addContact() {

    List<Object[]> list = new ArrayList<>();
    list.add(new Object[]{"Oliver","Kan","1234567890","kan@gm.com","Berlin","goalkeeper"});
    list.add(new Object[]{"Oliver","Kan","12345678912","kan+1@gm.com","Berlin","goalkeeper"});
    list.add(new Object[]{"Oliver","Kan","12345678913","kan+2@gm.com","Berlin","goalkeeper"});

    return list.iterator();
  }

  @DataProvider
  public Iterator<Object[]> addContactFromCsvFile() throws IOException {

    List<Object[]> list = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact.csv")));

    String line = reader.readLine();

    while (line!=null) {
      String[] split = line.split(",");

      list.add(new Object[]{new Contact().setName(split[0]).setLastname(split[1]).setPhone(split[2])
          .setEmail(split[3]).setAddress(split[4]).setDesc(split[5])});
      line = reader.readLine();
    }

    return list.iterator();
  }

  @DataProvider
  public Iterator<Object[]> addContactNegativeFromCsvFile() throws IOException {

    List<Object[]> list = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/ContactWrongPhoneNumber.csv")));

    String line = reader.readLine();

    while (line!=null) {
      String[] split = line.split(",");

      list.add(new Object[]{new Contact().setName(split[0]).setLastname(split[1]).setPhone(split[2])
          .setEmail(split[3]).setAddress(split[4]).setDesc(split[5])});
      line = reader.readLine();
    }

    return list.iterator();
  }
}