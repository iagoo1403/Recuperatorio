package parcial_backend.recuperatorio.services;

import parcial_backend.recuperatorio.dtos.TrackDTO;
import parcial_backend.recuperatorio.entities.Track;
import parcial_backend.recuperatorio.exceptions.ResourceNotFoundException;
import parcial_backend.recuperatorio.exceptions.ResourseConflictException;
import parcial_backend.recuperatorio.mappers.TrackMapper;
import parcial_backend.recuperatorio.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackService {
    @Autowired
    private TrackRepository trackRepository;

    @Autowired
    private TrackMapper trackMapper;


    public List<Track> getAll(){
        return trackRepository.findAll();
    }

    public Track getById(Long id){
        Track track = trackRepository.findById(id)
                .orElse(null);

        return track;
    }
    public Track save(TrackDTO trackDTO){
        if(getById(trackDTO.getTrackId()) != null){
            throw new ResourseConflictException("Track ya registrado");
        }

        Track track = trackMapper.toEntity(trackDTO);
        track.setTrackId(trackDTO.getTrackId());

        return trackRepository.save(track);
    }

    public Track update(Long id, TrackDTO trackDTO){
        Track track = getById(id);

        if(track == null){
            throw new ResourceNotFoundException("Track no registrado");
        }

        Track trackUpdate = trackMapper.toEntity(trackDTO);
        trackUpdate.setTrackId(trackUpdate.getTrackId());

        return trackRepository.save(trackUpdate);
    }

    public void delete (Long id){
        Track track = getById(id);

        if(track == null){
            throw new ResourceNotFoundException("Track no registrado");
        }

        trackRepository.delete(track);
    }
}