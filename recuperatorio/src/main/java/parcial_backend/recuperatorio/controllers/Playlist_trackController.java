package parcial_backend.recuperatorio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import parcial_backend.recuperatorio.dtos.Playlist_trackDTO;
import parcial_backend.recuperatorio.services.Playlist_trackService;

import java.util.List;

@RestController
@RequestMapping("/api/playlist_track")
public class Playlist_trackController {

    @Autowired
    private Playlist_trackService playlist_trackService;

    @GetMapping("/{id}")
    public ResponseEntity<Playlist_track> getById(@PathVariable Long id){
        Playlist_track playlist_track = playlist_trackService.getById(id);

        if(playlist_track != null){
            return ResponseEntity.ok(playlist_track);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Playlist_track>> getAll(){
        List<Playlist_track> playlist_tracks = playlist_trackService.getAll();

        return ResponseEntity.ok(playlist_tracks);
    }

    @PostMapping
    public ResponseEntity<Playlist_track> save(@RequestBody PlaylistTrackDTO playlistTrackDTO){
        Playlist_track playlist_track = playlist_trackService.save(playlistTrackDTO);
        return ResponseEntity.ok(playlist_track);
    }

    @PutMapping("{id}")
    ResponseEntity<Playlist_track> update(@PathVariable Long id, @RequestBody PlaylistTrackDTO playlistTrackDTO){
        Playlist_track playlist_track = playlist_trackService.update(id, playlistTrackDTO);

        return ResponseEntity.ok(playlist_track);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        playlist_trackService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
