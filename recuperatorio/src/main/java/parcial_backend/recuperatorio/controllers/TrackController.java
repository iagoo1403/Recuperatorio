package parcial_backend.recuperatorio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import parcial_backend.recuperatorio.dtos.TrackDTO;
import parcial_backend.recuperatorio.services.TrackService;

import java.util.List;

@RestController
@RequestMapping("/api/track")
public class TrackController {

    @Autowired
    private TrackService trackService;

    @GetMapping("/{id}")
    public ResponseEntity<Track> getById(@PathVariable Long id){
        Track track = trackService.getById(id);

        if(track != null){
            return ResponseEntity.ok(track);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Track>> getAll(){
        List<Track> tracks = trackService.getAll();

        return ResponseEntity.ok(tracks);
    }

    @PostMapping
    public ResponseEntity<Track> save(@RequestBody TrackDTO trackDTO){
        Track track = trackService.save(trackDTO);
        return ResponseEntity.ok(track);
    }

    @PutMapping("{id}")
    ResponseEntity<Track> update(@PathVariable Long id, @RequestBody TrackDTO trackDTO){
        Track track = trackService.update(id, trackDTO);

        return ResponseEntity.ok(track);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        trackService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
