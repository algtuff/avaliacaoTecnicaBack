/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.avaliacao.resources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.avaliacao.models.Usuario;
import br.avaliacao.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author andre
 */
@RestController
@RequestMapping(value="/avaliacaoTecnicaBack")
@CrossOrigin(origins = "*")
public class UsuarioResource
{
    @Autowired
    UsuarioRepository usuarioRepository;
    
    @GetMapping("/usuarios")
    public List<Usuario> listUsuario(){
        return usuarioRepository.findAll();
    }

    @GetMapping("/usuario/{cdUsuario}")
    public Usuario usuarioById(@PathVariable(value="cdUsuario") Integer cdUsuario){
        return usuarioRepository.findById(cdUsuario).get();
    }

    @PostMapping("/login")
    public Usuario login(@RequestBody Usuario usuario){
        System.out.println(usuario.getEmail()+" - "+ usuario.getPassword());
        return usuarioRepository.login(usuario.getEmail(), usuario.getPassword());
    } 
    
    @PostMapping("/usuario")
    public Usuario setUsuario(@RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);
    }
}
