package br.com.alura.sreenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public record DadosEpisodio(@JsonAlias("Title") String tituloEpisodio,
                @JsonAlias("Episode") Integer numeroEpisodio,
                @JsonAlias("imdbRating") String avaliacaoEpisodio,
                @JsonAlias("Released") String dataLancamentoEpisodio) {

}
