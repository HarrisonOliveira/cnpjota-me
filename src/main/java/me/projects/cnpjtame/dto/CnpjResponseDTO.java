package me.projects.cnpjtame.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record CnpjResponseDTO(
        @JsonProperty("CNPJ")
        String cnpj,
        boolean valido,
        String mensagem) {
}
