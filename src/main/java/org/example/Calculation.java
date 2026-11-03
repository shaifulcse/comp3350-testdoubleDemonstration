package org.example;

import org.example.database.ISalaryDatabase;

import java.util.List;

public class Calculation {

    ISalaryDatabase database;
    public Calculation(ISalaryDatabase database){
        this.database = database;
    }
    public int calSalary(){
        List<Integer> salaries = database.getSalaries();
        int count = 0 ;
        for(Integer salary:salaries){
            if (salary >= 100000){
                count++;
            }
        }
        return count;
    }
}
