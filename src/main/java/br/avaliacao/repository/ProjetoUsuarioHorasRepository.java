/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.avaliacao.repository;

import br.avaliacao.models.ProjetoUsuarioHoras;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author andre
 */
public interface ProjetoUsuarioHorasRepository extends JpaRepository<ProjetoUsuarioHoras,Integer>
{
    @Query("from ProjetoUsuarioHoras puh where puh.usuario.cdUsuario = :cdUsuario and puh.projeto.cdProjeto = :cdProjeto")
    List<ProjetoUsuarioHoras> listaProjetoUsuarioHoras(@Param("cdUsuario") Integer cdUsuario, @Param("cdProjeto") Integer cdProjeto);

    @Query("from ProjetoUsuarioHoras puh where puh.projeto.cdProjeto = :cdProjeto")
    List<ProjetoUsuarioHoras> listaProjetoUsuarioHoras(@Param("cdProjeto") Integer cdProjeto);

    @Query("select sum(puh.horas) from ProjetoUsuarioHoras puh where puh.projeto.cdProjeto = :cdProjeto")
    Double totalHoras(Integer cdProjeto);
}
