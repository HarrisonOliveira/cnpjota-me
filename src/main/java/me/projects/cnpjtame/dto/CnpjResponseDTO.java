package me.projects.cnpjtame.dto;

import lombok.Builder;

@Builder
public record CnpjResponseDTO(
        String cnpj,
        boolean valido,
        String mensagem) {
}
