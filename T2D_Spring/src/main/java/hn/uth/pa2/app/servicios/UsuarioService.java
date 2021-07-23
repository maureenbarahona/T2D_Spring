/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa2.app.servicios;

import hn.uth.pa2.app.modelos.Usuario;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hn.uth.pa2.app.repositorios.UsuarioRepositorio;

/**
 *
 * @author mfbarahona
 */
@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepositorio repositorio;
    
    public void guardar(Usuario usuario){
        repositorio.save(usuario);
    }
    
    public void eliminar(Long id){
        repositorio.deleteById(id);
    }
 
    /*
    public  Usuario getUsuario(String email, String password){
    return repositorio.findByCorreoAndPassword(email, password);
    }
    */
    public Optional<Usuario> getEntidad(Long id){
        return repositorio.findById(id);
    }
    
    public List<Usuario> getLista(){
        return (List<Usuario>) repositorio.findAll();
    }
    
}
