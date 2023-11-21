package parcial_backend.recuperatorio.repository;

import parcial_backend.recuperatorio.entities.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository extends JpaRepository<Track, Long> {

}