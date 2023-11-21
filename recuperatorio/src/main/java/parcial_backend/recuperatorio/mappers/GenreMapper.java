package parcial_backend.recuperatorio.mappers;

import parcial_backend.recuperatorio.dtos.GenreDTO;
import parcial_backend.recuperatorio.entities.Genre;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
@Component
public class GenreMapper {
    @Autowired
    private ModelMapper modelMapper;

    public GenreDTO toDto(Genre genre){
        return Objects.isNull(genre) ? null : modelMapper.map(genre, GenreDTO.class);
    }

    public Genre toEntity(GenreDTO genreDTO){
        return Objects.isNull(genreDTO) ? null : modelMapper.map(genreDTO, Genre.class);
    }
}
