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
@Table(name = "Artists")
public class Artist {
    @Column(name = "Name")
    private String name;

    @Id
    @Column(name = "ArtistId")
    private Long artistId;
}