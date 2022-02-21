package java_basic.day4.driver;

import day4.models.Employee;
import java_basic.day4.models.Employee;

import java.io.*;

public class SerializedEmployee {

    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setAge(123);
        employee.setName("Dre Hughes");
        employee.setSsn(123657897);

        writeEmployee(employee);

        Employee serializedEmployee = readEmployee();
        System.out.println(serializedEmployee.toString());

    }

    public static void writeEmployee(Employee employee){
        try{
            OutputStream outFile = new FileOutputStream("employee.ser");
            ObjectOutputStream outputStream = new ObjectOutputStream(outFile);
            outputStream.writeObject(employee);
            outputStream.close();
            outFile.close();
        } catch (FileNotFoundException ex){
            ex.printStackTrace();
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public static Employee readEmployee(){
        Employee employee = new Employee();
        try{
            InputStream inFile = new FileInputStream("employee.ser");
            ObjectInputStream inputStream = new ObjectInputStream(inFile);
            employee = (Employee) inputStream.readObject();
            inputStream.close();
            inFile.close();

        } catch (FileNotFoundException ex){
            ex.printStackTrace();
        } catch (IOException ex){
            ex.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        return employee;
    }

}
