package com.poc.insurance.application.rest;

import com.poc.insurance.domain.sinistro.Sinistro;
import com.poc.insurance.domain.sinistro.service.SinistroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sinistros")
public class SinistroController {

    private final SinistroService sinistroService;

    public SinistroController(final SinistroService sinistroService) {
        this.sinistroService = sinistroService;
    }

    @PostMapping
    public ResponseEntity<String> abrir(@RequestBody final Sinistro sinistro) {
        sinistroService.abrir(sinistro);
        return ResponseEntity.ok("Sinistro criado com sucesso!");
    }

}
