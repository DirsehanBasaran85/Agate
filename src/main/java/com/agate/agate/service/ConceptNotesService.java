package com.agate.agate.service;

import com.agate.agate.repository.Entity.ConceptNotes;

import java.util.List;
import java.util.Optional;

public interface ConceptNotesService {

    void addConceptNotes(ConceptNotes conceptNotes , int staffId);

    void updateConceptNotes(int id, ConceptNotes conceptNotes);

    List<ConceptNotes> findAllConceptNotes();

    Optional<ConceptNotes> findConceptNotesById(int id);

    void deleteConceptNotes();

    void deleteConceptNotes(int id);
}
