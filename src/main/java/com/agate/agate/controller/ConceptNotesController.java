package com.agate.agate.controller;

import com.agate.agate.repository.Entity.ConceptNotes;
import com.agate.agate.service.ConceptNotesService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("ConceptNotes")
@Tag(name = "conceptNotes", description = "for Concept Notes")
public class ConceptNotesController {

    ConceptNotesService conceptNotesService;

    public ConceptNotesController(ConceptNotesService conceptNotesService) {this.conceptNotesService = conceptNotesService;}

    @PostMapping("{staffId}")
    public void addConceptNotes(@RequestBody ConceptNotes conceptNotes , @PathVariable ("staffId") int staffId) {

        conceptNotesService.addConceptNotes(conceptNotes, staffId);
    }

    @PutMapping("{id}")
    public void updateConceptNotes(@RequestBody ConceptNotes conceptNotes , @PathVariable ("id") int id){

        conceptNotesService.updateConceptNotes(id, conceptNotes);
    }

    @GetMapping()
    public List<ConceptNotes> getAllConceptNotes() {
        return conceptNotesService.findAllConceptNotes();
    }

    @GetMapping("{id}")
    public Optional<ConceptNotes> getConceptNotes(@PathVariable("id")int id){
        return conceptNotesService.findConceptNotesById(id);
    }

    @DeleteMapping()
    public void deleteConceptNotes () {
        conceptNotesService.deleteConceptNotes();
    }
    @DeleteMapping("{id}")
    public void deleteConceptNotesById (@PathVariable("id")int id){
        conceptNotesService.deleteConceptNotes(id);
    }
}
