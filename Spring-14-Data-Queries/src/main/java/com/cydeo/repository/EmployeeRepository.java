package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    @Query("select e from Employee e where e.email = ?1")
    Employee retrieveEmployeeDetail(String email);

    @Query("select e.salary from Employee e where e.email = ?1 ")
    Integer retrieveEmployeeSalary(String email);

    //Not Equal
    @Query("select e from Employee e where e.salary <> ?1")
    List<Employee> retrieveEmployeeSalaryNotEqual(int salary);

    //Like / Contains /Start with / Ends with
    @Query("select e from Employee e where e.firstName like ?1")
    List<Employee> retrieveEmployeeFirstNameLike(String pattern);

    //Less than
    @Query("select e from Employee e where e.salary < ?1")
    List<Employee> retrieveEmployeeSalaryLessThan(int salary);
    //Greater than
    @Query("select e.firstName from Employee e where e.salary > ?1")
    List<Employee> retrieveEmployeeSalaryGreaterThan(int salary);

    //Between
    @Query("select e from Employee e where e.salary between ?1 and ?2")
    List<Employee> retrieveEmployeeSalaryBetween(int salary1, int salary2);

    //Before
    @Query("select e from Employee e where e.hireDate > ?1")
    List<Employee> retrieveEmployeeHireDateBefore(LocalDate date);

    //NULL
    @Query("select e from Employee e where e.email is null")
    List<Employee> retrieveEmployeeIsNull();

    //Not NULL
    @Query("select e from Employee e where e.email is not null")
    List<Employee> retrieveEmployeeIsNotNull();

    //sorting in asc order
    @Query("select e from Employee e order by e.salary")
    List<Employee> retrieveEmployeeSalaryOrderAsc();

    //sorting in desc order
    @Query("select e from Employee e order by e.salary desc ")
    List<Employee> retrieveEmployeeSalaryOrderDesc();

    //Native query
    @Query(value = "select * from employees where salary = ?1" , nativeQuery = true)
    List<Employee> retrieveEmployeeDetailBySalary(int salary);

    //Named Parameter
    @Query("select e from Employee e where e.salary = :salary")
    List<Employee> retrieveEmployeeSalary(@Param("salary") int salary);





}
