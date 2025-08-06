package com.foro.foroapi.repository;

import com.foro.foroapi.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopicoRepository extends JpaRepository<Topico, Long> {


    List<Topico> findTop10ByOrderByFechaCreacionAsc();


    @Query("SELECT t FROM Topico t WHERE t.curso = :curso AND YEAR(t.fechaCreacion) = :anio")
    List<Topico> buscarPorCursoYAnio(@Param("curso") String curso, @Param("anio") int anio);
}
