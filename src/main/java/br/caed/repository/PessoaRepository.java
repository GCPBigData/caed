package br.caed.repository;

import br.caed.domain.Pessoa;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PessoaRepository extends ReactiveCrudRepository<Pessoa, Integer> {
    Mono<Pessoa> findById(int id);
    Flux<Pessoa> findByNome(String nome);
}
