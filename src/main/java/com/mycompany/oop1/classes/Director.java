package com.mycompany.oop1.classes;

import com.mycompany.oop1.Iterator.CustomLinkedList;

public class Director extends Employee {
    private CustomLinkedList<Employee> employees = new CustomLinkedList<Employee>();;

    public Director(String nameSurname, int salary) {
        super(nameSurname, salary);
    }

    public CustomLinkedList<Employee> getEmployee() {
        return employees;
    }

    public int getCost() {
        int _total = 0;
        // * altında çalışan işcilerin maaşlarının toplamı alınıyor
        for (int i = 0; i < employees.size(); i++) {

            _total += employees.get(i).getCost();
        }

        // * işcilerin maaşlarının toplamına kendi maaşı da ekleniyor.
        _total += super.getCost();
        return _total;
    }

    public void add(Employee employee) {
        employees.add(employee);
    }

    public void remove(Employee employee) {
        employee.remove(employee);
    }

    public Employee getEmployee(int employeeIndex) {
        return employees.get(employeeIndex);
    }

    public CustomLinkedList<Employee> getChildren() {
        return employees;
    }
    
    public boolean contains(Employee emp) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getNameSurname().trim().equalsIgnoreCase(emp.getNameSurname().trim())) {
                return true;
            }
        }

        return false;
    }

    private void recursiveMetod(CustomLinkedList<Employee> list, int depth, boolean isCost) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < depth; j++) {
                System.out.print("\t");
            }
            Employee element = list.get(i);
            System.out.print("D " + element.getNameSurname() + " "
                    + ((isCost && element.getClass() == Director.class) ? element.getCost() : element.getSalary())
                    + "\n");
            if (element.getClass() == Director.class) {
                Director el2 = (Director) element;
                if (el2.getChildren().size() > 0) {

                    recursiveMetod(el2.getChildren(), depth + 1, isCost);
                }
            }
        }
    }

    // director ve onun emrinde çalışan işçileri yazdıran metod
    public void displayEmployeeInfo(boolean isCost) {//burdaki gelen isCost boolean'ı maaşların toplam ya da ham şeklinde yazdırılması için kullanılan bir check boolean'ıdır.
        int depth = 1;

        System.out.println(isCost ? "\nToplam maaşlar\n" : "\nHam maaşlar\n");

        System.out.println("D " + getNameSurname() + " " + (isCost ? getCost() : getSalary())); //getCost Toplam maaşları yazdırır getSalary ise işçininham maaşını yazdırır.
        recursiveMetod(employees, depth, isCost); // director altında çalışan director memur olduğu için yazdırma işleminde bir recursive metod gerekli.
    }

}
