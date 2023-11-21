package parcial_backend.recuperatorio.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import parcial_backend.recuperatorio.dtos.ArtistDTO;
import parcial_backend.recuperatorio.services.ArtistService;

import java.util.List;

@RestController
@RequestMapping("/api/Artist")
public class ArtistController {
    @Autowired
    private ArtistService artistService;

    @GetMapping("/{id}")
    public ResponseEntity<Artist> getById(@PathVariable Long id){
        Artist artist = artistService.getById(id);

        if(artist != null){
            return ResponseEntity.ok(artist);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Artist>> getAll(){
        List<Artist> artists = artistService.getAll();

        return ResponseEntity.ok(artists);
    }

    @PostMapping
    public ResponseEntity<Artist> save(@RequestBody ArtistDTO categoryDTO){
        Artist artist = artistService.save(artistDTO);
        return  ResponseEntity.ok(artist);
    }

    @PutMapping("{id}")
    ResponseEntity<Artist> update(@PathVariable Long id,@RequestBody ArtistDTO artistDTO){
        Artist artist = artistService.update(id, artistDTO);

        return ResponseEntity.ok(artist);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        artistService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
