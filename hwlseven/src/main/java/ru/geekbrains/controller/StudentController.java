package ru.geekbrains.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.entity.Student;
import ru.geekbrains.repository.StudentRepository;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping("/all")
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostConstruct
    public void SampleData() {
        studentRepository.save(new Student("Ivan", 33));
        studentRepository.save(new Student("Peter", 23));
        studentRepository.save(new Student("John", 13));
        studentRepository.save(new Student("Mike", 32));
        studentRepository.save(new Student("Soul", 31));

    }

    @GetMapping({"/", "/index","/studentList"})
    public String getAllStudent(Model model) {

        model.addAttribute("students", studentRepository.findAll());

        return "studentList";
    }

    @GetMapping("/add")
    public String addStudent(Model model){
        model.addAttribute("student", new Student());
        return "student_form";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute Student student){
        studentRepository.save(student);
        return "redirect:/studentList";
    }


    @GetMapping("/edit/{id}")
    public String showStudentEditForm(@PathVariable Long id, Model model) {
        Student student =studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student with id: " + id + " doesn't exists (for edit)"));
        model.addAttribute("student", student);
        return "student_form";
    }

    @PostMapping("/edit")
    public String showStudentEditForm(@ModelAttribute Student student) {
        studentRepository.save(student);
        return "redirect:/studentList";
    }

    @GetMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String deleteOneStudentById(@PathVariable Long id) {
        studentRepository.deleteById(id);
        return "ok";
    }








}
