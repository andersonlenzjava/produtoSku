package br.com.testesmvc.produtoSku.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private String marca;
    @Column(nullable = false)
    private String departamento;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String modelo;
    @Column(nullable = false)
    private String tamanho;
    @Column(nullable = false)
    private String urlImagem;
    @Column(nullable = false)
    private String codigoBarras;
    @Column(nullable = false)
    private String dataLancamento;

}
