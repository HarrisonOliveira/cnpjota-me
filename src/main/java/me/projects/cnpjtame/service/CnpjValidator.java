package me.projects.cnpjtame.service;

import lombok.extern.slf4j.Slf4j;
import me.projects.cnpjtame.dto.CnpjRequestDTO;
import me.projects.cnpjtame.dto.CnpjResponseDTO;
import me.projects.cnpjtame.utils.CnpjUtils;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class CnpjValidator {

    private final CnpjUtils cnpjUtils;
    private final CnpjGenerator cnpjGenerator;

    public CnpjValidator(CnpjUtils cnpjUtils, CnpjGenerator cnpjGenerator) {
        this.cnpjUtils = cnpjUtils;
        this.cnpjGenerator = cnpjGenerator;
    }



    public CnpjResponseDTO validateCnpj(CnpjRequestDTO dto) {

        String DvDTO= CnpjUtils.getDigitChecker(dto.cnpj());
        String ValidDV = cnpjGenerator.digitCheckerGenerator(cnpjUtils.removeCheckDigit(dto.cnpj()));

        boolean valid = DvDTO.equals(ValidDV);
        String message = valid
                ? "Este CNPJ possui estrutura valida!"
                : "Este CNPJ possui estrutura invalida!";

        return CnpjResponseDTO.builder()
                .cnpj(cnpjUtils.formatCnpj(dto.cnpj()))
                .valido(valid)
                .mensagem(message)
                .build();
    }
}
