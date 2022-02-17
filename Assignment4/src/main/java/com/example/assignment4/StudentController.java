package com.example.assignment4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping(path = "/addStudent")
    public String addStudent(@RequestParam String firstName, @RequestParam String lastName,
                             @RequestParam String email, @RequestParam String address,
                             @RequestParam String city, @RequestParam String postal,
                             @RequestParam String phone){

        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        student.setAddress(address);
        student.setCity(city);
        student.setPostal(postal);
        student.setPhone(phone);
        student.setStudentId(student.getStudentId());
        studentRepository.save(student);

        if(student.getStudentId().equals(studentRepository.existsById(student.getStudentId()))){
            return "I'm sorry, it looks like " + student.getFirstName() + " has already been added to the database.";
        }
        return "Attempt to add " + student.getFirstName() + " to the database was successful. Congratulations!";
    }

    @GetMapping(path = "/listStudents")
    public Iterable<Student> getStudents(){
        return studentRepository.findAll();
    }

    @GetMapping(path = "/viewStudent/{id}")
    public @ResponseBody Student viewStudent(@PathVariable Integer id){
        return studentRepository.findStudentByStudentId(id);
    }
}
