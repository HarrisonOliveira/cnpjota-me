package me.projects.cnpjtame.utils;

import org.springframework.stereotype.Component;

@Component
public class CnpjUtils {

    /**
     * @return Formata o CNPJ passado para o formato XX.XXX.XXX/XXXX-XX
     **/
    public String formatCnpj(String cnpj) {
        return cnpj.replaceAll("^(.{2})(.{3})(.{3})(.{4})(.{2})$", "$1.$2.$3/$4-$5");
    }

    /**
     * @return Remove os dois últimos dígitos verificadores para serem gerados e validados posteriormente.
     **/
    public String removeCheckDigit(String cnpj) {
        if (cnpj.length() > 12) cnpj = cnpj.replaceAll("-\\w{2}$", "");
        return cnpj;
    }

    /**
     * @return Retorna o CNPJ sem caracteres especiais.
     */
    public static String sanitizeCnpj(String cnpj) {
        return cnpj.replaceAll("[^a-zA-Z0-9]", "").toUpperCase();
    }

    /**
     * @return Retorna os dois dígitos Verificadores do CNPJ
     */
    public static String getDigitChecker(String cnpj) {
        return cnpj.substring(cnpj.length() - 2);
    }
}
