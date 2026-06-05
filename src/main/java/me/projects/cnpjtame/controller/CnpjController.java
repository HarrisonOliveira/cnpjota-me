package me.projects.cnpjtame.controller;

import me.projects.cnpjtame.service.CnpjGenerator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/cnpj")
public class CnpjController {
    private final CnpjGenerator cnpjGenerator;

    public CnpjController(CnpjGenerator cnpjGenerator) {
        this.cnpjGenerator = cnpjGenerator;
    }

    @GetMapping
    public ResponseEntity<String> getCnpj() {
        return ResponseEntity.ok(cnpjGenerator.generateCnpj());
    }
}
