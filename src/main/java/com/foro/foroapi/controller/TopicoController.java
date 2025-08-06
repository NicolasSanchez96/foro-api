package com.foro.foroapi.controller;

import com.foro.foroapi.model.Topico;
import com.foro.foroapi.repository.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoRepository topicoRepository;

    public TopicoController(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }

    // registrar un nuevo tópico
    @PostMapping
    @Transactional
    public ResponseEntity<Topico> registrar(@RequestBody @Valid Topico topico) {
        Topico nuevoTopico = topicoRepository.save(topico);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoTopico);
    }

    // listar todos los tópicos
    @GetMapping
    public List<Topico> listar() {
        return topicoRepository.findAll();
    }

    // listar primeros 10 tópicos ordenados por fecha creación ascendente
    @GetMapping("/top10")
    public List<Topico> listarTop10() {
        return topicoRepository.findTop10ByOrderByFechaCreacionAsc();
    }

    // buscar tópicos por curso y año
    @GetMapping("/buscar")
    public List<Topico> buscarPorCursoYAnio(@RequestParam String curso, @RequestParam int anio) {
        return topicoRepository.buscarPorCursoYAnio(curso, anio);
    }

    // obtener detalle de un tópico por ID
    @GetMapping("/{id}")
    public ResponseEntity<Topico> obtenerPorId(@PathVariable Long id) {
        return topicoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Topico> actualizar(@PathVariable Long id, @Valid @RequestBody Topico topicoDetalles) {
        return topicoRepository.findById(id)
                .map(topicoExistente -> {

                    topicoExistente.setTitulo(topicoDetalles.getTitulo());
                    topicoExistente.setMensaje(topicoDetalles.getMensaje());
                    topicoExistente.setStatus(topicoDetalles.getStatus());
                    topicoExistente.setAutor(topicoDetalles.getAutor());
                    topicoExistente.setCurso(topicoDetalles.getCurso());

                    Topico actualizado = topicoRepository.save(topicoExistente);
                    return ResponseEntity.ok(actualizado);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        var topicoOpt = topicoRepository.findById(id);
        if (topicoOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        topicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}



