package com.agate.agate.service;

import com.agate.agate.repository.Entity.Advert;


import java.util.List;
import java.util.Optional;


public interface AdvertService {

    void setAdvert(Advert advert, int campaignid);

    void updateAdvert(int id, Advert advert);

    void setCompletion(int id, String completion);

    List<Advert> findAllAdverts();

    Optional<Advert> findAdvertById(int id);

    void deleteAdverts();

    void deleteAdvert(int id);
}