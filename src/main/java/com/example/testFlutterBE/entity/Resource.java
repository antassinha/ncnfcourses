package com.example.testFlutterBE.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "resource")
public class Resource {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Integer resource_id;
  private String name;
  @ManyToOne
  @JoinColumn(name = "course_id")
  private Course course;
  private String resourceUri;
}
