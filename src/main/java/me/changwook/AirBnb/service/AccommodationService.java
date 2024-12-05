package me.changwook.AirBnb.service;

import lombok.RequiredArgsConstructor;
import me.changwook.AirBnb.domain.Accommodation;
import me.changwook.AirBnb.dto.AccommodationDTO;
import me.changwook.AirBnb.repository.AccommodationRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccommodationService {
    private final AccommodationRepository repository;

    public AccommodationDTO getAccommodationForHtmlById(Long id) {
        Accommodation accommodation = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("숙소를 찾을 수 없습니다"));
        return AccommodationDTO.builder()
                .name(accommodation.getName())
                .imageUrl(accommodation.getImageUrl())
                .price(accommodation.getPrice())
                .rating(accommodation.getRating())
                .reviewsCount(accommodation.getReviewsCount())
                .build();
    }
    public AccommodationDTO getAccommodationForJsonById(Long id) {
        Accommodation accommodation = repository.findById(id).orElseThrow(()-> new IllegalArgumentException("숙소를 찾을 수 없습니다"));
        return AccommodationDTO.builder()
                .latitude(accommodation.getLatitude())
                .longitude(accommodation.getLongitude())
                .build();
    }

}
