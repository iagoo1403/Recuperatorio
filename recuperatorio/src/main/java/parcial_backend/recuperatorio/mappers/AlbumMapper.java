package parcial_backend.recuperatorio.mappers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import parcial_backend.recuperatorio.dtos.AlbumDTO;
import parcial_backend.recuperatorio.entities.Album;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
@Component
public class AlbumMapper {
    @Autowired
    private ModelMapper modelMapper;

    public AlbumDTO toDto(Album album) {
        return Objects.isNull(album) ? null : modelMapper.map(album, AlbumDTO.class);
    }

    public Album toEntity(AlbumDTO albumDTO) {
        return Objects.isNull(albumDTO) ? null : modelMapper.map(albumDTO, Album.class);
    }


}
