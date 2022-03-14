/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.mycompany.oop1.Iterator.CustomLinkedList;
import com.mycompany.oop1.classes.Director;
import com.mycompany.oop1.classes.Employee;
import com.mycompany.oop1.classes.Officer;

/**
 *
 * @author mean
 */
public class oop1test {

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void displayEmployee() {
        Employee employee = new Officer("", 80);
        assertNotNull(employee, "Employee nesnesi null !..");
    }

    @Test
    public void calculateSalary() {
        Director director = new Director("Ugur Guclu", 2000);
        director.add(new Officer("Emre Kosar", 700));
        director.add(new Officer("Ahmet Egeli", 700));

        // expected 700 + 700 + 2000 = 3400
        assertEquals(3400, director.getCost(), "Beklenilen maaş fiyatı sağlanamadı.");
    }

    @Test 
    public void checkEmpty() {
        CustomLinkedList<Employee> customLinkedList = new CustomLinkedList<Employee>();
        assertNotEquals(0,customLinkedList.size(), "Bu liste boş");
        customLinkedList.add(new Officer("", 80));
        assertEquals(0,customLinkedList.size(), "Bu liste boş değil");
    }
}
