package br.com.fdrdev.repairtipsapi.controller;

import br.com.fdrdev.repairtipsapi.api.PartsApi;
import br.com.fdrdev.repairtipsapi.model.PartDto;
import br.com.fdrdev.repairtipsapi.service.PartService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PartController implements PartsApi {

    private final PartService partService;

    @Override
    public ResponseEntity<List<PartDto>> getParts() {
        return partService.getParts();
    }
    @Override
    public ResponseEntity<PartDto> createPart(PartDto dto) {
        return partService.createPart(dto);
    }

    @Override
    public ResponseEntity<PartDto> getPartById(Long id) {
        return partService.getPart(id);
    }

    @Override
    public ResponseEntity<PartDto> updatePart(Long id, PartDto dto) {
        return partService.updatePart(id, dto);
    }

    @Override
    public ResponseEntity<Void> deletePart(Long id) {
        return partService.deletePart(id);
    }
}