package parcial_backend.recuperatorio.services;

import parcial_backend.recuperatorio.dtos.Playlist_trackDTO;
import parcial_backend.recuperatorio.entities.Playlist_track;
import parcial_backend.recuperatorio.exceptions.ResourseConflictException;
import parcial_backend.recuperatorio.exceptions.ResourseNotFoundException;
import parcial_backend.recuperatorio.mappers.Playlist_trackMapper;
import parcial_backend.recuperatorio.repository.Playlist_trackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Playlist_trackService {
    @Autowired
    private Playlist_trackRepository playlist_trackRepository;

    @Autowired
    private Playlist_trackMapper playlist_trackMapper;


    public List<Playlist_track> getAll(){
        return playlist_trackRepository.findAll();
    }

    public Playlist_track getById(Long id){
        Playlist_track playlist_track = playlist_trackRepository.findById(id)
                .orElse(null);

        return playlist_track;
    }
    public Playlist_track save(Playlist_trackDTO playlist_trackDTO){
        if(getById(playlist_trackDTO.getPlaylistTrackId()) != null){
            throw new ResourseConflictException("Playlist_track ya registrado");
        }

        Playlist_track playlist_track = playlist_trackMapper.toEntity(playlist_trackDTO);
        playlist_track.setPlaylistTrackId(playlist_trackDTO.getPlaylistTrackId());

        return playlist_trackRepository.save(playlist_track);
    }

    public Playlist_track update(Long id, Playlist_trackDTO playlistTrackDTO){
        Playlist_track playlist_track = getById(id);

        if(playlist_track == null){
            throw new ResourseNotFoundException("Playlist_track no registrado");
        }

        Playlist_track playlistTrackUpdate = playlist_trackMapper.toEntity(playlistTrackDTO);
        playlistTrackUpdate.setPlaylistTrackId(playlistTrackUpdate.getPlaylistTrackId());

        return playlist_trackRepository.save(playlistTrackUpdate);
    }

    public void delete (Long id){
        Playlist_track playlist_track = getById(id);

        if(playlist_track == null){
            throw new ResourseNotFoundException("Playlist_track no registrado");
        }

        playlist_trackRepository.delete(playlist_track);
    }
}