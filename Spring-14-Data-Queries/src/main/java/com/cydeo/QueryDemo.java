package com.cydeo;

import com.cydeo.repository.DepartmentRepository;
import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class QueryDemo implements CommandLineRunner {
    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public QueryDemo(RegionRepository regionRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("---------REGIONS---------------");
        System.out.println("find by country" + regionRepository.findByCountry("Canada"));
        System.out.println("findByCountryContaining" + regionRepository.findByCountryContaining("United"));
        System.out.println("findByCountryContainingOrderByRegion" + regionRepository.findByCountryContainingOrderByRegion("United"));
        System.out.println("findTopByCountry" + regionRepository.findTopByCountry("United States"));
        System.out.println("findTop2ByCountry" + regionRepository.findTop2ByCountry("United States"));
        System.out.println("findTop3ByCountry" + regionRepository.findTop3ByCountry("United States"));
        System.out.println("findTopByCountryContainsOrderByRegio" + regionRepository.findTopByCountryContainsOrderByRegion("United States"));

        System.out.println("---------------DEPARTMENTS------------------");
        System.out.println("Find all departments with furniture" + departmentRepository.findAllByDepartment("Furniture"));
        System.out.println("Find by division" + departmentRepository.findByDivision("Health"));
        System.out.println("find division end with ICS" + departmentRepository.findByDivisionEndingWith("ics"));
        System.out.println("contains HEA" + departmentRepository.findDistinctTop3ByDivisionContaining("Hea"));

        System.out.println("----------EMPLOYEE------------");
        System.out.println("find employee by email" + employeeRepository.findByEmail("amcnee1@google.es"));
        System.out.println("find employee detail" + employeeRepository.retrieveEmployeeDetail("btrow5@technorati.com"));
        System.out.println("salary of employee " + employeeRepository.retrieveEmployeeSalary("btrow5@technorati.com"));
    }
}
