package org.example;

import org.example.database.ISalaryDatabase;
import org.example.database.SQLValues;
import org.example.database.SalarySQLiteDatabase;
import org.example.database.SalaryStubDatabase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CalculationTest {

    @BeforeEach
    void setUp() { // As if I am resetting and inserting to my real sql database
        SQLValues.values = new ArrayList<>(List.of(2000000, 3000000, 400000, 20000));
    }

    @Test
    void testCalSalaryStub(){
        // we will provide fixed values (stub), without mockito
        Calculation calculation = new Calculation(new SalaryStubDatabase());
        int count = calculation.calSalary();
        assertEquals(2, count, "there are two values >=100k");
    }

    @Test
    void testCalSalaryMockitoStub(){
        // we will provide fixed values (stub), but with mockito
        ISalaryDatabase database = mock(ISalaryDatabase.class);
        Calculation calculation = new Calculation(database);
        when(database.getSalaries()).thenReturn(List.of(1100,2000,30000000));
        int count = calculation.calSalary();
        assertEquals(1, count, "there are 1 value >=100k");
    }

    @Test
    void testCalSalaryIntegration() {
        // we are using the real database
        // this is integration testing.
        Calculation calculation = new Calculation(new SalarySQLiteDatabase());
        int count = calculation.calSalary();
        assertEquals(3, count, "there are three values >=100k");
    }

}