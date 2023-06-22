package com.example.studentbackend.controlerAPI;

import com.example.studentbackend.model.Student;
import com.example.studentbackend.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Student")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentAPI {
    @Autowired

    private StudentRepo studentRepoo;


    @GetMapping("/all")
    public ResponseEntity<?> getStudent() {
        try {
            List<Student> studentList = studentRepoo.findAll();
            if (studentList.isEmpty()) {
                return new ResponseEntity<>("No Data Found", HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(studentList, HttpStatus.OK);
            }
        } catch (Exception exception) {
            return new ResponseEntity<>("Network Problem", HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/byId{regnumber}")

    public  ResponseEntity<?> getByID(@PathVariable int regnumber){
        try{
            Optional<Student> optionalStudent = studentRepoo.findById(regnumber);


            if(optionalStudent.isPresent()){
                return new ResponseEntity<>(optionalStudent,HttpStatus.OK);

            }else {
                return  new ResponseEntity<>("No Data Found",HttpStatus.NOT_FOUND);
            }
        }catch (Exception exception){
            return  new ResponseEntity<>("System Down",HttpStatus.BAD_REQUEST);
        }

}

@PostMapping("/add")

    public   ResponseEntity<?> addMember(@RequestBody Student student){
        try{
            Student student1 = studentRepoo.save(student);
            return  new ResponseEntity<>("Insrted sucessfull",HttpStatus.OK);
        }
        catch (Exception exception){
            return  new ResponseEntity<>("Everything went wrong",HttpStatus.BAD_REQUEST);
        }
}


@DeleteMapping("/delete{regnumber}")

    public ResponseEntity<?>  delete(@PathVariable int regnumber){
        try{
            studentRepoo.deleteById (regnumber);
            return new  ResponseEntity<>("Input Data",HttpStatus.OK);

        }catch (Exception exception){
            return new ResponseEntity<>("Server Doesnot Exist",HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("change/{id}")
    public ResponseEntity<?> changestudent(@PathVariable int regnumber,@RequestBody Student student){
        try {
            if (studentRepoo.findById(regnumber).isPresent()){
                Student student2 = studentRepoo.save(student);

                student2.setRegnumber(student.getRegnumber());
                student2.setStuname(student.getStuname());
                student2.setProgram(student.getProgram());
                student2.setPassword(student.getPassword());
                student2.setCampus(student.getCampus());
                student2.getGender(student.getGender(student.getGender()));
                student2.getEmail(student.getEmail(student.getEmail()));

                Student changestudent = studentRepoo.save(student2);


                return new  ResponseEntity<>("update",HttpStatus.OK);


            }
            else {
                return  new ResponseEntity<>("not updated",HttpStatus.NOT_FOUND);
            }
        }catch (Exception exception){
            return  new ResponseEntity<>("error",HttpStatus.BAD_REQUEST);
        }
    }

}



