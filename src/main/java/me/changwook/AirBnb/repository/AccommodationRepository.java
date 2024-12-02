package me.changwook.AirBnb.repository;

import me.changwook.AirBnb.domain.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {
    @Query("SELECT a FROM Accommodation a WHERE " +
            "ST_Distance_Sphere(POINT(a.longitude, a.latitude), POINT(:lng, :lat)) <= :radius")
    List<Accommodation> findNearby(@Param("lat") double latitude,
                                   @Param("lng") double longitude,
                                   @Param("radius") double radius);
}
