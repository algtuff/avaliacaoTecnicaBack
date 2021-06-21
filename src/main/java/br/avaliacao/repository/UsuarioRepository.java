/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.avaliacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.avaliacao.models.Usuario;

/**
 *
 * @author andre
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>
{
    @Query("from Usuario u where u.email like :email and u.password = :password")
    Usuario login(@Param("email") String email, @Param("password") String password);
}
