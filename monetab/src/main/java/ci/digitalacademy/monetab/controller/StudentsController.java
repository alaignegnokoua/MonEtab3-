package ci.digitalacademy.monetab.controller;

import ci.digitalacademy.monetab.models.Student;
import ci.digitalacademy.monetab.services.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
@Slf4j
@RequestMapping("/students")
public class StudentsController {

    private final StudentService studentService;

    @GetMapping
    public String showStudentPage(Model model) {
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return "students/list";
    }

    @GetMapping("/add")
    public String showAddStudentforms(Model model) {
        log.debug("Request to show student forms");
        model.addAttribute("student", new Student());
        return "students/forms";
    }

    @PostMapping

    public String  saveStudent(Student student) {
        log.debug("Request to save student {}", student);
        studentService.save(student);
        return "redirect:/students";
    }


    @GetMapping("/{id}")
    private String showUpdateStudentforms(Model model, @PathVariable long id) {

        Optional<Student> student=studentService.findOne(id);

        if(student.isPresent()) {
            model.addAttribute("student", student.get());

            return "students/forms";
        } else {
            return "redirect:/students";
        }
    }

    @PostMapping("/delete/{id}")
    public String deletestudent(@PathVariable Long id) {
        log.debug("Request to delete student {}", id);
        studentService.delete(id);
        return "redirect:/students";
    }


}
