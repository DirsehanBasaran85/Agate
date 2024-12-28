package com.agate.agate.controller;

import com.agate.agate.repository.Entity.Campaign;
import com.agate.agate.service.CampaignService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("Campaign")
@Tag(name = "Campaign", description = "For Campaigns")

//this is api for frontend

public class CampaignController {

    CampaignService campaignService;

    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @PostMapping
    public void addCampaign(@RequestBody Campaign campaign) {

        campaignService.setCampaign(campaign);

    }

    @PutMapping("{id}")
    public void updateCampaign(@PathVariable("id") int id, Campaign campaign) {

        campaignService.updateCampaign(id, campaign);

    }

    @PutMapping("{campaignid}/{staffid}")
    public void assignManager(@PathVariable("campaignid") int campaignId,@PathVariable("staffid") int staffId){

        campaignService.assignManager(campaignId,staffId);

    }

    @GetMapping()
    public List<Campaign> getAllCampaigns() {

        return campaignService.findAllCampaigns();

    }

    @GetMapping("{id}")
    public Optional<Campaign> getCampaignById(@PathVariable("id") int id) {

        return campaignService.findCampaignById(id);

    }

    @DeleteMapping()
    public void deleteCampaigns() {

        campaignService.deleteCampaigns();

    }

    @DeleteMapping("{id}")
    public void deleteCampaign(@PathVariable("id") int id) {

        campaignService.deleteCampaign(id);

    }

}
