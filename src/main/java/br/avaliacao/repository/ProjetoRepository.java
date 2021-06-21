/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.avaliacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.avaliacao.models.Projeto;
import java.util.List;

/**
 *
 * @author andre
 */
public interface ProjetoRepository extends JpaRepository<Projeto, Integer>
{
    @Query("from Projeto p where p.usuario.cdUsuario = :cdUsuario")
    List<Projeto> projetosProg1(@Param("cdUsuario") Integer cdUsuario);
    
    @Query("from Projeto p where p.usuario.cdUsuario in (select u.cdUsuario from Usuario u where u.tipoUsuario.cdTipoUsuario in(2,3))")
    List<Projeto> projetosProg2();
}
