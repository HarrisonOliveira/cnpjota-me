package me.projects.cnpjtame.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CnpjGenerator {
    static final String cnpjAlfaNumerico = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private final Random random = new Random();
    CnpjValidator cnpjValidator;

    public CnpjGenerator(CnpjValidator cnpjValidator) {
        this.cnpjValidator = cnpjValidator;
    }

    public String GenerateCnpj() {

        final StringBuilder cnpjBase = new StringBuilder();

        /*
        Laço usado para criar os primeiros 8 dígitos Raiz do CNPJ.
         */
        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(cnpjAlfaNumerico.length());
            char character = cnpjAlfaNumerico.charAt(index);
            cnpjBase.append(character);
        }

        /*
        Laço usado para criar os 4 dígitos de Ordem do CNPJ referentes a filial.
        TODO: Esse Laço será separado posteriormente em função própria para gerar digitos para filiais.
         */
        for (int i = 0; i < 4; i++) {
            int index = random.nextInt(cnpjAlfaNumerico.length());
            char character = cnpjAlfaNumerico.charAt(index);
            cnpjBase.append(character);
        }

        cnpjBase.append(cnpjValidator.digitCheckerGenerator(cnpjBase.toString()));

        return cnpjBase.toString();

    }
}
