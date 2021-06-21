/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.avaliacao.resources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.avaliacao.models.Projeto;
import br.avaliacao.models.Usuario;
import br.avaliacao.repository.ProjetoRepository;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author andre
 */
@RestController
@RequestMapping(value="/avaliacaoTecnicaBack")
@CrossOrigin(origins = "*")
public class ProjetoResource
{
    @Autowired
    ProjetoRepository projetoRepository;

    @PostMapping("/projetos")
    public List<Projeto> projetos(@RequestBody Usuario usuario){
        if(null==usuario.getTipoUsuario().getCdTipoUsuario()){
            return projetoRepository.projetosProg2();
        }else switch (usuario.getTipoUsuario().getCdTipoUsuario())
        {
            case 1:
                return projetoRepository.findAll();
            case 2:
                return projetoRepository.projetosProg1(usuario.getCdUsuario());
            default:
                return projetoRepository.projetosProg2();
        }
    }
    
    @PostMapping("/projeto")
    public Projeto projetos(@RequestBody Projeto projeto){
        return projetoRepository.save(projeto);
    }

    @GetMapping("/projeto")
    public List<Projeto> projetos(){
        return projetoRepository.findAll();
    }
}
