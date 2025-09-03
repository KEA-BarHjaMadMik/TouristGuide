package com.example.touristguide.controller;

import com.example.touristguide.model.TouristAttraction;
import com.example.touristguide.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("attractions")

public class TouristController {
    private final TouristService service;

    public TouristController(TouristService service) {
        this.service = service;
    }


    @GetMapping()
    public ResponseEntity<List<TouristAttraction>> getAttractions() {
        List<TouristAttraction> attractions = service.getAttractions();
        return new ResponseEntity<>(attractions, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<TouristAttraction> getAttractionsByName(@PathVariable String name) {
        TouristAttraction attraction = service.findAttractionByName(name);
        if (name != null) {
            return new ResponseEntity<>(attraction, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/add")
    public ResponseEntity<TouristAttraction> addAttraction(@RequestBody TouristAttraction attraction) {
        if (attraction.getName() == null || attraction.getDescription() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(service.addAttraction(attraction), HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<TouristAttraction> updateAttraction(@RequestBody TouristAttraction attraction) {
        if (attraction.getName() == null || attraction.getDescription() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }

        attraction = service.updateAttraction(attraction);

        if (attraction != null) {
            return new ResponseEntity<>(attraction, HttpStatus.ACCEPTED);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/delete/{name}")
    public ResponseEntity<TouristAttraction> deleteAttraction(@PathVariable String name){
        if (name == null){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }

        TouristAttraction attraction = service.deleteAttraction(name);

        if (attraction != null) {
            return new ResponseEntity<>(attraction, HttpStatus.ACCEPTED);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
