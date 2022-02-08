package uz.pdp.springjpa_.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springjpa_.model.Student;
import uz.pdp.springjpa_.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    StudentRepository studentRepository;


    //get all student list from database
    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public List<Student> getAllStudentList(){
        return studentRepository.findAll();
    }

    //adding a new student to the database
    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public String addStudent(@RequestBody Student student){
        studentRepository.save(student);
        return "Student has been added!";
    }

    //get by id
    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public Student getStudentById(@PathVariable Integer id){
        Optional<Student> byId = studentRepository.findById(id);
        return byId.orElseGet(Student::new);
    }


    //delete the phone from database
    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
    public String deleteStudentById(@PathVariable Integer id){
        studentRepository.deleteById(id);
        return "Student has been deleted from the system";
    }

}

