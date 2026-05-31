package br.com.fdrdev.repairtipsapi.repository;

import br.com.fdrdev.repairtipsapi.model.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartRepository extends JpaRepository<Part, Long> {
    boolean existsByPartNumber(String partNumber);
}
