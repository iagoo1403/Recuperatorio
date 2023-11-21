package parcial_backend.recuperatorio.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Albums")
public class Album {
    @Column(name = "Title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "ArtistId")
    private Artist artistId;

    @Id
    @Column(name = "AlbumId")
    private Long albumId;

}
