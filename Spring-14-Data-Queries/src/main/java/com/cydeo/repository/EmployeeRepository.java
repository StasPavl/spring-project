package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    //Display all employee with email address
    List<Employee> findByEmail(String email);

    //Display all employees with first name -"" and last name - "" also show all employees with an email address - ""
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName, String lastName, String email);

    //Display all employee first name is not - ""
    List<Employee> findByFirstNameIsNot(String firstName);

    //Display all employees where last name start with - ""
    List<Employee> findByLastNameStartingWith(String pattern);

    //Display all employees with salaries higher than ""
    List<Employee>findBySalaryGreaterThan(Integer salary);

    //Display all employees with salaries less than ""
    List<Employee> findBySalaryLessThan(Integer salary);

    //Display all employees that has been hire between "" and ""
    List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);

    //Display all employees where salaries greater and equal to "" and in order salary
    List<Employee> findBySalaryGreaterThanEqualOrderBySalary(Integer salary);

    //Display top 3 employee that is making less than ""
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    //Display all employees that do not have email address
    List<Employee>findByEmailIsNull();

    @Query("select e from Employee e where e.email = 'btrow5@technorati.com'")
    Employee retrieveEmployeeDetail();

    @Query("select e.salary from Employee e where e.email = 'btrow5@technorati.com' ")
    Integer retrieveEmployeeSalary();
}
