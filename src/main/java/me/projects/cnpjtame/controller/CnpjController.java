package me.projects.cnpjtame.controller;

import jakarta.validation.Valid;
import me.projects.cnpjtame.dto.CnpjRequestDTO;
import me.projects.cnpjtame.dto.CnpjResponseDTO;
import me.projects.cnpjtame.service.CnpjGenerator;
import me.projects.cnpjtame.service.CnpjValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/cnpj")
public class CnpjController {
    private final CnpjGenerator cnpjGenerator;
    private final CnpjValidator cnpjValidator;

    public CnpjController(CnpjGenerator cnpjGenerator, CnpjValidator cnpjValidator) {
        this.cnpjGenerator = cnpjGenerator;
        this.cnpjValidator = cnpjValidator;
    }

    @GetMapping
    public ResponseEntity<String> getCnpj() {
        return ResponseEntity.ok(cnpjGenerator.generateCnpj());
    }

    @PostMapping("/validar")
    public ResponseEntity<CnpjResponseDTO> postCnpj(@Valid @RequestBody CnpjRequestDTO cnpjRequestDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(cnpjValidator.validateCnpj(cnpjRequestDTO));
    }
}
