package parcial_backend.recuperatorio.dtos;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.naming.ldap.PagedResultsControl;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrackDTO {
    private String name;
    private Long albumId;
    private Long mediaTypeId;
    private Long genreId;
    private String composer;
    private Integer miliseconds;
    private Integer bytes;
    private Double unitPrice;
    private Long trackId;
}
