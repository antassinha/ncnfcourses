package com.example.testFlutterBE.services.impl;

import com.example.testFlutterBE.DTO.requests.AddCoursesRequest;
import com.example.testFlutterBE.DTO.responses.FindResourcesResponse;
import com.example.testFlutterBE.entity.Course;
import com.example.testFlutterBE.entity.Resource;
import com.example.testFlutterBE.repository.CoursesRespository;
import com.example.testFlutterBE.repository.ResourceRepository;
import com.example.testFlutterBE.services.CoursesService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CoursesServiceImpl implements CoursesService {

  @Autowired
  CoursesRespository coursesRespository;
  @Autowired
  ResourceRepository resourceRepository;

  @Override
  public Boolean addCourse(AddCoursesRequest addCoursesRequest) {
    Course course = new Course();
    BeanUtils.copyProperties(addCoursesRequest, course);
    course.setThumbnail(addCoursesRequest.getThumbnailUrl());
    coursesRespository.save(course);
    if(Objects.nonNull(addCoursesRequest.getResourceName()) && Objects.nonNull(addCoursesRequest.getResourceUrl())) {
      Resource resource = Resource.builder().resourceUri(addCoursesRequest.getResourceUrl()).name(addCoursesRequest.getName()).course(course).build();
      resourceRepository.save(resource);
    }
    return Boolean.TRUE;

  }

  @Override
  public List<Course> getAllCourses() {
    Iterable<Course> iterable = coursesRespository.findAll();
    List<Course> result =
        StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
    return result;
  }

  @Override
  public List<FindResourcesResponse> findByCourse(Integer courseId) {
    Optional<Course> course = coursesRespository.findById(courseId);
    return course.map(value -> resourceRepository.findByCourse(value).stream().map(FindResourcesResponse::new).collect(Collectors.toList())).orElse(null);
  }
}
