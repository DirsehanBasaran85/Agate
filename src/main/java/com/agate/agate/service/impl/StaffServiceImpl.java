package com.agate.agate.service.impl;

import com.agate.agate.repository.CampaignRepository;
import com.agate.agate.repository.ClientRepository;
import com.agate.agate.repository.Entity.Campaign;
import com.agate.agate.repository.Entity.Client;
import com.agate.agate.repository.Entity.Staff;
import com.agate.agate.repository.StaffRepository;
import com.agate.agate.service.StaffService;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class StaffServiceImpl implements StaffService {

    StaffRepository staffRepository;
    ClientRepository clientRepository;
    CampaignRepository campaignRepository;

    public StaffServiceImpl(StaffRepository staffRepository, ClientRepository clientRepository, CampaignRepository campaignRepository) {
        this.staffRepository = staffRepository;
        this.clientRepository = clientRepository;
        this.campaignRepository = campaignRepository;
    }

    @Override
    public void setStaff(Staff staff) {
        staffRepository.save(staff);
    }

    @Override
    public void updateStaff(int id, Staff staff) {
        staffRepository.findById(id).ifPresent(staff1 -> {
            staff1.setFirstName(staff.getFirstName());
            staff1.setMiddleName(staff.getMiddleName());
            staff1.setLastName(staff.getLastName());
            staff1.setAge(staff.getAge());
            staff1.setGender(staff.getGender()); //?
            staff1.setPosition(staff.getPosition());
            staffRepository.save(staff1);
        });
    }

    @Override
    public void assignStaffToClient(int staffId, int clientId) {
        if (staffRepository.findById(staffId).isPresent() || clientRepository.findById(clientId).isPresent()){
            Staff staff = staffRepository.findById(staffId).get();
            Client client = clientRepository.findById(clientId).get();

            client.setStaff(staff);
            staffRepository.save(staff);

        }
    }

    @Override
    public void assignStaffToCampaign(int staffId, int campaignId) {

        staffRepository.findById(staffId).ifPresent(staff -> {
            campaignRepository.findById(campaignId).ifPresent(campaign -> {
                List<Campaign> campaignList = new ArrayList<>();
                campaignList.add(campaign);
                staff.setCampaigns(campaignList);
                staffRepository.save(staff);
            });
        });
    }

    @Override
    public List<Staff> findAllStaff() {
        return staffRepository.findAll();
    }

    @Override
    public Optional<Staff> findStaffById(int id) {
        if (staffRepository.findById(id).isPresent())
            return staffRepository.findById(id);
        else return Optional.empty();
    }

    @Override
    public void deleteStaff(int id) {
        staffRepository.deleteById(id);
    }
}
