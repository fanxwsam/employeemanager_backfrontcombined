package com.insignia.employeemanager.repo;

import com.insignia.employeemanager.model.Address;
import com.insignia.employeemanager.model.Employee;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author  Sam Fan
 * simulate the database
 * add employee
 * delete employee
 * get all employees
 */

@Component
public class EmployeeRepo {
    private static List<Employee> employees = new ArrayList();

    // initialize 4 employees
    static {
        Address add1 = Address.builder()
                .employeeId(1L)
                .street("1/20 Link Road")
                .city("Sydney")
                .state("NSW")
                .postcode("2000")
                .build();
        Employee emp1 = Employee.builder()
                .id(1L)
                .jobTitle("Manager")
                .firstName("Elijah")
                .surName("Brown")
                .email("elijah_brown@msn.com")
                .phone("0487653876")
                .imageUrl("https://blog.hubspot.com/hubfs/Developer%20centering%20images%20in%20HTML.jpg")
                .address(add1)
                .build();

        Address add2 = Address.builder()
                .employeeId(2L)
                .street("32 Tweed Quadrant")
                .city("Perth")
                .state("WA")
                .postcode("6000")
                .build();
        Employee emp2 = Employee.builder()
                .id(2L)
                .jobTitle("Senior Developer")
                .firstName("Sam")
                .surName("Fan")
                .email("fanxwsam@gmail.com")
                .phone("0431288362")
                .imageUrl("https://media-exp1.licdn.com/dms/image/C5603AQEW-VyB_5pISg/profile-displayphoto-shrink_200_200/0/1546662034738?e=1668038400&v=beta&t=tI5aPgRPeV7F3DUfd3iblRTfz3c1d7Q-JIVcx1mzn4M")
                .address(add2)
                .build();


        Address add3 = Address.builder()
                .employeeId(3L)
                .street("46 Bailey Mead")
                .city("Calga")
                .state("NSW")
                .postcode("2250")
                .build();
        Employee emp3 = Employee.builder()
                .id(3L)
                .jobTitle("Business Analysis")
                .firstName("Alice")
                .surName("Caysie")
                .email("alice_caysie@gmail.com")
                .phone("0431288532")
                .imageUrl("https://media-exp1.licdn.com/dms/image/C5603AQEbMhQeIdJ4nw/profile-displayphoto-shrink_800_800/0/1579430041098?e=1668643200&v=beta&t=1y--EqNX_CJaZofn9e9Fo5gWN3kXLUvbI9qvF82oSAU")
                .address(add3)
                .build();

        Address add4 = Address.builder()
                .employeeId(4L)
                .street("28 High ST")
                .city("Geelong")
                .state("VIC")
                .postcode("3220")
                .build();
        Employee emp4 = Employee.builder()
                .id(4L)
                .jobTitle("Senior Developer")
                .firstName("Tony")
                .surName("Smith")
                .email("tony_smith@gmail.com")
                .phone("0435366595")
                .imageUrl("https://media-exp1.licdn.com/dms/image/C5603AQHlcK4BYdAGjg/profile-displayphoto-shrink_800_800/0/1517657643521?e=1668643200&v=beta&t=yYIx5-SJUycO-w5JPsEIAz87c4tP_Tc6DhP9YnIGcz0")
                .address(add4)
                .build();

        // generate the initial employee list
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        employees.add(emp4);

    }

    // get all employees
    public List<Employee> getEmployees(){
        return employees;
    }


    // delete employee by id
    // the employee will be deleted from the memory
    public void deleteEmployeeById(Long id){
        Employee deletedEmp = this.getEmployees()
                .stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst().get();
        if (deletedEmp != null){
            this.getEmployees().remove(deletedEmp);
        }
    }

    // insert a new employee in the employee list
    // the employee will be added to the employees, in memory
    public Employee addEmployee(Employee employee){
        Long existingMaxId;
        List<Employee> list = this.getEmployees();
        if(this.getEmployees().size() > 0) {
            Employee empWithMaxId = this.getEmployees()
                    .stream()
                    .max(Comparator.comparing(Employee::getId))
                    .orElseThrow(NoSuchElementException::new);
            existingMaxId = empWithMaxId.getId();
        }else {
            existingMaxId = 0L;
        }

        // update Id of the employee
        employee.setId(existingMaxId + 1);
        employee.getAddress().setId(existingMaxId + 1);
        employee.getAddress().setEmployeeId(existingMaxId + 1);

        // add the new employee to the employee list
        this.getEmployees().add(employee);
        return employee;
    }


    public Employee saveEmployee(Employee employee) {
        Long employeeId = employee.getId();

        // update the employee in the employee list
        if(this.getEmployees().size() > 0) {
            Employee existingEmp = this.getEmployees()
                    .stream()
                    .filter(emp -> emp.getId().equals(employeeId))
                    .findFirst()
                    .orElseThrow(NoSuchElementException::new);
            // replace the object and keep the index
            this.getEmployees().set(this.getEmployees().indexOf(existingEmp), employee);
        }

        return employee;
    }
}
