package com.foro.foroapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "topicos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El título es obligatorio")
    private String titulo;

    @NotBlank(message = "El mensaje es obligatorio")
    @Column(columnDefinition = "TEXT")
    private String mensaje;

    @NotNull
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @NotBlank(message = "El estado es obligatorio")
    private String status;

    @NotBlank(message = "El autor es obligatorio")
    private String autor;

    @NotBlank(message = "El curso es obligatorio")
    private String curso;
}
