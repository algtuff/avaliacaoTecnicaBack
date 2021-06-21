/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.avaliacao.repository;

import br.avaliacao.models.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author andre
 */
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Integer>
{

}
