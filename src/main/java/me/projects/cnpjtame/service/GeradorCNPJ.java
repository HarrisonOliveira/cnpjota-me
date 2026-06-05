package me.projects.cnpjtame.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GeradorCNPJ {
    static final String cnpjAlfaNumerico = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private final Random random = new Random();

    public String gerarCNPJ() {

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
        TODO: Esse Laço será separado posteriormente em função própria para gerar CNPJ de filiais.
         */
        for (int i = 0; i < 4; i++) {
            int index = random.nextInt(cnpjAlfaNumerico.length());
            char character = cnpjAlfaNumerico.charAt(index);
            cnpjBase.append(character);
        }

        return cnpjBase.toString();

    }
}
