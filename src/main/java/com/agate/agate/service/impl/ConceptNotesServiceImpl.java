package com.agate.agate.service.impl;

import com.agate.agate.repository.ClientRepository;
import com.agate.agate.repository.ConceptNotesRepository;
import com.agate.agate.repository.Entity.ConceptNotes;
import com.agate.agate.repository.StaffRepository;
import com.agate.agate.service.ConceptNotesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConceptNotesServiceImpl  implements ConceptNotesService {

    ClientRepository clientRepository;
    ConceptNotesRepository conceptNotesRepository;
    StaffRepository staffRepository;

    public ConceptNotesServiceImpl(ConceptNotesRepository conceptNotesRepository, StaffRepository staffRepository, ClientRepository clientRepository) {
        this.conceptNotesRepository = conceptNotesRepository;
        this.staffRepository = staffRepository;
        this.clientRepository = clientRepository;
    }


    @Override
    public void addConceptNotes(ConceptNotes conceptNotes, int staffId) {

        staffRepository.findById(staffId).ifPresent(staff -> {
            conceptNotes.setStaff(staff);
            conceptNotesRepository.save(conceptNotes);
        });
    }

    @Override
    public void updateConceptNotes(int id, ConceptNotes conceptNotes) {
        conceptNotesRepository.findById(id).ifPresent(conceptNotes1 -> {
            conceptNotes1.setName(conceptNotes.getName());
            conceptNotes1.setNotes(conceptNotes.getNotes());
            conceptNotesRepository.save(conceptNotes1);
        });
    }


    @Override
    public List<ConceptNotes> findAllConceptNotes() {
        return conceptNotesRepository.findAll();
    }

    @Override
    public Optional<ConceptNotes> findConceptNotesById(int id) {
        if (conceptNotesRepository.findById(id).isPresent())
            return conceptNotesRepository.findById(id);
        else return Optional.empty();
    }

    @Override
    public void deleteConceptNotes() {
        conceptNotesRepository.deleteAll();
    }

    @Override
    public void deleteConceptNotes(int id) {
        conceptNotesRepository.deleteById(id);
    }
}
