package br.caed.service;

import br.caed.domain.Tecnico;
import br.caed.repository.TecnicoRepository;
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
public class TecnicoService {

    private final TecnicoRepository tecnicoRepository;

    public Flux<Tecnico> findAll() {
        return tecnicoRepository.findAll();
    }

    public Mono<Tecnico> findById(int id) {
        return tecnicoRepository.findById(id)
                .switchIfEmpty(monoResponseStatusNotFoundException());
    }

    public Mono<Tecnico> save(Tecnico tecnico) {
        return tecnicoRepository.save(tecnico);
    }

    @Transactional
    public Flux<Tecnico> saveAll(List<Tecnico> tecnicos) {
        return tecnicoRepository.saveAll(tecnicos)
                .doOnNext(this::throwResponseStatusExceptionWhenEmptyName);
    }

    public Mono<Void> update(Tecnico tecnico) {
        return findById(tecnico.getId())
                .flatMap(tecnicoRepository::save)
                .then();
    }

    public Mono<Void> delete(int id) {
        return findById(id)
                .flatMap(tecnicoRepository::delete);
    }

    private void throwResponseStatusExceptionWhenEmptyName(Tecnico tecnico){
        if(StringUtil.isNullOrEmpty(tecnico.getNome())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid Name");
        }
    }

    public <T> Mono<T> monoResponseStatusNotFoundException() {
        return Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Tecnico not found"));
    }
}
