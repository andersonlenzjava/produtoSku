package br.com.testesmvc.produtoSku.repositories;

import br.com.testesmvc.produtoSku.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
