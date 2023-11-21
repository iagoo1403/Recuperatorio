package parcial_backend.recuperatorio.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.naming.Name;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Tracks")
public class Track {
    @Id
    @Column(name = "TrackId")
    private Long trackId;

    @Column(name = "Name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "AlbumId")
    private Album albumId;


    @Column(name = "MediaTypeId")
    private  Long mediaTypeId;

    @ManyToOne
    @JoinColumn(name = "GenreId")
    private Genre genreId;

    @Column(name = "Composer")
    private String composer;

    @Column(name = "Milliseconds")
    private Integer milliseconds;

    @Column(name = "Bytes")
    private Integer bytes;

    @Column(name = "UnitPrice")
    private Double unitPrice;


}
