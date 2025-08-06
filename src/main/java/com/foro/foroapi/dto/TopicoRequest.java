package com.foro.foroapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TopicoRequest {

    @NotBlank(message = "El título es obligatorio")
    private String titulo;

    @NotBlank(message = "El mensaje es obligatorio")
    private String mensaje;

    @NotBlank(message = "El autor es obligatorio")
    private String autor;

    @NotBlank(message = "El curso es obligatorio")
    private String curso;
}
