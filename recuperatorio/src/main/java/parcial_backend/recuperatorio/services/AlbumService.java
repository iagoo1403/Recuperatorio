package parcial_backend.recuperatorio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import parcial_backend.recuperatorio.dtos.AlbumDTO;
import parcial_backend.recuperatorio.entities.Album;
import parcial_backend.recuperatorio.exceptions.ResourseConflictException;
import parcial_backend.recuperatorio.exceptions.ResourseNotFoundException;
import parcial_backend.recuperatorio.mappers.AlbumMapper;
import parcial_backend.recuperatorio.repository.AlbumRepository;

import java.util.List;

@Service
public class AlbumService {
    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private AlbumMapper albumMapper;


    public List<Album> getAll(){
        return albumRepository.findAll();
    }

    public Album getById(Long id){
        Album album = albumRepository.findById(id)
                .orElse(null);

        return album;
    }
    public Album save(AlbumDTO albumDTO){
        if(getById(albumDTO.getAlbumId()) != null){
            throw new ResourseConflictException("Category ya registrado");
        }

        Album album = albumMapper.toEntity(albumDTO);
        album.setAlbumId(albumDTO.getAlbumId());

        return albumRepository.save(album);
    }

    public Album update(Long id, AlbumDTO albumDTO){
        Album album = getById(id);

        if(album == null){
            throw new ResourseNotFoundException("Category no registrado");
        }

        Album albumUpdate = albumMapper.toEntity(albumDTO);
        albumUpdate.setAlbumId(albumUpdate.getAlbumId());

        return albumRepository.save(albumUpdate);
    }

    public void delete (Long id){
        Album album = getById(id);

        if(album == null){
            throw new ResourseNotFoundException("Category no registrado");
        }

        albumRepository.delete(album);
    }
}
