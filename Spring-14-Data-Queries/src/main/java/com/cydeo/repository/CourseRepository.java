package com.cydeo.repository;

import com.cydeo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.stream.Stream;

public interface CourseRepository extends JpaRepository<Course,Long> {

    //find all courses by category(SELECT * FROM courses WHERE category = "")
    List<Course> findByCategory(String category);

    //find all courses by category and order the entities by name
    List<Course> findByCategoryOrderByName(String category);

    //checks if a course with supplied name exist. return true if exist, false is not
    Boolean existsByName(String name);

    //return the count of courses for given category
    int countByCategory(String category);

    //find all the courses that starts with given course name String
    List<Course> findByNameStartingWith(String pattern);

    //find all courses by category and return a stream
    Stream<Course> streamByCategory(String category);
    @Query("select c from Course c where c.category=:category and c.rating > :rating")
    List<Course> retrieveAllByCategoryAndRatingGreaterThan(@Param("category") String category, @Param("rating") int rating);

}
