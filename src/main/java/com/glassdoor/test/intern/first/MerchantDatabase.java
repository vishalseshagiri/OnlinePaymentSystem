package com.glassdoor.test.intern.first;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class MerchantDatabase implements DatabaseInterface {
    public Set<String> merchants = new HashSet<String>();
    public MerchantDatabase() {
        this.readDb();
    }

    @Override
    public void readDb() {
      try (BufferedReader br = new BufferedReader(new InputStreamReader(
        MerchantDatabase.class.getClassLoader().getResourceAsStream("merchant_database.txt")))) {

      String line;
      while ((line = br.readLine()) != null) {
//        String splits[] = line.split("\t");
//        System.out.println(Arrays.toString(splits));
//        userNames.put(Integer.parseInt(splits[0]), splits[1]);
//        addresses.put(Integer.parseInt(splits[0]), splits[2]);
          this.merchants.add(line);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    }

    @Override
    public void addNewRecord(Map<String, Object> databaseObject) {

    }
}
