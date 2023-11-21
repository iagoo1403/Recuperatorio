package parcial_backend.recuperatorio.mappers;

import parcial_backend.recuperatorio.dtos.Playlist_trackDTO;
import parcial_backend.recuperatorio.entities.Playlist_track;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
@Component
public class Playlist_trackMapper {
    @Autowired
    private ModelMapper modelMapper;

    public Playlist_trackDTO toDto(Playlist_track playlist_track){
        return Objects.isNull(playlist_track) ? null : modelMapper.map(playlist_track, Playlist_trackDTO.class);
    }

    public Playlist_track toEntity(Playlist_trackDTO playlist_trackDTO){
        return Objects.isNull(playlist_trackDTO) ? null : modelMapper.map(playlist_trackDTO, Playlist_track.class);
    }
}
