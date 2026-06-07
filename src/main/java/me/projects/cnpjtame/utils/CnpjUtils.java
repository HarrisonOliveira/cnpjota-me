package me.projects.cnpjtame.utils;


public class CnpjUtils {

    /**
     * Formata o CNPJ passado para o formato XX.XXX.XXX/XXXX-XX
     **/
    public String formatCnpj(String cnpj) {
        return cnpj.replaceAll("^(.{2})(.{3})(.{3})(.{4})(.{2})$", "$1.$2.$3/$4-$5");
    }

    /**
     Remove os possíveis caracteres especiais.
     Remove os dois últimos dígitos verificadores para serem gerados e validados posteriormente.
     **/
    public String sanitize(String cnpj) {
        return cnpj.replaceAll("-\\w{2}$", "").replaceAll("[^a-zA-Z0-9]", "");
    }

    /**
     * @return Retorna o CNPJ sem caracteres especiais.
     */
    public static String sanitizeCnpj(String cnpj) {
        return cnpj.replaceAll("[^a-zA-Z0-9]", "");
    }

    public static String getDigitChecker(String cnpj) {
        return cnpj.substring(cnpj.length() - 2);
    }
}
