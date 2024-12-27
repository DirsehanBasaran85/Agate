package com.agate.agate.repository;

import com.agate.agate.repository.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    @Query("SELECT e FROM Client e WHERE ?1 = e.name")
    Optional<Client> findByName(String name);

}
