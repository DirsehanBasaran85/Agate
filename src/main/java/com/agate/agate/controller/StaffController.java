package com.agate.agate.controller;

import com.agate.agate.repository.Entity.Staff;
import com.agate.agate.repository.record.staff.CreateStaff;
import com.agate.agate.repository.record.staff.UpdateStaff;
import com.agate.agate.service.StaffService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("Staff")
@Tag(name = "Staff", description = "For Staff")
public class StaffController {

    StaffService staffService;

    public StaffController(StaffService staffService){
        this.staffService = staffService;
    }

    @PostMapping()
    public void addStaff(@RequestBody CreateStaff createStaff){
        Staff staff = Staff.fromCreate(createStaff);
        staffService.setStaff(staff);
    }

    @PutMapping("{id}")
    public void updateStaff(@PathVariable("id") int id, @RequestBody UpdateStaff updateStaff){
        Staff staff = Staff.fromUpdate(updateStaff);
        staffService.updateStaff(id, staff);
    }

    @PutMapping("{sid}/client/{cid}")
    public void assignClient(@PathVariable("sid") int staffId, @PathVariable("cid") int clientId){
        staffService.assignStaffToClient(staffId, clientId);
    }

    @PutMapping("{sid}/campaign/{caid}")
    public void assignCampaign(@PathVariable("sid") int staffId, @PathVariable("caid") int campaignId){
        staffService.assignStaffToCampaign(staffId, campaignId);
    }

    @GetMapping()
    public List<Staff> getAllStaff(){
        return staffService.findAllStaff();
    }

    @GetMapping("{id}")
    public Optional<Staff> getStaffById(@PathVariable("id") int id){
        return staffService.findStaffById(id);
    }

    @DeleteMapping("{id}")
    public void deleteStaffById(@PathVariable("id") int id){
        staffService.deleteStaff(id);
    }

}
