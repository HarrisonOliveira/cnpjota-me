package me.projects.cnpjtame.service;

import me.projects.cnpjtame.utils.CnpjUtils;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CnpjGenerator {
    static final String cnpjAlfaNumerico = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private final CnpjUtils cnpjUtils =  new CnpjUtils();
    private final Random random = new Random();


    public String generateCnpj() {

        final StringBuilder baseCnpj = new StringBuilder();

        /*
        Laço usado para criar os primeiros 8 dígitos Raiz do CNPJ.
         */
        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(cnpjAlfaNumerico.length());
            char character = cnpjAlfaNumerico.charAt(index);
            baseCnpj.append(character);
        }

        /*
        Laço usado para criar os 4 dígitos do CNPJ referentes a filial.
        TODO: Esse Laço será separado posteriormente em função própria para gerar digitos para filiais.
         */
        for (int i = 0; i < 4; i++) {
            int index = random.nextInt(cnpjAlfaNumerico.length());
            char character = cnpjAlfaNumerico.charAt(index);
            baseCnpj.append(character);
        }

        baseCnpj.append(digitCheckerGenerator(baseCnpj.toString()));

        return cnpjUtils.formatCnpj(baseCnpj.toString());
    }

    public String digitCheckerGenerator(@NonNull String cnpj) {
        int[] weightsDV1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] weightsDV2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

        StringBuilder digits = new StringBuilder();

        int sum = 0;
        int dv1;
        int dv2;

        if (cnpj.length() != 8) {
            cnpj = cnpjUtils.sanitize(cnpj);
        }

        /*
           Realiza o cálculo para gerar o primeiro Digito Verificador (dv1).
         */
        for (int i = 0; i < 12; i++) sum += (((int)cnpj.charAt(i)) - 48) * weightsDV1[i];
        dv1 = (sum % 11) <= 1 ? 0 : 11 - (sum % 11);
        cnpj += dv1;

        /*
           Realiza o cálculo para gerar o segundo Digito Verificador (dv2).
         */
        sum = 0;
        for (int i = 0; i < 13; i++) sum += (((int)cnpj.charAt(i)) - 48) * weightsDV2[i];
        dv2 = (sum % 11) <= 1 ? 0 : 11 - (sum % 11);

        digits.append(dv1).append(dv2);

        return digits.toString();
    }
}
