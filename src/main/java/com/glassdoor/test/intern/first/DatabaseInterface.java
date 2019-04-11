package com.glassdoor.test.intern.first;

import java.util.Map;

public interface DatabaseInterface {
    public void readDb();
    public void addNewRecord(Map<String, Object> databaseObject);
}
