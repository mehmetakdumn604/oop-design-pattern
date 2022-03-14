/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop1;


import com.mycompany.oop1.classes.EmployeeComposite;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author mean
 */
public class Deneme {
  public static void main(String[] args) {

    String txtList = ""; // girdi texte dönüşüyoe
        try {
            File myObj = new File("../oop1/src/main/java/com/mycompany/oop1/girdi.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                txtList += data + "/";
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Böyle bir dosya bulunamadı");
            // e.printStackTrace();
        }
    EmployeeComposite emp = EmployeeComposite.processTxtFile(txtList);

    emp.getEmployeeList();
    emp.getCost();
    
  }
}
