package parcial_backend.recuperatorio.repository;

import parcial_backend.recuperatorio.entities.Invoice_item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Invoice_trackerRepository extends JpaRepository<Invoice_item, Long> {

}