package com.arians.arians.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
// indicate that the class provides the mechanism for storage,
// retrieval, update, delete and search operation on objects
public interface StudentRepository extends JpaRepository<Student,Long> {

    @Query("Select s from Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
}
