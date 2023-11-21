package parcial_backend.recuperatorio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import parcial_backend.recuperatorio.dtos.GenreDTO;
import parcial_backend.recuperatorio.entities.Genre;
import parcial_backend.recuperatorio.services.GenreService;

import java.util.List;

@RestController
@RequestMapping("/api/Genre")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping("/{id}")
    public ResponseEntity<Genre> getById(@PathVariable Long id){
        Genre genre = genreService.getById(id);

        if(genre != null){
            return ResponseEntity.ok(genre);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Genre>> getAll(){
        List<Genre> genres = genreService.getAll();

        return ResponseEntity.ok(genres);
    }

    @PostMapping
    public ResponseEntity<Genre> save(@RequestBody GenreDTO genreDTO){
        Genre genre = genreService.save(genreDTO);
        return ResponseEntity.ok(genre);
    }

    @PutMapping("{id}")
    ResponseEntity<Genre> update(@PathVariable Long id, @RequestBody GenreDTO genreDTO){
        Genre genre = genreService.update(id, genreDTO);

        return ResponseEntity.ok(genre);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        genreService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
