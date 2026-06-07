package me.projects.cnpjtame.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;

public record CnpjRequestDTO(
        @NotBlank(message = "O campo CNPJ não pode estar vazio.")
        @JsonAlias("CNPJ")
        String CNPJ
) {

}
