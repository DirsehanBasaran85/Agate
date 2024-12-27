package com.agate.agate.service.impl;

import com.agate.agate.repository.ClientRepository;
import com.agate.agate.repository.Entity.Campaign;
import com.agate.agate.repository.Entity.Client;
import com.agate.agate.repository.Entity.Staff;
import com.agate.agate.repository.StaffRepository;
import com.agate.agate.service.StaffService;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class StaffServiceImpl implements StaffService {

    StaffRepository staffRepository;
    ClientRepository clientRepository;

    public StaffServiceImpl(StaffRepository staffRepository, ClientRepository clientRepository) {
        this.staffRepository = staffRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public void setStaff(Staff staff) {
        staffRepository.save(staff);
    }

    @Override
    public void assingStaffToClient(int staffId, int clientId) {
        if (staffRepository.findById(staffId).isPresent() || clientRepository.findById(clientId).isPresent()){
            Staff staff = staffRepository.findById(staffId).get();
            Client client = clientRepository.findById(clientId).get();

            client.setStaff(staff);
            staffRepository.save(staff);

        }
    }
}
