package com.agate.agate.service.impl;

import com.agate.agate.repository.AdvertRepository;
import com.agate.agate.repository.Entity.Advert;
import com.agate.agate.service.AdvertService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdvertServiceImpl implements AdvertService {

    AdvertRepository advertRepository;

    public AdvertServiceImpl(AdvertRepository advertRepository){
        this.advertRepository = advertRepository;
    }

    @Override
    public void setAdvert(Advert advert) {
        advertRepository.save(advert);
    }

    @Override
    public void updateAdvert(int id, Advert advert) {
        advertRepository.findById(id).ifPresent(advert1 -> {
            advert1.setName(advert.getName());
            advert1.setPlannedStartDate(advert.getPlannedStartDate());
            advert1.setRecordCompletion(advert.getRecordCompletion());
            advertRepository.save(advert1);
        });
    }

    @Override
    public void setCompletion(int id, String completion) {

        advertRepository.findById(id).ifPresent(advert1 -> {
            advert1.setRecordCompletion(completion);
            advertRepository.save(advert1);
        });

    }

    @Override
    public List<Advert> findAllAdverts() {
        return advertRepository.findAll();
    }

    @Override
    public Optional<Advert> findAdvertById(int id) {
        if (advertRepository.findById(id).isPresent())
            return advertRepository.findById(id);
        else return Optional.empty();
    }

    @Override
    public void deleteAdverts() {
        advertRepository.deleteAll();
    }

    @Override
    public void deleteAdvert(int id) {
        advertRepository.deleteById(id);
    }

}
