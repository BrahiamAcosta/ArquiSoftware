package com.udea.flightsearchback.service;

import com.udea.flightsearchback.model.Flight;
import com.udea.flightsearchback.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> findFlights(LocalDate startDate, LocalDate endDate, String flightType, String baggageType,String origin, String destination, Double maxPrice, Integer maxPassengers){
        String key = (origin != null ? "1" : "0") +
                (destination != null ? "1" : "0") +
                (maxPrice != null ? "1" : "0") +
                (maxPassengers != null ? "1" : "0");
        return switch (key) {
            case "0001" ->
                // maxPassengers
                    flightRepository.findByDateBetweenAndFlightTypeAndBaggageTypeAndMaxPassengersLessThanEqual(
                            startDate, endDate, flightType, baggageType, maxPassengers);
            case "0100" ->
                // destination
                    flightRepository.findByDateBetweenAndFlightTypeAndBaggageTypeAndDestinationContainingIgnoreCase(
                            startDate, endDate, flightType, baggageType, destination);
            case "0101" ->
                // destination and maxPassengers
                    flightRepository.findByDateBetweenAndFlightTypeAndBaggageTypeAndDestinationContainingIgnoreCaseAndMaxPassengersLessThanEqual(
                            startDate, endDate, flightType, baggageType, destination, maxPassengers);
            case "0010" ->
                // maxPrice
                    flightRepository.findByDateBetweenAndFlightTypeAndBaggageTypeAndPriceLessThanEqual(
                            startDate, endDate, flightType, baggageType, maxPrice);
            case "0011" ->
                // maxPrice and maxPassengers
                    flightRepository.findByDateBetweenAndFlightTypeAndBaggageTypeAndPriceLessThanEqualAndMaxPassengersLessThanEqual(
                            startDate, endDate, flightType, baggageType, maxPrice, maxPassengers);
            case "0110" ->
                // destination and maxPrice
                    flightRepository.findByDateBetweenAndFlightTypeAndBaggageTypeAndDestinationContainingIgnoreCaseAndPriceLessThanEqual(
                            startDate, endDate, flightType, baggageType, destination, maxPrice);
            case "0111" ->
                // destination, maxPrice, and maxPassengers
                    flightRepository.findByDateBetweenAndFlightTypeAndBaggageTypeAndDestinationContainingIgnoreCaseAndPriceLessThanEqualAndMaxPassengersLessThanEqual(
                            startDate, endDate, flightType, baggageType, destination, maxPrice, maxPassengers);
            case "1000" ->
                // origin
                    flightRepository.findByDateBetweenAndFlightTypeAndBaggageTypeAndOriginContainingIgnoreCase(
                            startDate, endDate, flightType, baggageType, origin);
            case "1001" ->
                // origin and maxPassengers
                    flightRepository.findByDateBetweenAndFlightTypeAndBaggageTypeAndOriginContainingIgnoreCaseAndMaxPassengersLessThanEqual(
                            startDate, endDate, flightType, baggageType, origin, maxPassengers);
            case "1010" ->
                // origin and maxPrice
                    flightRepository.findByDateBetweenAndFlightTypeAndBaggageTypeAndOriginContainingIgnoreCaseAndPriceLessThanEqual(
                            startDate, endDate, flightType, baggageType, origin, maxPrice);
            case "1011" ->
                // origin, maxPrice, and maxPassengers
                    flightRepository.findByDateBetweenAndFlightTypeAndBaggageTypeAndOriginContainingIgnoreCaseAndPriceLessThanEqualAndMaxPassengersLessThanEqual(
                            startDate, endDate, flightType, baggageType, origin, maxPrice, maxPassengers);
            case "1100" ->
                // origin and destination
                    flightRepository.findByDateBetweenAndFlightTypeAndBaggageTypeAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCase(
                            startDate, endDate, flightType, baggageType, origin, destination);
            case "1101" ->
                // origin, destination, and maxPassengers
                    flightRepository.findByDateBetweenAndFlightTypeAndBaggageTypeAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndMaxPassengersLessThanEqual(
                            startDate, endDate, flightType, baggageType, origin, destination, maxPassengers);
            case "1110" ->
                // origin, destination, and maxPrice
                    flightRepository.findByDateBetweenAndFlightTypeAndBaggageTypeAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceLessThanEqual(
                            startDate, endDate, flightType, baggageType, origin, destination, maxPrice);
            case "1111" ->
                // origin, destination, maxPrice, and maxPassengers
                    flightRepository.findByDateBetweenAndFlightTypeAndBaggageTypeAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceLessThanEqualAndMaxPassengersLessThanEqual(
                            startDate, endDate, flightType, baggageType, origin, destination, maxPrice, maxPassengers);
            //Sin filtros, solo los campos obligatorios
            default ->
                    flightRepository.findByDateBetweenAndFlightTypeAndBaggageType(startDate, endDate, flightType, baggageType);
        };
    }
}

