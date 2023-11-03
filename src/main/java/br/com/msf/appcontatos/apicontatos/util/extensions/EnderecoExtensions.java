package br.com.msf.appcontatos.apicontatos.util.extensions;

public class EnderecoExtensions {

    public static String buildMalaDireta(String endereco, String cep, String cidade, String uf) {
        return String.format("%s - CEP: %s - %s/%s", endereco, cep, cidade, uf);
    }

}