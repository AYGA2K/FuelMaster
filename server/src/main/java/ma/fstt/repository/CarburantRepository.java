package ma.fstt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.fstt.entity.Carburant;

/**
 * CarburantRepository
 */
public interface CarburantRepository extends JpaRepository<Carburant, Long> {

}
