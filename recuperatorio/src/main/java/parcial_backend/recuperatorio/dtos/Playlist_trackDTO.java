package parcial_backend.recuperatorio.dtos;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Playlist_trackDTO {
    private Long playlistId;
    private Long trackId;
    private Long playlistTrackId;
}
