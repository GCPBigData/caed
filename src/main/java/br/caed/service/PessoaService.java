package br.caed.service;

import br.caed.domain.Pessoa;
import br.caed.repository.PessoaRepository;
import io.netty.util.internal.StringUtil;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class PessoaService {

    private PessoaRepository PessoaRepository;

    public Flux<Pessoa> findAll() {
        return PessoaRepository.findAll();
    }

    public Mono<Pessoa> findById(int id) {
        return PessoaRepository.findById(id)
                .switchIfEmpty(monoResponseStatusNotFoundException());
    }

    public Mono<Pessoa> save(Pessoa Pessoa) {
        return PessoaRepository.save(Pessoa);
    }

    @Transactional
    public Flux<Pessoa> saveAll(List<Pessoa> Pessoas) {
        return PessoaRepository.saveAll(Pessoas)
                .doOnNext(this::throwResponseStatusExceptionWhenEmptyName);
    }

    public Mono<Void> update(Pessoa Pessoa) {
        return findById(Pessoa.getId())
                .flatMap(PessoaRepository::save)
                .then();
    }

    public Mono<Void> delete(int id) {
        return findById(id)
                .flatMap(PessoaRepository::delete);
    }

    private void throwResponseStatusExceptionWhenEmptyName(Pessoa Pessoa){
        if(StringUtil.isNullOrEmpty(Pessoa.getNome())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid Name");
        }
    }

    public <T> Mono<T> monoResponseStatusNotFoundException() {
        return Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa not found"));
    }
}
