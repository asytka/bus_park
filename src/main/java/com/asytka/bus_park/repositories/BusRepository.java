package com.asytka.bus_park.repositories;

import com.asytka.bus_park.model.Bus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BusRepository extends CrudRepository<Bus, Long> {
    // You can also add custom queries here if needed
    List<Bus> findByOnRoute(boolean onRoute);
}
