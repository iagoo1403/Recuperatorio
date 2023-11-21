package parcial_backend.recuperatorio.mappers;

import parcial_backend.recuperatorio.dtos.PlaylistDTO;
import parcial_backend.recuperatorio.entities.Playlist;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
@Component
public class PlaylistMapper {
    @Autowired
    private ModelMapper modelMapper;

    public PlaylistDTO toDto(Playlist playlist){
        return Objects.isNull(playlist) ? null : modelMapper.map(playlist, PlaylistDTO.class);
    }

    public Playlist toEntity(PlaylistDTO playlistDTO){
        return Objects.isNull(playlistDTO) ? null : modelMapper.map(playlistDTO, Playlist.class);
    }
}