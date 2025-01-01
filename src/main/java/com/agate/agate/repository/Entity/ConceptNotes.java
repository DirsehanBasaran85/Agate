package com.agate.agate.repository.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="conceptNotes")
public class ConceptNotes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private int conceptNotesId;

    private String name;

    private String notes;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "staff_id")
    private Staff Staff;

    public int getConceptNotesId() {return conceptNotesId;}

    public void setConceptNotesID() {this.conceptNotesId = conceptNotesId;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getNotes() {return notes;}

    public void setNotes(String notes) {this.notes = notes;}

    public void setConceptNotesId(int conceptNotesId) {
        this.conceptNotesId = conceptNotesId;
    }

    public Staff getStaff() {
        return Staff;
    }

    public void setStaff(Staff staff) {
        Staff = staff;
    }
}
