package com.glassdoor.test.intern.interfaces;

import java.util.Map;

public interface DaoOperations {
    void readDb();
    void addNewRecord(Map<String, Object> databaseObject);
}
