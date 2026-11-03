package org.example.database;

import java.util.ArrayList;
import java.util.List;

public class SalaryStubDatabase implements ISalaryDatabase{
    @Override
    public List<Integer> getSalaries() {
        // my stub
        List<Integer> salaries = new ArrayList<>();
        salaries.add(120000);
        salaries.add(80000);
        salaries.add(150000);
        System.out.println("I am from stub database without mockito");
        return salaries;
    }
}
