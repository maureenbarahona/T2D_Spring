/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa2.app.repositorios;

import hn.uth.pa2.app.modelos.Usuario;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author mbarahona
 */
public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {
   /* public Usuario findByCorreoAndPassword(String email, String password); */
}
