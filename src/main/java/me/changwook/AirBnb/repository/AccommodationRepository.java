package me.changwook.AirBnb.repository;

import me.changwook.AirBnb.domain.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {
}
