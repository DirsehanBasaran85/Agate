package com.agate.agate.service.impl;

import com.agate.agate.repository.CampaignRepository;
import com.agate.agate.repository.Entity.Campaign;

import com.agate.agate.repository.StaffRepository;
import com.agate.agate.service.CampaignService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampaignServiceImpl implements CampaignService {

    private final StaffRepository staffRepository;
    private final CampaignRepository campaignRepository;

    public CampaignServiceImpl(CampaignRepository campaignRepository, StaffRepository staffRepository) {

        this.campaignRepository = campaignRepository;
        this.staffRepository = staffRepository;
    }

    @Override
    public void setCampaign(Campaign campaign) {
        campaignRepository.save(campaign);
    }

    @Override
    public void updateCampaign(int id, Campaign campaign) {

        campaignRepository.findById(id).ifPresent(campaign1 -> {
            campaign1.setTitle(campaign.getTitle());
            campaign1.setStartDate(campaign.getStartDate());
            campaign1.setEndDate(campaign.getEndDate());
            campaign1.setActualCost(campaign.getActualCost());
            campaign1.setEstimatedCost(campaign.getEstimatedCost());
            campaign1.setBudget(campaign.getBudget());
            campaign1.setStateOfCompletion(campaign.getStateOfCompletion());
            campaignRepository.save(campaign1);
        });
    }

    @Override
    public void assignManager(int campaignId, int managerId) {

        campaignRepository.findById(campaignId).ifPresent(campaign1 -> {

            if(staffRepository.findById(managerId).isPresent())
                campaign1.setManager(staffRepository.findById(managerId).get());
            campaignRepository.save(campaign1);

        });

    }

    @Override
    public List<Campaign> findAllCampaigns() {
        return campaignRepository.findAll();
    }

    @Override
    public Optional<Campaign> findCampaignById(int id) {
        if(campaignRepository.findById(id).isPresent())
            return campaignRepository.findById(id);
        else return Optional.empty();
    }

    @Override
    public void deleteCampaign(int id) {
        campaignRepository.deleteById(id);
    }

    @Override
    public void deleteCampaigns() {
        campaignRepository.deleteAll();
    }
}
