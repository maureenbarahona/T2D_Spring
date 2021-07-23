/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa2.app.controloradores;

import hn.uth.pa2.app.modelos.Usuario;
import hn.uth.pa2.app.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author mfbarahona
 */
@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService servicio;

    @RequestMapping("/usuario")
    public String index(Model model) {
        model.addAttribute("lista", servicio.getLista());
        return "index";
    }

    @GetMapping("/crearUsuario")
    public String abrirFormularioCrearUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarioFormulario";
    }

   

    @GetMapping("/actualizarUsuario/{id}")
    public String abrirFormularioActualizarUsuario(@PathVariable Long id, Model model) {
        model.addAttribute("usuario", servicio.getEntidad(id));
        return "usuarioFormulario";
    }
    
       @GetMapping("/inicio")
    public String abrilLogin(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "inicio";
    }
   
   
    @GetMapping("/login")
    public String validaLogin(Model model){
    model.addAttribute("usuario", new Usuario());
    return "redirect:/";
    }

    @PostMapping("/guardarFormularioUsuario")
    public String guardarFormularioUsuario(Usuario usuario, Model model) {
        servicio.guardar(usuario);
        return "redirect:/";
    }

    @GetMapping("/eliminarUsuario/{id}")
    public String eliminarUsuario(@PathVariable Long id, Model model) {
        servicio.eliminar(id);
        return "redirect:/";
    }

}
