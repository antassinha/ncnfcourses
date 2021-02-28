package com.example.testFlutterBE.repository;

import com.example.testFlutterBE.entity.Course;
import com.example.testFlutterBE.entity.Resource;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ResourceRepository extends CrudRepository<Resource, Integer> {
  List<Resource> findByCourse(Course course);
}
