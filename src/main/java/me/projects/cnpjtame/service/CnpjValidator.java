package me.projects.cnpjtame.service;

import lombok.extern.slf4j.Slf4j;
import me.projects.cnpjtame.dto.CnpjRequestDTO;
import me.projects.cnpjtame.dto.CnpjResponseDTO;
import me.projects.cnpjtame.utils.CnpjUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class CnpjValidator {

    private final CnpjUtils cnpjUtils = new CnpjUtils();
    private final CnpjGenerator cnpjGenerator = new CnpjGenerator();



    public CnpjResponseDTO validateCnpj(CnpjRequestDTO dto) {

        String cnpjDtoDV = catchDigitChecker(dto.CNPJ());
        String cnpjDV = cnpjGenerator.digitCheckerGenerator(cnpjUtils.sanitize(dto.CNPJ()));

        boolean valid = cnpjDtoDV.equals(cnpjDV);
        String message = valid
                ? "CNPJ valido!"
                : "CNPJ invalido!";

        return CnpjResponseDTO.builder()
                .cnpj(dto.CNPJ())
                .valido(valid)
                .mensagem(message)
                .build();
    }

    //    TODO: Passar esta função para classe CnpjUtils
    private static String catchDigitChecker(String cnpj) {
        return cnpj.substring(cnpj.length() - 2);
    }
}
