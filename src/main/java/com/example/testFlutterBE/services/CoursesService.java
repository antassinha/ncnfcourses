package com.example.testFlutterBE.services;

import com.example.testFlutterBE.DTO.requests.AddCoursesRequest;
import com.example.testFlutterBE.DTO.responses.FindResourcesResponse;
import com.example.testFlutterBE.entity.Course;

import java.util.List;

public interface CoursesService {
  Boolean addCourse(AddCoursesRequest addCoursesRequest);
  List<Course> getAllCourses();
  List<FindResourcesResponse> findByCourse(Integer courseId);
}
