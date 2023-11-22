package br.com.ramirez.screenmatch.controller;

import br.com.ramirez.screenmatch.domain.filme.DadosCadastroFilme;
import br.com.ramirez.screenmatch.domain.filme.Filme;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


//Recebe requisições
@Controller
//Informa url da requisição que chega aqui neste controlador
@RequestMapping("/filmes")
public class FilmeController {

    private List<Filme> filmes  = new ArrayList<>();

    //Informa o método a ser chamado caso a requisição chegue com o método GET
    @GetMapping("/formulario")
    public String carregaPaginaFormulario(){
        return "filmes/formulario";
    }

    @GetMapping
    public String carregaPaginaListagem(){
        return "filmes/listagem";
    }

    @PostMapping
    public String cadastroFilme(DadosCadastroFilme dados){
        var filme = new Filme(dados);
        filmes.add(filme);
        System.out.println(filmes);
        return "filmes/formulario";
    }

}
