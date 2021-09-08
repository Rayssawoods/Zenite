package orion.zenite.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import orion.zenite.entidades.Conta;
import orion.zenite.entidades.Gerente;
import orion.zenite.entidades.PontoFinal;

import java.util.List;
import java.util.Optional;

public interface GerenteRepository extends JpaRepository<Gerente, Integer> {
    @Query(value = "select max(g.id) from Gerente g")
    int lastId();

    Optional<Gerente> findByConta(Conta conta);

    List<Gerente> findAllByNomeContaining(String nome);

    Gerente findByConta(String cpf);
}
