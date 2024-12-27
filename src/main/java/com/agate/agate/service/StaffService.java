package com.agate.agate.service;

import com.agate.agate.repository.Entity.Staff;

public interface StaffService {

    void setStaff(Staff staff);

    void assingStaffToClient(int staffId, int clientId);

}
