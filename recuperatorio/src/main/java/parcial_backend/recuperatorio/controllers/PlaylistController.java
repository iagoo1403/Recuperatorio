package parcial_backend.recuperatorio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import parcial_backend.recuperatorio.dtos.PlaylistDTO;
import parcial_backend.recuperatorio.services.PlaylistService;

import java.util.List;

@RestController
@RequestMapping("/api/playlist")
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @GetMapping("/{id}")
    public ResponseEntity<Playlist> getById(@PathVariable Long id){
        Playlist playlist = playlistService.getById(id);

        if(playlist != null){
            return ResponseEntity.ok(playlist);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Playlist>> getAll(){
        List<Playlist> playlists = playlistService.getAll();

        return ResponseEntity.ok(playlists);
    }

    @PostMapping
    public ResponseEntity<Playlist> save(@RequestBody PlaylistDTO playlistDTO){
        Playlist playlist = playlistService.save(playlistDTO);
        return ResponseEntity.ok(playlist);
    }

    @PutMapping("{id}")
    ResponseEntity<Playlist> update(@PathVariable Long id, @RequestBody PlaylistDTO playlistDTO){
        Playlist playlist = playlistService.update(id, playlistDTO);

        return ResponseEntity.ok(playlist);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        playlistService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
