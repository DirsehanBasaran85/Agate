package com.agate.agate.controller;

import com.agate.agate.repository.Entity.Staff;
import com.agate.agate.service.StaffService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Staff")
@Tag(name = "Staff", description = "For Staff")
public class StaffController {

    StaffService staffService;

    public StaffController(StaffService staffService){
        this.staffService = staffService;
    }

    @PostMapping()
    public void addStaff(@RequestBody Staff staff){
        staffService.setStaff(staff);
    }

    @PutMapping("{sid}/{cid}")
    public void assignClient(@PathVariable("sid") int staffId, @PathVariable("cid") int clientId){
        staffService.assingStaffToClient(staffId, clientId);
    }
}
