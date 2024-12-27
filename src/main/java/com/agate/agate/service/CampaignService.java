package com.agate.agate.service;

import com.agate.agate.repository.Entity.Campaign;

import java.security.DrbgParameters;
import java.util.List;
import java.util.Optional;

public interface CampaignService {

    void setCampaign(Campaign campaign);

    void updateCampaign(int id, Campaign campaign);

    List<Campaign> findAllCampaigns();

    Optional<Campaign> findCampaignById(int id);

    void deleteCampaigns();

    void deleteCampaign(int id);



}
