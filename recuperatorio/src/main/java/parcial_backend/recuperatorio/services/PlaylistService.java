package parcial_backend.recuperatorio.services;

import parcial_backend.recuperatorio.dtos.PlaylistDTO;
import parcial_backend.recuperatorio.entities.Playlist;
import parcial_backend.recuperatorio.exceptions.ResourseNotFoundException;
import parcial_backend.recuperatorio.exceptions.ResourseConflictException;
import parcial_backend.recuperatorio.mappers.PlaylistMapper;
import parcial_backend.recuperatorio.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistService {
    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private PlaylistMapper playlistMapper;


    public List<Playlist> getAll(){
        return playlistRepository.findAll();
    }

    public Playlist getById(Long id){
        Playlist playlist = playlistRepository.findById(id)
                .orElse(null);

        return playlist;
    }
    public Playlist save(PlaylistDTO playlistDTO){
        if(getById(playlistDTO.getPlaylistId()) != null){
            throw new ResourseConflictException("Playlist ya registrado");
        }

        Playlist playlist = playlistMapper.toEntity(playlistDTO);
        playlist.setPlaylistId(playlistDTO.getPlaylistId());

        return playlistRepository.save(playlist);
    }

    public Playlist update(Long id, PlaylistDTO playlistDTO){
        Playlist playlist = getById(id);

        if(playlist == null){
            throw new ResourseNotFoundException("Playlist no registrado");
        }

        Playlist playlistUpdate = playlistMapper.toEntity(playlistDTO);
        playlistUpdate.setPlaylistId(playlistUpdate.getPlaylistId());

        return playlistRepository.save(playlistUpdate);
    }

    public void delete (Long id){
        Playlist playlist = getById(id);

        if(playlist == null){
            throw new ResourseNotFoundException("Playlist no registrado");
        }

        playlistRepository.delete(playlist);
    }
}