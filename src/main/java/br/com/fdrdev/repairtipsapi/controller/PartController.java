package br.com.fdrdev.repairtipsapi.controller;

import br.com.fdrdev.repairtipsapi.api.PartsApi;
import br.com.fdrdev.repairtipsapi.model.PartDto;
import br.com.fdrdev.repairtipsapi.service.PartService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PartController implements PartsApi {

    private final PartService partService;

    @Override
    public ResponseEntity<List<PartDto>> getParts() {
        return partService.getParts();
    }
}