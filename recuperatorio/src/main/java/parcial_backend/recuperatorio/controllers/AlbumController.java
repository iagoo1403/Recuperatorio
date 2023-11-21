package parcial_backend.recuperatorio.controllers;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import parcial_backend.recuperatorio.dtos.AlbumDTO;
import parcial_backend.recuperatorio.entities.Album;
import parcial_backend.recuperatorio.services.AlbumService;


import java.util.List;

@RestController
@RequestMapping("/api/Album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @GetMapping("/{id}")
    public ResponseEntity<Album> getById(@PathVariable Long id){
        Album album = albumService.getById(id);

        if(album != null){
            return ResponseEntity.ok(album);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Album>> getAll(){
        List<Album> albums = albumService.getAll();

        return ResponseEntity.ok(albums);
    }

    @PostMapping
    public ResponseEntity<Album> save(@RequestBody AlbumDTO albumDTO){
        Album album = albumService.save(albumDTO);
        return  ResponseEntity.ok(album);
    }

    @PutMapping("{id}")
    ResponseEntity<Album> update(@PathVariable Long id,@RequestBody AlbumDTO albumDTO){
        Album album = albumService.update(id, albumDTO);

        return ResponseEntity.ok(album);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        albumService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

