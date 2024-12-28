package com.agate.agate.service;

import com.agate.agate.repository.Entity.Staff;

import java.util.List;
import java.util.Optional;

public interface StaffService {

    void setStaff(Staff staff);

    void updateStaff(int id, Staff staff);

    void assignStaffToClient(int staffId, int clientId);

    void assignStaffToCampaign(int staffId, int campaignId);

    List<Staff> findAllStaff();

    Optional<Staff> findStaffById(int id);

    void deleteStaff(int id);


}
