package me.changwook.AirBnb.controller;

import lombok.RequiredArgsConstructor;
import me.changwook.AirBnb.domain.Accommodation;
import me.changwook.AirBnb.service.AccommodationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/accommodations")
@RequiredArgsConstructor
public class AccommodationController {
    private final AccommodationService service;

    @GetMapping("/nearby")
    public ResponseEntity<List<Accommodation>> getNearby(
            @RequestParam double lat,
            @RequestParam double lng,
            @RequestParam(defaultValue = "30") double radiusKm) {
        List<Accommodation> accommodations = service.findNearby(lat, lng, radiusKm);
        return ResponseEntity.ok(accommodations);
    }

    @GetMapping("/recommendations")
    public ResponseEntity<List<Accommodation>> getRecommendations() {
        List<Accommodation> accommodations = service.findTopRecommendations();
        return ResponseEntity.ok(accommodations);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Accommodation>> searchNearby(
            @RequestParam double lat,
            @RequestParam double lng,
            @RequestParam(defaultValue = "30") double radiusKm) {
        List<Accommodation> accommodations = service.findNearbyAndSorted(lat, lng, radiusKm);
        return ResponseEntity.ok(accommodations);
    }
}
