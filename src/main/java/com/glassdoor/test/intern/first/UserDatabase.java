package com.glassdoor.test.intern.first;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class UserDatabase implements DatabaseInterface{
  Map<Integer, UserObject> users = new HashMap<Integer, UserObject>();

  public UserDatabase() {
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
//    userNames.put(userid, username);
//    addresses.put(userid, address);
  }

//  public void readDB() {
//    try (BufferedReader br = new BufferedReader(new InputStreamReader(
//        UserDatabase.class.getClassLoader().getResourceAsStream("user_database.txt")))) {
//
//      String line;
//      while ((line = br.readLine()) != null) {
//        String splits[] = line.split("\t");
//        System.out.println(Arrays.toString(splits));
//          userNames.put(Integer.parseInt(splits[0]), splits[1]);
//          addresses.put(Integer.parseInt(splits[0]), splits[2]);
//      }
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//  }
//
//  public void add_new_user(Integer userid, String username, String address) {
//    userNames.put(userid, username);
//    addresses.put(userid, address);
//  }
}