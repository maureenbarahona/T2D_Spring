/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa2.app.controloradores;

import hn.uth.pa2.app.modelos.Usuario;
import hn.uth.pa2.app.servicios.UsuarioService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mbarahona
 */
@RestController
@RequestMapping("/ws/usuarios/")
public class UsuarioRestController {
    @Autowired
    private UsuarioService servicio;
    
    @GetMapping("/")
    public List<Usuario> getListaUsuario(){
        return servicio.getLista();
    }
    
    @GetMapping("/{id}")
    public Optional<Usuario> getUsuarioById(@PathVariable Long id){
        return servicio.getEntidad(id);
    }
  /*  
    @PostMapping("/login")
    public String validaL(@PathVariable String email, String password){
    servicio.getUsuario(email, password);
    return "login exitoso";
    }
   */ 
    @PostMapping("/guardarUsuario")
    public String guardar(@RequestBody Usuario usuario){
        servicio.guardar(usuario);
        return "elemento guardado";
    }
    
    @GetMapping("/eliminarUsuario/{id}")
    public String eliminar(@PathVariable Long id){
        servicio.eliminar(id);
        return "elemento eliminado";
    }
}
