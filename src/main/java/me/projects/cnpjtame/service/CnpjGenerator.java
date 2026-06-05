package me.projects.cnpjtame.service;

import me.projects.cnpjtame.utils.CnpjUtils;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CnpjGenerator {
    static final String cnpjAlfaNumerico = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private final CnpjUtils cnpjUtils =  new CnpjUtils();
    private final Random random = new Random();
    private final CnpjValidator cnpjValidator;

    public CnpjGenerator(CnpjValidator cnpjValidator) {
        this.cnpjValidator = cnpjValidator;

    }

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
        Laço usado para criar os 4 dígitos de Ordem do CNPJ referentes a filial.
        TODO: Esse Laço será separado posteriormente em função própria para gerar digitos para filiais.
         */
        for (int i = 0; i < 4; i++) {
            int index = random.nextInt(cnpjAlfaNumerico.length());
            char character = cnpjAlfaNumerico.charAt(index);
            baseCnpj.append(character);
        }

        baseCnpj.append(cnpjValidator.digitCheckerGenerator(baseCnpj.toString()));

        return cnpjUtils.formatCnpj(baseCnpj.toString());
    }
}
