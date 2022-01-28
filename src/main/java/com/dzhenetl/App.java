package com.dzhenetl;

import com.dzhenetl.configuration.Config;
import com.dzhenetl.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Communication communication = context.getBean(Communication.class);
        List<Employee> allEmployees = communication.getAllEmployees();
        allEmployees.forEach(System.out::println);

        System.out.println("------------------------------------------------------------------------------");

        Employee employee = communication.getEmployee(18);
        System.out.println(employee);

        System.out.println("------------------------------------------------------------------------------");

        Employee employee1 = new Employee("Sveta", "Sokolova", "HR", 550);
        employee1.setId(19);
        employee1.setDepartment("CEO");
        communication.saveEmployee(employee1);
        communication.deleteEmployee(19);


    }
}
