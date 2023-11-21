package parcial_backend.recuperatorio.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Genres")
public class Genre {
    @Id
    @Column(name = "Name")
    private String name;

    @Column (name = "GenreId")
    private Integer genreId;
}
