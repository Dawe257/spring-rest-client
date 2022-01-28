package com.dzhenetl;

import com.dzhenetl.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Communication {

    @Autowired
    private RestTemplate restTemplate;
    public static final String URL = "http://localhost:8080/api/employees";

    public List<Employee> getAllEmployees() {
        ResponseEntity<List<Employee>> response = restTemplate.exchange(
                URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Employee>>() {});
        return response.getBody();
    }

    public Employee getEmployee(int id) {
        return restTemplate.getForObject(URL + "/" + id, Employee.class);
    }

    public void saveEmployee(Employee employee) {
        Integer id = employee.getId();
        if (id == null) {
            ResponseEntity<String> response = restTemplate.postForEntity(URL, employee, String.class);
            System.out.println("New employee was added to DB");
            System.out.println(response.getBody());
        } else {
            restTemplate.put(URL, employee);
            System.out.printf("Employee with ID = %d was updated%n", id);
        }
    }

    public void deleteEmployee(int id) {
        restTemplate.delete(URL + "/" + id);
        System.out.printf("Employee with ID = %d was deleted%n", id);
    }

}
