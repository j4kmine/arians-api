package com.arians.arians.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
//@Service to indicate that they're holding the business logic.
// Besides being used in the service layer,
// there isn't any other special use for this annotation.
public class StudentService {
    private  final StudentRepository studentRepository ;
    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    public List<Student> getStudent(){
        return studentRepository.findAll();

    }
    public void addNewStudent(Student student){
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if(studentByEmail.isPresent()){
            throw new IllegalStateException("email already taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId){
        boolean exist = studentRepository.existsById(studentId);
        if(!exist){
            throw  new IllegalStateException("Student with id"+studentId+"Does not exist");
        }
        studentRepository.deleteById(studentId);
    }
    @Transactional
    //written at the service level
    //t is used to combine more than one writes
    // on a database as a single atomic operation
    public void updateStudent(
            Long studentId,
            String name,
            String email
    ){
        Student student = studentRepository.findById(studentId).orElseThrow(
                ()-> new IllegalStateException("Student with id"+studentId+"Does not exist")
        );

        if(name != null && name.length() >0 && !Objects.equals(student.getName(),name)){
            student.setName(name);
        }
        if(email != null && email.length() >0 && !Objects.equals(student.getEmail(),email)){
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("email already taken");
            }
            student.setEmail(email);
        }
    }
}
