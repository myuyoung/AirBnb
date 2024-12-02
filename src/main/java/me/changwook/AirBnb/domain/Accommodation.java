package me.changwook.AirBnb.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "accommodations")
@Data
public class Accommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double latitude;
    private Double longitude;
    private Double price;
    private Double rating;
    private Integer reviewsCount;
}
