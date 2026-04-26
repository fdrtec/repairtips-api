package br.com.fdrdev.repairtipsapi.controller;

import br.com.fdrdev.repairtipsapi.api.PartApi;
import br.com.fdrdev.repairtipsapi.model.PartRepresentation;
import br.com.fdrdev.repairtipsapi.service.PartService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PartController implements PartApi {

    private final PartService partService;

    @Override
    public List<PartRepresentation> getAll() {
        return partService.getAll();
    }
}