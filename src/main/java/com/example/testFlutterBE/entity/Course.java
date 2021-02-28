package com.example.testFlutterBE.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "course")
public class Course {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  @Column(name = "course_id")
  public Integer course_id;
  @Column(name = "name")
  public String name;
  @OneToMany
  private Set<Resource> resources;
  @Column(name = "description")
  public String description;
  @Column(name = "language")
  public String language;
  @Column(name = "thumbnail")
  public String thumbnail;


}
