package com.example.studentbackend.controlerAPI;

import com.example.studentbackend.model.Feedback;
import com.example.studentbackend.repository.FeedbackRepo;
import com.example.studentbackend.repository.RatesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class FeedbackAPI {
    @Autowired
    private FeedbackRepo feedbackRepo;

    @GetMapping("/all")

    public ResponseEntity<?> getFeedback(){

        try{
            List<Feedback> feedbackList =feedbackRepo.findAll();

            if (feedbackList.isEmpty()){

                return  new ResponseEntity<>("no data found", HttpStatus.NOT_FOUND);

            }else {

                return  new ResponseEntity<>(feedbackList, HttpStatus.OK);
            }
        }catch (Exception exception){
            return  new ResponseEntity<>("error",HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/ById{feedbackId}")
    public  ResponseEntity<?>  getByID(@PathVariable int feedbackId){
        try {
            Optional<Feedback> optionalFeedback = feedbackRepo.findById(feedbackId);
            if (optionalFeedback.isPresent()){
                return  new ResponseEntity<>(optionalFeedback,HttpStatus.OK);
            }else {
                return  new ResponseEntity<>("no data found",HttpStatus.NOT_FOUND);
            }
        }catch (Exception exception){
            return  new ResponseEntity<>("error",HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add")
    public  ResponseEntity<?> add(@RequestBody Feedback feedback){
        try {
            Feedback feedback1= feedbackRepo.save(feedback);
            return  new ResponseEntity<>("added",HttpStatus.OK);
        }catch (Exception exception){
            return  new ResponseEntity<>("error",HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/ById{feedbackId}")

    public  ResponseEntity<?> delete(@PathVariable int feedbackId){
        try {
            feedbackRepo.deleteById(feedbackId);
            return  new ResponseEntity<>("deleted",HttpStatus.OK);


        }catch (Exception exception){
            return  new ResponseEntity<>("error",HttpStatus.NOT_FOUND);
        }
    }
}

