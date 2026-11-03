package org.example.database;

import java.util.ArrayList;
import java.util.List;

public class SalarySQLiteDatabase implements ISalaryDatabase{

    @Override
    public List<Integer> getSalaries(){
        List<Integer> salaries = new ArrayList<>();
        // consider it as real database code
        // SQL query to get values
        System.out.println("I am from real database");
        return SQLValues.values;

    }

}
