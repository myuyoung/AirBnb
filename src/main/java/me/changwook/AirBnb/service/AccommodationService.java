package me.changwook.AirBnb.service;

import lombok.RequiredArgsConstructor;
import me.changwook.AirBnb.domain.Accommodation;
import me.changwook.AirBnb.repository.AccommodationRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccommodationService {
    private final AccommodationRepository repository;

    public List<Accommodation> findNearby(double lat, double lng, double radiusKm) {
        double radiusMeters = radiusKm * 1000; // Convert km to meters
        return repository.findNearby(lat, lng, radiusMeters);
    }

    public List<Accommodation> findTopRecommendations() {
        return repository.findAll(Sort.by(Sort.Order.desc("rating"), Sort.Order.desc("reviewsCount")));
    }

    public List<Accommodation> findNearbyAndSorted(double lat, double lng, double radiusKm) {
        double radiusMeters = radiusKm * 1000; // Convert km to meters
        return repository.findNearby(lat, lng, radiusMeters)
                .stream()
                .sorted((a, b) -> {
                    int ratingCompare = Double.compare(b.getRating(), a.getRating());
                    return (ratingCompare != 0) ? ratingCompare : b.getReviewsCount() - a.getReviewsCount();
                })
                .toList();
    }
}
