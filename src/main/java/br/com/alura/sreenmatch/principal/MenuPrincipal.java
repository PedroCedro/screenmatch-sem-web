package br.com.alura.sreenmatch.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.alura.sreenmatch.model.DadosEpisodio;
import br.com.alura.sreenmatch.model.DadosSerie;
import br.com.alura.sreenmatch.model.DadosTemporada;
import br.com.alura.sreenmatch.service.ConsumoApi;
import br.com.alura.sreenmatch.service.ConverteDados;

public class MenuPrincipal {

    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();
    private Scanner leitura = new Scanner(System.in);
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String APIKEY = "&apikey=8cca9ce4";

    public void exibeMenu() {
        System.out.println("Digite o nome da série para busca");
        var nomeSerie = leitura.nextLine();
        var json = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + APIKEY);
        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
        System.out.println(dados);

        List<DadosTemporada> temporadas = new ArrayList<>();

        for (int i = 1; i <= dados.totalTemporadas(); i++) {
            json = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&season=" + i + APIKEY);
            DadosTemporada dadosTemporada = conversor.obterDados(json,
                    DadosTemporada.class);
            temporadas.add(dadosTemporada);

        }
        temporadas.forEach(System.out::println);

        for (int i = 0; i < dados.totalTemporadas(); i++) {

            List<DadosEpisodio> episodiosTemporada = temporadas.get(i).episodios();
            for (int j = 0; j < episodiosTemporada.size(); j++) {
                System.out.println(episodiosTemporada.get(j).tituloEpisodio());
            }

        }

    }

}
