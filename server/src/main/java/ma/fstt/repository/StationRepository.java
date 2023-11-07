package ma.fstt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.fstt.entity.Station;

/**
 * StationRepository
 */
public interface StationRepository extends JpaRepository<Station, Long> {

}
