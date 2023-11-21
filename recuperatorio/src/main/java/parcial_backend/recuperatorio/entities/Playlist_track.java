package parcial_backend.recuperatorio.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Playlist_track")
public class Playlist_track {
    @Id
    @Column(name = "PlaylistTrackId")
    private Long playlistTrackId;

    @ManyToOne
    @JoinColumn(name = "TrackId")
    private Track trackId;

    @ManyToOne
    @JoinColumn(name = "PlaylistId")
    private Playlist playlistId;
}
