package com.example.studentbackend.controlerAPI;

import com.example.studentbackend.model.Student;
import com.example.studentbackend.model.User;
import com.example.studentbackend.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/User")
@CrossOrigin(origins = "http://localhost:3000")
public class UserAPI {

    @Autowired
    public UserRepo  userRepo;
    @GetMapping("/byId{userId}")
    public ResponseEntity<?> getUserId(@PathVariable String userId){
        try {
            Optional<User> optional = userRepo.findById(userId);

            if (optional.isPresent()){
                return  new ResponseEntity<>(optional, HttpStatus.OK);
            }else {
                return  new ResponseEntity<>("not found",HttpStatus.NOT_FOUND);
            }
        }catch (Exception exception){
            return  new ResponseEntity<>("error",HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/add")

    public ResponseEntity<?> addMember(@RequestBody User user){
        try{
            User user2 = userRepo.save(user);
            return new ResponseEntity<>("Inserted sussessful",HttpStatus.OK);
        }
        catch(Exception exception){
            return new ResponseEntity<>("error",HttpStatus.BAD_REQUEST);
        }
    }

    
}

    
    





