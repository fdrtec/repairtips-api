package br.com.fdrdev.repairtipsapi.service;

import br.com.fdrdev.repairtipsapi.model.PartDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartService {

    public ResponseEntity<List<PartDto>> getParts() {
        List<PartDto> parts = List.of(
            createPart(1L, "Roller Kit", "RK-001", "HP"),
            createPart(2L, "Paper Separator", "PS-002", "HP"),
            createPart(3L, "Fuser Assembly", "FA-003", "HP")
        );
        return ResponseEntity.ok(parts);
    }

    private PartDto createPart(Long id, String partName, String partNumber, String manufacturer) {
        PartDto dto = new PartDto();
        dto.setId(id);
        dto.setPartName(partName);
        dto.setPartNumber(partNumber);
        dto.setManufacturer(manufacturer);
        return dto;
    }
}