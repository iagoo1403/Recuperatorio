package parcial_backend.recuperatorio.repository;

import parcial_backend.recuperatorio.entities.Playlist_track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Playlist_trackRepository extends JpaRepository<Playlist_track, Long> {

}
