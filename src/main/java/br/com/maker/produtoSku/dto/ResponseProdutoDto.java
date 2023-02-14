package br.com.maker.produtoSku.dto;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ResponseProdutoDto {

    private String Descricao;
    private String marca;
    private String Departamento;
    private String nome;
    private String modelo;
    private String tamanho;
    private String urlImagem;
    private String codigoBarras;
    private String dataLancamento;

}
