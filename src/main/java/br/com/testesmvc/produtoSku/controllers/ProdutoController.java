package br.com.testesmvc.produtoSku.controllers;

import br.com.testesmvc.produtoSku.dto.FormProdutoDto;
import br.com.testesmvc.produtoSku.models.Produto;
import br.com.testesmvc.produtoSku.repositories.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("")
    public ModelAndView index() {

        List<Produto> produtos = produtoRepository.findAll();
        ModelAndView mv = new ModelAndView("produtos/index");
        mv.addObject("produtos", produtos);

        return mv;
    }

    @GetMapping("/new")
    public ModelAndView nnew(FormProdutoDto formProdutoDto) {
        ModelAndView mv = new ModelAndView("produtos/new");

        return mv;
    }

    // recebe a view e caso não tenha erros de validação passa para a próxima ação
    @PostMapping("")
    public ModelAndView create(@Valid FormProdutoDto formProdutoDto, BindingResult bindingResult) {

        // se a validação tiver erros faz esta operação
        if (bindingResult.hasErrors()) {
            System.out.println("\n******************** TEM ERROS *****************\n");

//          caso tenha erros de validação retorna a view com os valores preenchidos
            ModelAndView mv = new ModelAndView("produtos/new");

            return mv;
        }
        else {
            Produto produto = formProdutoDto.toProduto();
            this.produtoRepository.save(produto);

//          após criar os professores chava o seu detalhamento através da string montada abaixo
            return new ModelAndView("redirect:/produtos/" + produto.getId());
        }

    }

    @GetMapping("/{id}")
    public ModelAndView show(@PathVariable Long id) {
       Optional<Produto> optionalProduto = this.produtoRepository.findById(id);

       if(optionalProduto.isPresent()) {
           Produto produto =optionalProduto.get();

           ModelAndView mv = new ModelAndView("produtos/show");
           mv.addObject("produto", produto);

           return mv;
       }
       else {
            System.out.println("********* NÃO FOI ENCONTRADO O PRODUTO DE ID " + id + " *********");
           //poderia fazer uma mensagem de erro, mas redireciona para a listagem
           return new ModelAndView("redirect:/produtos");
       }
    }

    // OBS: aqui o correto é PUT mas o html não permite
    @GetMapping("/{id}/edit")
    public ModelAndView edit(@PathVariable Long id, FormProdutoDto formProdutoDto) {
        Optional<Produto> optionalProduto = this.produtoRepository.findById(id);

        if(optionalProduto.isPresent()) {
            Produto produto = optionalProduto.get();
            formProdutoDto.fromProduto(produto);

//            modifica o objeto reqnovoprof que é passado para view
            ModelAndView mv = new ModelAndView("produtos/edit");
            mv.addObject("produtoId",produto.getId());
            return mv;
        }
            else {
            System.out.println("********* NÃO FOI ENCONTRADO O PRODUTO DE ID " + id + " *********");
            //poderia fazer uma mensagem de erro, mas redireciona para a listagem
            return new ModelAndView("redirect:/produtos");
        }
    }

    @PostMapping("/{id}")
    public ModelAndView update(@PathVariable Long id, @Valid FormProdutoDto formProdutoDto,
                               BindingResult bindingResult) {
        // se a validação tiver erros faz esta operação
        if (bindingResult.hasErrors()) {
            System.out.println("\n******************** TEM ERROS *****************\n");

            ModelAndView mv = new ModelAndView("produtos/edit");
            // passagem do id do objeto para o caso de entrar no form erro
            mv.addObject("produtoId", id);

            return mv;

        }
        else {
            Optional<Produto> optionalProduto = this.produtoRepository.findById(id);

            if(optionalProduto.isPresent()) {
                Produto produto = formProdutoDto.toProduto(optionalProduto.get());
                this.produtoRepository.save(produto);

                // redireciona para os detalhes do recurso atualizado (da mesma forma quando é criado)
                return new ModelAndView("redirect:/produtos/" + produto.getId());

            }  else {
                System.out.println("##### NÃO FOI ENCONTRADO O PRODUTO DE ID " + id + " ####");
                //poderia fazer uma mensagem de erro, mas redireciona para a listagem
                return new ModelAndView("redirect:/produtos");
            }
        }
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        try {
            this.produtoRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            System.out.println(e);
            return "redirect:/produtos";
        }
        return "redirect:/produtos";
    }


}
