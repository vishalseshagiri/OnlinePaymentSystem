package com.glassdoor.test.intern.interfaces.impl;

import com.glassdoor.test.intern.interfaces.DaoOperations;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class MerchantDatabase implements DaoOperations {
    public Set<String> merchants;
    public MerchantDatabase() {
        merchants = new HashSet<>();
        readDb();
    }

    @Override
    public void readDb() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                MerchantDatabase.class.getClassLoader().getResourceAsStream("merchant_database.txt")))) {

            String line;
            while ((line = br.readLine()) != null) {
                merchants.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addNewRecord(Map<String, Object> databaseObject) {

    }
}
