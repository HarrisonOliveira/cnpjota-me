package me.projects.cnpjtame.controller;

import me.projects.cnpjtame.service.CnpjGenerator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("api/v1/")
public class CnpjController {
    CnpjGenerator cnpjGenerator;

    public CnpjController(CnpjGenerator cnpjGenerator) {
        this.cnpjGenerator = cnpjGenerator;
    }

    @GetMapping
    public ResponseEntity<String> postCnpj() {
        return ResponseEntity.ok().body(cnpjGenerator.GenerateCnpj());
    }
}
