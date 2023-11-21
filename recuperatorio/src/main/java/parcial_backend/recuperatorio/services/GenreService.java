package parcial_backend.recuperatorio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import parcial_backend.recuperatorio.dtos.GenreDTO;
import parcial_backend.recuperatorio.entities.Genre;
import parcial_backend.recuperatorio.exceptions.ResourseConflictException;
import parcial_backend.recuperatorio.exceptions.ResourseNotFoundException;
import parcial_backend.recuperatorio.mappers.GenreMapper;
import parcial_backend.recuperatorio.repository.GenreRepository;

import java.util.List;

@Service
public class GenreService {
    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private GenreMapper genreMapper;

    public List<Genre> getAll() {
        return genreRepository.findAll();
    }

    public Genre getById(Long id) {
        Genre genre = genreRepository.findById(id)
                .orElse(null);

        return genre;
    }

    public Genre save(GenreDTO genreDTO) {
        if (getById(genreDTO.getGenreId()) != null) {
            throw new ResourseConflictException("Genre ya registrado");
        }

        Genre genre = genreMapper.toEntity(genreDTO);
        genre.setGenreId(genreDTO.getGenreId());

        return genreRepository.save(genre);
    }

    public Genre update(Long id, GenreDTO genreDTO) {
        Genre genre = getById(id);

        if (genre == null) {
            throw new ResourseNotFoundException("Genre no registrado");
        }

        Genre genreUpdate = genreMapper.toEntity(genreDTO);
        genreUpdate.setGenreId(genreUpdate.getGenreId());

        return genreRepository.save(genreUpdate);
    }

    public void delete(Long id) {
        Genre genre = getById(id);

        if (genre == null) {
            throw new ResourseNotFoundException("Genre no registrado");
        }

        genreRepository.delete(genre);
    }
}
