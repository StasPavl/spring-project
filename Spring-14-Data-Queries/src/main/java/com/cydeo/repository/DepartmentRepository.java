package com.cydeo.repository;

import com.cydeo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,String> {
    //Display all departments in the furniture department

    List<Department> findAllByDepartment(String department);

    //Display all departments in the Health division

    List<Department> findByDivision(String division);

    List<Department> findByDivisionIs(String division);
    List<Department> findByDivisionEquals(String division);

    //Display all departments with division name ends with 'ics'
    List<Department> findByDivisionEndingWith(String ending);

    //Display top 3 departments with division name includes 'Hea' with out duplicates
    List<Department> findDistinctTop3ByDivisionContaining(String name);
    @Query("select d from Department d where d.division in ?1")
    List<Department> retrieveDepartmentDivision(List<String> divisions);
}
