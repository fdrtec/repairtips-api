package br.com.fdrdev.repairtipsapi.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Tag(name = "Base API", description = "Base API for common operations")
@RequestMapping("/api")
public interface BaseApi<T> {

    @Operation(summary = "Get all items", description = "Retrieve a list of all items")
    @GetMapping
    List<T> getAll();
}