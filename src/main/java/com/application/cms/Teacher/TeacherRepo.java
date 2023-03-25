package com.application.cms.Teacher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TeacherRepo extends JpaRepository<TeacherModel, UUID> {
}
