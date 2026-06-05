package me.projects.cnpjtame.service;

import lombok.extern.slf4j.Slf4j;
import me.projects.cnpjtame.utils.CnpjUtils;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class CnpjValidator {

    private final CnpjUtils cnpjUtils = new CnpjUtils();

    public String digitCheckerGenerator(String cnpj) {
        int[] weightsDV1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] weightsDV2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

        StringBuilder digits = new StringBuilder();

        int sum = 0;
        int dv1;
        int dv2;

        cnpj = cnpjUtils.sanitize(cnpj);

        /*
           Realiza o cálculo para gerar o primeiro Digito Verificador (dv1).
         */
        for (int i = 0; i < 12; i++) sum += Character.getNumericValue(cnpj.charAt(i) - 48) * weightsDV1[i];
        dv1 = (sum % 11) <= 1 ? 0 : 11 - (sum % 11);
        cnpj += dv1;

        /*
           Realiza o cálculo para gerar o segundo Digito Verificador (dv2).
         */
        sum = 0;
        for (int i = 0; i < 13; i++) sum += Character.getNumericValue(cnpj.charAt(i) - 48) * weightsDV2[i];
        dv2 = (sum % 11) <= 1 ? 0 : 11 - (sum % 11);

        digits.append(dv1).append(dv2);

        return digits.toString();
    }

}
