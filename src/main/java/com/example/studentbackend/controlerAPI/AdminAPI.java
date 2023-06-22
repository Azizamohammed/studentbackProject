package com.example.studentbackend.controlerAPI;


import com.example.studentbackend.model.Administrator;
import com.example.studentbackend.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Administrator")
public class AdminAPI {


    @Autowired

    public AdminRepo adminRepo;
    @GetMapping("/all")


    public ResponseEntity<?> getAdmin(){
        try {

            List<Administrator> administratorList =adminRepo.findAll();

            if (administratorList.isEmpty()){
                return  new ResponseEntity<>("no data found", HttpStatus.NOT_FOUND);
            }else {
                return  new ResponseEntity<>(administratorList,HttpStatus.OK);
            }
        }catch (Exception exception){
            return  new ResponseEntity<>("error",HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/ById{admId}")


    public  ResponseEntity<?> getByID(@PathVariable int admId){
        try {
            Optional<Administrator> optionalAdministrator= adminRepo.findById(admId);
            if (optionalAdministrator.isPresent()){
                return  new ResponseEntity<>(optionalAdministrator,HttpStatus.OK);
            }else {
                return  new ResponseEntity<>("no data found",HttpStatus.NOT_FOUND);
            }
        }catch (Exception exception){
            return  new ResponseEntity<>("error",HttpStatus.BAD_REQUEST);
        }
    }

@PostMapping("/add")

    public  ResponseEntity<?> add(@RequestBody Administrator administrator){
        try {
            Administrator administrator1 =adminRepo.save(administrator);
            return  new ResponseEntity<>("inserted",HttpStatus.OK);
        }catch (Exception exception){
            return  new ResponseEntity<>("error",HttpStatus.NOT_FOUND);
        }
}


@DeleteMapping("/byId{admId}")


    public  ResponseEntity<?> delete (@PathVariable int admId){
        try {
            adminRepo.deleteById(admId);
            return  new ResponseEntity<>("not deleted",HttpStatus.OK);
        }catch (Exception exception){
            return  new ResponseEntity<>("error",HttpStatus.NOT_FOUND);
        }
}
}
