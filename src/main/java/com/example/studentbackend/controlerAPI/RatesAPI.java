package com.example.studentbackend.controlerAPI;

import com.example.studentbackend.model.Rates;
import com.example.studentbackend.repository.RatesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Rates")
@CrossOrigin(origins = "http://localhost:3000")
public class RatesAPI {

    @Autowired
    private RatesRepo ratesRepo;

    @GetMapping("/all")

    public ResponseEntity<?> getRates(){
        try {

            List<Rates> ratesList= ratesRepo.findAll();
            if (ratesList.isEmpty()){
                return  new ResponseEntity<>("no data found", HttpStatus.NOT_FOUND);
            }
            else {
                return  new ResponseEntity<>(ratesList,HttpStatus.OK);
            }

        }catch (Exception exception){
            return  new ResponseEntity<>("error",HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/ById{rateId}")

    public  ResponseEntity<?> getByID(@PathVariable int rateId){
        try {
            Optional<Rates> optionalRates = ratesRepo.findById(rateId);
            if (optionalRates.isPresent()){
                return  new ResponseEntity<>(optionalRates,HttpStatus.OK);
            }else {
                return  new ResponseEntity<>("no data found",HttpStatus.NOT_FOUND);

            }

        }catch (Exception exception){
            return  new ResponseEntity<>("error",HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/ById{rateId}")

    public  ResponseEntity<?> delete (@PathVariable int rateId){
        try {
            ratesRepo.deleteById(rateId);
            return  new ResponseEntity<>("deleted",HttpStatus.OK);
        }catch (Exception exception){
            return  new ResponseEntity<>("error",HttpStatus.NOT_FOUND);
        }


    }
@PostMapping("/add")
    public  ResponseEntity<?> add(@RequestBody Rates rates){
        try {
            Rates rates1=ratesRepo.save(rates);
            return  new ResponseEntity<>("insert",HttpStatus.OK);
        }catch (Exception exception){
            return  new ResponseEntity<>("error",HttpStatus.NOT_FOUND);
        }

}

@PutMapping("/update{rateId}")
    public  ResponseEntity<?> edit (@PathVariable int rateId,@RequestBody Rates rates){
        try {
            if (ratesRepo.findById(rateId).isPresent()){
                rates.setRateId(rateId);
                // rates.setRateId(rateId);
                Rates rates1 =ratesRepo.save(rates);
                return  new ResponseEntity<>(rates1,HttpStatus.OK);
            }else {
                return  new ResponseEntity<>("no data found",HttpStatus.NOT_FOUND);
            }
        }catch (Exception exception){
            return  new ResponseEntity<>("error",HttpStatus.BAD_REQUEST);
        }
}
}
