package br.com.films_catalog.Servico;

import br.com.films_catalog.Objetos.Filme;
import br.com.films_catalog.Repositorio.FilmeRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class MenuFilmeService {
    FilmeRepositorio filmeRepositorio;

    public MenuFilmeService(FilmeRepositorio filmeRepositorio) {
        this.filmeRepositorio = filmeRepositorio;
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        Boolean verificar = true;

        while (verificar) {
            System.out.println("0 - Sair");
            System.out.println("1 - Cadastrar novo Filme");
            System.out.println("2 - Atualizar Filme");
            System.out.println("3 - Buscar Filmes");
            System.out.println("4 - Buscar Filme pelo Id");
            System.out.println("5 - Deletar Filme");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    this.cadastrar();
                    break;
                case 2:
                    this.atualizar();
                    break;
                case 3:
                    this.buscarTodos();
                    break;
                case 4:
                    this.buscarPorId();
                    break;
                case 5:
                    this.deletar();
                    break;
                default:
                    verificar = false;
                    break;
            }
        }
    }

    private void cadastrar() {
        Scanner s = new Scanner(System.in);
        System.out.println("Digite o nome do Filme: ");
        String nome = s.nextLine();

        s = new Scanner(System.in);
        System.out.println("Digite o ano de lançamento de " + nome + ": ");
        String ano = s.nextLine();

        s = new Scanner(System.in);
        System.out.println("Digite o nome do diretor de " + nome + ": ");
        String diretor = s.nextLine();

        s = new Scanner(System.in);
        System.out.println("Digite a sinopse de " + nome + ": ");
        String sinopse = s.nextLine();

        Filme filme = new Filme(nome, ano, diretor, sinopse);

        this.filmeRepositorio.save(filme);
    }

    private void atualizar() {
        Scanner s = new Scanner(System.in);
        System.out.println("Digite o ID do Filme a ser atualizado: ");
        Integer id = s.nextInt();

       Optional<Filme> optional = this.filmeRepositorio.findById(id);

       if (optional.isPresent()) {
           s = new Scanner(System.in);
           System.out.println("Digite o nome do Filme: ");
           String nome = s.nextLine();

           s = new Scanner(System.in);
           System.out.println("Digite o ano de lançamento de " + nome + ": ");
           String ano = s.nextLine();

           s = new Scanner(System.in);
           System.out.println("Digite o nome do diretor de " + nome + ": ");
           String diretor = s.nextLine();

           s = new Scanner(System.in);
           System.out.println("Digite a sinopse de " + nome + ": ");
           String sinopse = s.nextLine();

           Filme filme = optional.get();

           filme.setNome(nome);
           filme.setAnoLancamento(ano);
           filme.setDiretor(diretor);
           filme.setSinopse(sinopse);

           this.filmeRepositorio.save(filme);

           System.out.println("Filme atualizado com sucesso");
       } else {
           System.out.println("ID inválido");
       }
    }

    public void buscarTodos() {
        Iterable<Filme> filmes = this.filmeRepositorio.findAll();

        filmes.forEach(filme -> {
            System.out.println(filme);
        });
    }

    private void buscarPorId() {
        Scanner s = new Scanner(System.in);
        System.out.println("Digite o ID do Filme a ser pesquisado: ");
        Integer id = s.nextInt();

        Optional<Filme> optional = this.filmeRepositorio.findById(id);

        if (optional.isPresent()) {
            Filme filme = optional.get();
            System.out.println(filme);
        } else {
            System.out.println("ID inválido");
        }
    }

    private void deletar() {
        Scanner s = new Scanner(System.in);
        System.out.println("Digite o ID do Filme a ser deletado: ");
        Integer id = s.nextInt();

        this.filmeRepositorio.deleteById(id);
        System.out.println("Deletado com sucesso!");
    }
}
