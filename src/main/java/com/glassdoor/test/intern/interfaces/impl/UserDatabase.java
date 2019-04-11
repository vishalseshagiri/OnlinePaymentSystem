package com.glassdoor.test.intern.interfaces.impl;

import com.glassdoor.test.intern.pymtProcDTO.UserObject;
import com.glassdoor.test.intern.interfaces.DaoOperations;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class UserDatabase implements DaoOperations {
  Map<Integer, UserObject> users;

  public UserDatabase() {
      users = new HashMap<>();
      this.readDb();
  }

  @Override
  public void readDb() {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(
        UserDatabase.class.getClassLoader().getResourceAsStream("user_database.txt")))) {

      String line;
      int lineNumber = 0;
      while ((line = br.readLine()) != null) {
        if (lineNumber > 0) {
          String[] splitLine = line.split("\\|");
          UserObject userObj = new UserObject(splitLine);
          this.users.put(Integer.parseInt(splitLine[0]), userObj);
        }
        lineNumber += 1;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void addNewRecord(Map<String, Object> databaseObject) {
  }

}