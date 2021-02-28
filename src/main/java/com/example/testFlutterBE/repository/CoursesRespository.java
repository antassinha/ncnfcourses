package com.example.testFlutterBE.repository;

import com.example.testFlutterBE.entity.Course;
import org.springframework.data.repository.CrudRepository;

public interface CoursesRespository extends CrudRepository<Course, Integer> {
}
