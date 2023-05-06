package saxena.vaibhav.springbootrestapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import saxena.vaibhav.springbootrestapi.bean.Student;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    @GetMapping
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(1,"Vaibhav", "Saxena");
        //return new ResponseEntity<>(student, HttpStatus.OK);
        //return ResponseEntity.ok(student);
        return ResponseEntity.ok().header("custom-header", "Vaibhav")
                .body(student);
    }

    @GetMapping("/getstudents")
            public ResponseEntity<List<Student>>  getStudents() {
            List<Student> students = new ArrayList<>();
            students.add(new Student(1, "Vaibhav", "Saxena"));
            students.add(new Student(2, "Karan", "Taneja"));
            students.add(new Student(1, "Aditi", "Singhal"));
            return ResponseEntity.ok(students);
    }

    @GetMapping("{id}")
    public Student studentPathVariable(@PathVariable("id") int id) {
        return new Student(id, "Vaibhav", "Saxena");
    }

    @GetMapping("query")
    public Student studentRequestParam(@RequestParam String id,
                                       @RequestParam String firstName,
                                        @RequestParam String lastName) {
        return new Student(2,"Deepti", "Saxena");
    }

    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    @PutMapping("{id}/update")
    @ResponseStatus(HttpStatus.OK)
    public Student updateStudent(@PathVariable("id") int id, @RequestBody Student student) {
        System.out.println((student.getId()));
        System.out.println((student.getFirstName()));
        System.out.println((student.getLastName()));
        return student;
    }

    @DeleteMapping("{id}/delete")
    @ResponseStatus(HttpStatus.OK)
    public String deleteStudent(@PathVariable("id") int id) {
        System.out.println((id));
        return "Student deleted successfully.";
    }
}
