package parcial_backend.recuperatorio.mappers;

import parcial_backend.recuperatorio.dtos.TrackDTO;
import parcial_backend.recuperatorio.entities.Track;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
@Component
public class TrackMapper {
    @Autowired
    private ModelMapper modelMapper;

    public TrackDTO toDto(Track track){
        return Objects.isNull(track) ? null : modelMapper.map(track, TrackDTO.class);
    }

    public Track toEntity(TrackDTO trackDTO){
        return Objects.isNull(trackDTO) ? null : modelMapper.map(trackDTO, Track.class);
    }
}