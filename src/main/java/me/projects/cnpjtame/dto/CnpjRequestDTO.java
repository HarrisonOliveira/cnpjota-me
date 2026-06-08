package me.projects.cnpjtame.dto;

import jakarta.validation.constraints.NotBlank;
import me.projects.cnpjtame.utils.CnpjUtils;


public record CnpjRequestDTO(
        @NotBlank(message = "O campo cnpj não pode estar vazio.")
        String cnpj
) {
    public CnpjRequestDTO {
        if (cnpj != null) {
            cnpj = CnpjUtils.sanitizeCnpj(cnpj).toUpperCase();
        }
    }
}
