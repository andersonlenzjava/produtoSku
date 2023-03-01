package br.com.testesmvc.produtoSku.dto;

import br.com.testesmvc.produtoSku.models.Produto;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

@Data
public class FormProdutoDto {

    @NotBlank
    private String descricao;
    @NotBlank
    private String marca;
    @NotBlank
    private String departamento;
    @NotBlank
    private String nome;
    @NotBlank
    private String modelo;
    @NotBlank
    private String tamanho;
    @NotBlank
    @URL(protocol = "https")
    private String urlImagem;
    @NotBlank
    @Length(min = 20, max = 28)
    private String codigoBarras;

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    String dataLancamento;

    public Produto toProduto() {
        Produto produto = new Produto();
        produto.setDescricao(this.descricao);
        produto.setMarca(this.marca);
        produto.setDepartamento(this.departamento);
        produto.setNome(this.nome);
        produto.setModelo(this.modelo);
        produto.setTamanho(this.tamanho);
        produto.setUrlImagem(this.urlImagem);
        produto.setCodigoBarras(this.codigoBarras);
        produto.setDataLancamento(this.dataLancamento);

        return produto;
    }
    public void fromProduto(Produto produto) {
        this.descricao = produto.getDescricao();
        this.marca = produto.getMarca();
        this.departamento = produto.getDepartamento();
        this.nome = produto.getNome();
        this.modelo = produto.getModelo();
        this.tamanho = produto.getTamanho();
        this.urlImagem = produto.getUrlImagem();
        this.codigoBarras = produto.getCodigoBarras();
        this.dataLancamento = produto.getDataLancamento();
    }

    public Produto toProduto(Produto produto) {
        produto.setDescricao(this.descricao);
        produto.setMarca(this.marca);
        produto.setDepartamento(this.departamento);
        produto.setNome(this.nome);
        produto.setModelo(this.modelo);
        produto.setTamanho(this.tamanho);
        produto.setUrlImagem(this.urlImagem);
        produto.setCodigoBarras(this.codigoBarras);
        produto.setDataLancamento(this.dataLancamento);

        return produto;
    }
}
