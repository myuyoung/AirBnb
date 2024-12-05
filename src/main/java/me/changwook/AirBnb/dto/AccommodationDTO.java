package me.changwook.AirBnb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
public class AccommodationDTO {
    private final String name;
    private final String imageUrl;
    private final Double latitude;
    private final Double longitude;
    private final Double price;
    private final Double rating;
    private final Integer reviewsCount;
}