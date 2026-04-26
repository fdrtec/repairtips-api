package br.com.fdrdev.repairtipsapi.api;

import br.com.fdrdev.repairtipsapi.model.PartRepresentation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Parts API", description = "API for managing parts")
@RequestMapping("/api/parts")
public interface PartApi extends BaseApi<PartRepresentation> {
}