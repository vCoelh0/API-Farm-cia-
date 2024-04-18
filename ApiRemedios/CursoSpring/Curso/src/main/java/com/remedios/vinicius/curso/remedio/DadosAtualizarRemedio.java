package com.remedios.vinicius.curso.remedio;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarRemedio(@NotNull Long id, String nome, via via, Laboratorio laboratorio) {

}
