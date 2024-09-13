package com.udea.flightsearchback.repository;

import com.udea.flightsearchback.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.time.LocalDate;

public interface FlightRepository extends JpaRepository<Flight,Long> {
    // 1. Ningún filtro
    List<Flight> findByDateBetweenAndFlightTypeAndBaggageType(
            LocalDate startDate, LocalDate endDate, String flightType, String baggageType);

    // 2. 1 filtro
    List<Flight> findByDateBetweenAndFlightTypeAndBaggageTypeAndOriginContainingIgnoreCase(
            LocalDate startDate, LocalDate endDate, String flightType, String baggageType,String origin);

    List<Flight> findByDateBetweenAndFlightTypeAndBaggageTypeAndDestinationContainingIgnoreCase(
            LocalDate startDate, LocalDate endDate, String flightType, String baggageType, String destination
    );

    List<Flight> findByDateBetweenAndFlightTypeAndBaggageTypeAndPriceLessThanEqual(
            LocalDate startDate, LocalDate endDate,String flightType, String baggageType, Double maxPrice);

    List<Flight> findByDateBetweenAndFlightTypeAndBaggageTypeAndMaxPassengersLessThanEqual(
            LocalDate startDate, LocalDate endDate,String flightType, String baggageType, Integer maxPassengers);

    // 3. 2 filtros combinados
    List<Flight> findByDateBetweenAndFlightTypeAndBaggageTypeAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCase(
            LocalDate startDate, LocalDate endDate,String flightType, String baggageType, String origin, String destination);

    List<Flight> findByDateBetweenAndFlightTypeAndBaggageTypeAndOriginContainingIgnoreCaseAndPriceLessThanEqual(
            LocalDate startDate, LocalDate endDate,String flightType, String baggageType, String origin, Double maxPrice);

    List<Flight> findByDateBetweenAndFlightTypeAndBaggageTypeAndOriginContainingIgnoreCaseAndMaxPassengersLessThanEqual(
            LocalDate startDate, LocalDate endDate,String flightType, String baggageType, String origin, Integer maxPassengers);

    List<Flight> findByDateBetweenAndFlightTypeAndBaggageTypeAndDestinationContainingIgnoreCaseAndPriceLessThanEqual(
            LocalDate startDate, LocalDate endDate,String flightType, String baggageType, String destination, Double maxPrice);

    List<Flight> findByDateBetweenAndFlightTypeAndBaggageTypeAndDestinationContainingIgnoreCaseAndMaxPassengersLessThanEqual(
            LocalDate startDate, LocalDate endDate,String flightType, String baggageType, String destination, Integer maxPassengers);

    List<Flight> findByDateBetweenAndFlightTypeAndBaggageTypeAndPriceLessThanEqualAndMaxPassengersLessThanEqual(
            LocalDate startDate, LocalDate endDate,String flightType, String baggageType, Double maxPrice, Integer maxPassengers);

    // 4. 3 filtros combinados
    List<Flight> findByDateBetweenAndFlightTypeAndBaggageTypeAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceLessThanEqual(
            LocalDate startDate, LocalDate endDate,String flightType, String baggageType, String origin, String destination, Double maxPrice);

    List<Flight> findByDateBetweenAndFlightTypeAndBaggageTypeAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndMaxPassengersLessThanEqual(
            LocalDate startDate, LocalDate endDate,String flightType, String baggageType, String origin, String destination, Integer maxPassengers);

    List<Flight> findByDateBetweenAndFlightTypeAndBaggageTypeAndOriginContainingIgnoreCaseAndPriceLessThanEqualAndMaxPassengersLessThanEqual(
            LocalDate startDate, LocalDate endDate,String flightType, String baggageType, String origin, Double maxPrice, Integer maxPassengers);

    List<Flight> findByDateBetweenAndFlightTypeAndBaggageTypeAndDestinationContainingIgnoreCaseAndPriceLessThanEqualAndMaxPassengersLessThanEqual(
            LocalDate startDate, LocalDate endDate,String flightType, String baggageType, String destination, Double maxPrice, Integer maxPassengers);

    // 5. Todos los 4 filtros combinados
    List<Flight> findByDateBetweenAndFlightTypeAndBaggageTypeAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceLessThanEqualAndMaxPassengersLessThanEqual(
            LocalDate startDate, LocalDate endDate,String flightType, String baggageType, String origin, String destination, Double maxPrice, Integer maxPassengers);
}
