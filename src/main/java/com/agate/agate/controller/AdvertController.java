package com.agate.agate.controller;

import com.agate.agate.repository.Entity.Advert;
import com.agate.agate.service.AdvertService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("Advert")
@Tag(name = "Advert", description = "for Adverts")

public class AdvertController {

    AdvertService advertService;

    public AdvertController(AdvertService advertService) {this.advertService = advertService;}

    @PostMapping
    public void addAdvert(@RequestBody Advert advert) {

        advertService.setAdvert(advert);

    }

    @PutMapping("{id}")
    public void updateAdvert(@PathVariable("id") int id, Advert advert) {

        advertService.updateAdvert(id, advert);

    }

    @PutMapping("by/{id}")
    public void setCompletion(@PathVariable("id") int id, String completion) {
        advertService.setCompletion(id, completion);
    }

    @GetMapping()
    public List<Advert> getAllAdverts() {

        return advertService.findAllAdverts();

    }

    @GetMapping("{id}")
    public Optional<Advert> getAdvertById(@PathVariable("id") int id) {

        return advertService.findAdvertById(id);

    }

    @DeleteMapping()
    public void deleteAdverts() {

        advertService.deleteAdverts();

    }

    @DeleteMapping("{id}")
    public void deleteAdvert(@PathVariable("id") int id) {

        advertService.deleteAdvert(id);

    }

}
