package br.com.fdrdev.repairtipsapi.service;

import br.com.fdrdev.repairtipsapi.model.PartDto;
import br.com.fdrdev.repairtipsapi.model.Part;
import br.com.fdrdev.repairtipsapi.repository.PartRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class PartService {

    private final PartRepository repository;

    public PartService(PartRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<List<PartDto>> getParts() {
        List<PartDto> parts = repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(parts);
    }

    public ResponseEntity<PartDto> getPart(Long id) {
        return repository.findById(id).map(this::toDto).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Transactional
    public ResponseEntity<PartDto> createPart(PartDto dto) {
        if (dto.getPartNumber() != null && repository.existsByPartNumber(dto.getPartNumber())) {
            return ResponseEntity.status(409).build();
        }
        Part p = toEntity(dto);
        Part saved = repository.save(p);
        return ResponseEntity.status(201).body(toDto(saved));
    }

    @Transactional
    public ResponseEntity<PartDto> updatePart(Long id, PartDto dto) {
        Optional<Part> existing = repository.findById(id);
        if (existing.isEmpty()) return ResponseEntity.notFound().build();
        Part p = existing.get();
        p.setPartName(dto.getPartName());
        p.setPartNumber(dto.getPartNumber());
        p.setManufacturer(dto.getManufacturer());
        Part saved = repository.save(p);
        return ResponseEntity.ok(toDto(saved));
    }

    @Transactional
    public ResponseEntity<Void> deletePart(Long id) {
        if (!repository.existsById(id)) return ResponseEntity.notFound().build();
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private PartDto toDto(Part p) {
        PartDto dto = new PartDto();
        dto.setId(p.getId());
        dto.setPartName(p.getPartName());
        dto.setPartNumber(p.getPartNumber());
        dto.setManufacturer(p.getManufacturer());
        return dto;
    }

    private Part toEntity(PartDto dto) {
        Part p = new Part();
        p.setPartName(dto.getPartName());
        p.setPartNumber(dto.getPartNumber());
        p.setManufacturer(dto.getManufacturer());
        return p;
    }
}