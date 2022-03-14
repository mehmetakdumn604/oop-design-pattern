package com.mycompany.oop1.classes;

public abstract class Employee {
    private String nameSurname;
    private int salary;

    public Employee(String nameSurname, int salary) {
        this.nameSurname = nameSurname;
        this.salary = salary;
    }

    public String getNameSurname() {
        return this.nameSurname;
    }

    public String getName() {
        return this.nameSurname.split(" ")[0].trim();
    }

    public int getCost() {
        return this.salary;
    }

    public int getSalary() {
        return this.salary;
    }

    public void add(Employee employee) {
        throw new UnsupportedOperationException();

    }

    public void remove(Employee employee) {
        throw new UnsupportedOperationException();

    }

    public Employee getEmployee(int employeeIndex) {
        throw new UnsupportedOperationException();

    }

    public void displayEmployeeInfo(boolean isCost) {
        throw new UnsupportedOperationException();

    }

}
