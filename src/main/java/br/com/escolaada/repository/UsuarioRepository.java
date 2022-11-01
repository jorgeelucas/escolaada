package br.com.escolaada.repository;

import br.com.escolaada.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    Optional<Usuario> findUsuarioByUsuario(String usuario);

}
