package parcial_backend.recuperatorio.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlbumDTO {
    private String title;
    private Long artistId;
    private Long albumId;

}
