package com.agate.agate.repository;

import com.agate.agate.repository.Entity.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

//this is for sql queries
public interface CampaignRepository extends JpaRepository<Campaign, Integer> {

}
