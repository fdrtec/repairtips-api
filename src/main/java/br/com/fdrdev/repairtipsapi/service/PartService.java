package br.com.fdrdev.repairtipsapi.service;

import br.com.fdrdev.repairtipsapi.model.PartRepresentation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartService implements BaseService<PartRepresentation> {

    @Override
    public List<PartRepresentation> getAll() {
        return List.of(
            new PartRepresentation(1L, "Roller Kit", "RK-001", "HP"),
            new PartRepresentation(2L, "Paper Separator", "PS-002", "HP"),
            new PartRepresentation(3L, "Fuser Assembly", "FA-003", "HP")
        );
    }
}