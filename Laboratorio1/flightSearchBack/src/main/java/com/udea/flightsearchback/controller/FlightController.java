package com.udea.flightsearchback.controller;
import com.udea.flightsearchback.model.Flight;
import com.udea.flightsearchback.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/flights")
@CrossOrigin(origins = "http://localhost:5173")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @GetMapping("/search")
    public List<Flight> searchFlights(
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate,
            @RequestParam("flightType") String flightType,
            @RequestParam("baggageType") String baggageType,
            @RequestParam(value = "origin" , required = false) String origin,
            @RequestParam(value = "destination" , required = false) String destination,
            @RequestParam(value = "maxPrice" , required = false) Double maxPrice,
            @RequestParam(value = "maxPassengers", required = false) Integer maxPassengers
    ){
        return flightService.findFlights(LocalDate.parse(startDate),LocalDate.parse(endDate),flightType,baggageType,origin,destination,maxPrice,maxPassengers);
    }
}
