/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.avaliacao.resources;

import br.avaliacao.models.TipoUsuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.avaliacao.repository.TipoUsuarioRepository;

/**
 *
 * @author andre
 */
@RestController
@RequestMapping(value="/avaliacaoTecnicaBack")
@CrossOrigin(origins = "*")
public class TipoUsuarioResource
{
    @Autowired
    TipoUsuarioRepository tipoUsuarioRepository;
    
    @GetMapping("/tipoUsuario")
    public List<TipoUsuario> listTipoUsuario(){
        return tipoUsuarioRepository.findAll();
    }
    @PostMapping("/tipoUsuario")
    public TipoUsuario setTipoUsuario(@RequestBody TipoUsuario tipoUsuario){
        return tipoUsuarioRepository.save(tipoUsuario);
    }
}
