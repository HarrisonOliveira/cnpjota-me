package me.projects.cnpjtame.dto;

import jakarta.validation.constraints.NotBlank;

public record CnpjRequestDTO(
        @NotBlank(message = "O campo CNPJ não pode ser vazio")
        String cnpj
) {

}
