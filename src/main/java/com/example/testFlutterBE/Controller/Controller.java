package com.example.testFlutterBE.Controller;

import com.example.testFlutterBE.DTO.requests.AddCoursesRequest;
import com.example.testFlutterBE.DTO.responses.FindResourcesResponse;
import com.example.testFlutterBE.entity.Course;
import com.example.testFlutterBE.entity.Resource;
import com.example.testFlutterBE.services.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/courses")
public class Controller {

  @Autowired
  CoursesService coursesService;

  @RequestMapping(value = "/1")
  public ResponseEntity<String> testAPI() {
    return ResponseEntity.ok("Works");
  }

  @PostMapping(value ="/add")
  public ResponseEntity<Boolean> addCourses(@RequestBody AddCoursesRequest addCoursesRequest) {
    Boolean result = coursesService.addCourse(addCoursesRequest);
    return ResponseEntity.ok(result);
  }

  @GetMapping(value = "/all")
  public ResponseEntity<List<Course>> getAllCourses() {
    return ResponseEntity.ok().body(coursesService.getAllCourses());
  }

  @GetMapping(value = "/resource/{id}")
  public ResponseEntity<List<FindResourcesResponse>> getResources(@PathVariable("id") Integer id) {
    return ResponseEntity.ok(coursesService.findByCourse(id));
  }
}
