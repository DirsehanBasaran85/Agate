
package com.agate.agate.repository.Entity;

import com.agate.agate.repository.record.client.CreateClient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private int clientId;

    private String name;

    private String address;

    private String contactInformation;


    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "client_campaign",joinColumns = @JoinColumn(name = "client_id"), inverseJoinColumns = @JoinColumn(name = "campaign_id"))
    @JsonIgnore
    private List<Campaign> campaign;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "staff_id")
    @JsonIgnore
    private Staff staff;

    public static Client fromCreate(CreateClient createClient){
        Client client = new Client();
        client.setName(createClient.name());
        client.setAddress(createClient.address());
        client.setContactInformation(createClient.contactInformation());
        return client;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public List<Campaign> getCampaign() {
        return campaign;
    }

    public void setCampaign(List<Campaign> campaign) {
        this.campaign = campaign;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}

