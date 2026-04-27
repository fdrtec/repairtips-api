package br.com.fdrdev.repairtipsapi.service;

import br.com.fdrdev.repairtipsapi.api.HealthApi;
import br.com.fdrdev.repairtipsapi.model.HealthCheck200Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Service
public class HealthService implements HealthApi {

    @Override
    public ResponseEntity<HealthCheck200Response> checkHealth() {
        HealthCheck200Response response = new HealthCheck200Response();
        response.setStatus("UP");
        return ResponseEntity.ok(response);
    }
}
