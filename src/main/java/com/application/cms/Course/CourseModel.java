package com.application.cms.Course;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class CourseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long course_id;
    String title;
    String description;
    int creditHours;

}
