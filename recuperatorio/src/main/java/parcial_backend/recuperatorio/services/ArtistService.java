package parcial_backend.recuperatorio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import parcial_backend.recuperatorio.dtos.ArtistDTO;
import parcial_backend.recuperatorio.entities.Artist;
import parcial_backend.recuperatorio.exceptions.ResourseConflictException;
import parcial_backend.recuperatorio.exceptions.ResourseNotFoundException;
import parcial_backend.recuperatorio.mappers.ArtistMapper;
import parcial_backend.recuperatorio.repository.ArtistRepository;

import java.util.List;

@Service
public class ArtistService {
    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private ArtistMapper artistMapper;

    public List<Artist> getAll() {
        return artistRepository.findAll();
    }

    public Artist getById(Long id) {
        Artist artist = artistRepository.findById(id)
                .orElse(null);

        return artist;
    }

    public Artist save(ArtistDTO artistDTO) {
        if (getById(artistDTO.getArtistId()) != null) {
            throw new ResourseConflictException("Artist ya registrado");
        }

        Artist artist = artistMapper.toEntity(artistDTO);
        artist.setArtistId(artistDTO.getArtistId());

        return artistRepository.save(artist);
    }

    public Artist update(Long id, ArtistDTO artistDTO) {
        Artist artist = getById(id);

        if (artist == null) {
            throw new ResourseNotFoundException("Artist no registrado");
        }

        Artist artistUpdate = artistMapper.toEntity(artistDTO);
        artistUpdate.setArtistId(artistUpdate.getArtistId());

        return artistRepository.save(artistUpdate);
    }

    public void delete(Long id) {
        Artist artist = getById(id);

        if (artist == null) {
            throw new ResourseNotFoundException("Artist no registrado");
        }

        artistRepository.delete(artist);
    }
}
