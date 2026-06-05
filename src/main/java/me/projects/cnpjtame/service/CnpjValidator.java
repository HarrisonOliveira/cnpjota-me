package me.projects.cnpjtame.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.projects.cnpjtame.utils.CnpjUtils;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class CnpjValidator {

    CnpjUtils cnpjUtils;

    public CnpjValidator(CnpjUtils cnpjUtils) {
        this.cnpjUtils = cnpjUtils;
    }


    public String digitCheckerGenerator(String cnpj) {
        int[] weightsDV1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] weightsDV2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

        StringBuilder digits = new StringBuilder();

        int sum = 0;
        int DV1;
        int DV2;

        cnpj = cnpjUtils.sanitize(cnpj);

        /*
           Realiza o cálculo para gerar o primeiro Digito Verificador (DV1).
         */
        for (int i = 0; i < 12; i++) sum += ((int) cnpj.charAt(i) - 48) * weightsDV1[i];
        DV1 = (sum % 11) <= 1 ? 0 : 11 - (sum % 11);
        cnpj += DV1;

        /*
           Realiza o cálculo para gerar o segundo Digito Verificador (DV2).
         */
        sum = 0;
        for (int i = 0; i < 13; i++) sum += ((int) cnpj.charAt(i) - 48) * weightsDV2[i];
        DV2 = (sum % 11) <= 1 ? 0 : 11 - (sum % 11);

        digits.append(DV1).append(DV2);

        return digits.toString();
    }

}
