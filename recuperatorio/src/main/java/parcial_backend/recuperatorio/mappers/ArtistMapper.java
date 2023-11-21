package parcial_backend.recuperatorio.mappers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import parcial_backend.recuperatorio.dtos.ArtistDTO;
import parcial_backend.recuperatorio.entities.Artist;
import parcial_backend.recuperatorio.entities.Album;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
@Component
public class ArtistMapper {
    @Autowired
    private ModelMapper modelMapper;

    public ArtistDTO toDto(Artist artist){
        return Objects.isNull(artist) ? null : modelMapper.map(artist, ArtistDTO.class);
    }

    public Artist toEntity(ArtistDTO artistDTO){
        return Objects.isNull(artistDTO) ? null : modelMapper.map(artistDTO, Artist.class);
    }

}