package com.example.touristguide.controller;

import com.example.touristguide.model.TouristAttraction;
import com.example.touristguide.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String getAttractions(@RequestParam(name="currency", defaultValue = "DKK") String currencyCode, Model model) {
        List<TouristAttraction> attractions = service.getAttractionsInCurrency(currencyCode);

        model.addAttribute("attractions",attractions);
        model.addAttribute("selectedCurrency", currencyCode.toUpperCase());

        return "attractionList";
    }

    @GetMapping("/{name}")
    public ResponseEntity<TouristAttraction> getAttractionsByName(@PathVariable String name) {
        TouristAttraction attraction = service.findAttractionByName(name);
        if (attraction != null) {
            return new ResponseEntity<>(attraction, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{name}/tags")
    public String getAttractionTags(@PathVariable String name, Model model){
        TouristAttraction attraction = service.findAttractionByName(name);
        model.addAttribute("attraction", attraction);
        return "tags";
    }

    @GetMapping("/add")
    public String showAttractionRegistrationForm(Model model) {
        model.addAttribute("attraction", new TouristAttraction());
        model.addAttribute("cities", service.getCities());
        model.addAttribute("tags", service.getTags());
        return "attraction_registration_form";
    }

    @PostMapping("/save")
    public String registerAttraction(@ModelAttribute TouristAttraction attraction) {
        service.addAttraction(attraction);
        return "redirect:/attractions";
    }

    @GetMapping("/{name}/edit")
    public String editAttraction(@PathVariable String name, Model model) {
        TouristAttraction attraction = service.findAttractionByName(name);
        if(attraction == null) {
            throw new IllegalArgumentException("Invalid attraction name");
        }

        model.addAttribute("attraction", attraction);
        model.addAttribute("cities", service.getCities());
        model.addAttribute("tags", service.getTags());
        return "updateAttraction";
    }

    @PostMapping("/update")
    public String updateAttraction(@ModelAttribute TouristAttraction attraction) {
        if (service.updateAttraction(attraction) != null) {
            return "redirect:/attractions";
        }

        throw new IllegalArgumentException("Tourist attraction not found");
    }

    @PostMapping("/{name}/delete")
    public String deleteAttraction(@PathVariable String name){
        if (service.deleteAttraction(name) != null) {
            return "redirect:/attractions";
        }

        throw new IllegalArgumentException("Tourist attraction not found");
    }
}
