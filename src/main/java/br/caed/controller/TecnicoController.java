package br.caed.controller;

import br.caed.domain.Tecnico;
import br.caed.dto.TecnicoDTO;
import br.caed.repository.TecnicoRepository;
import br.caed.service.TecnicoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.time.Duration;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("tecnicos")
@Slf4j
@RequiredArgsConstructor
@SecurityScheme(
        name = "Basic Authentication",
        type = SecuritySchemeType.HTTP,
        scheme = "basic"
)
public class TecnicoController {

    @Autowired
    private TecnicoService tecnicoService;

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "List all tecnicos",
            security = @SecurityRequirement(name = "Basic Authentication"),
            tags = {"tecnico"})
    public Flux<Tecnico> listAll() {
        return tecnicoService.findAll();
    }

    @GetMapping(path = "{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            security = @SecurityRequirement(name = "Basic Authentication"),
            tags = {"tecnico"})
    public Mono<Tecnico> findById(@PathVariable int id) {
        return tecnicoService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
            security = @SecurityRequirement(name = "Basic Authentication"),
            tags = {"tecnico"})
    public Mono<Tecnico> save(@Valid @RequestBody Tecnico tecnico) {
        return tecnicoService.save(tecnico);
    }

    @PostMapping("batch")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
            security = @SecurityRequirement(name = "Basic Authentication"),
            tags = {"tecnico"})
    public Flux<Tecnico> saveBatch(@RequestBody List<Tecnico> tecnicos) {
        return tecnicoService.saveAll(tecnicos);
    }

    @PutMapping(path = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(
            security = @SecurityRequirement(name = "Basic Authentication"),
            tags = {"tecnico"})
    public Mono<Void> update(@PathVariable int id, @Valid @RequestBody Tecnico tecnico) {
        return tecnicoService.update(tecnico.withId(id));
    }

    @DeleteMapping(path = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(
            security = @SecurityRequirement(name = "Basic Authentication"),
            tags = {"tecnico"})
    public Mono<Void> delete(@PathVariable int id) {
        return tecnicoService.delete(id);
    }

/*    @PutMapping(path = "/tecnicoDesativar/{id}")
    public Mono<ResponseEntity<Tecnico>>
    updatePessoa(@PathVariable(value="id") int id,
                 @RequestBody Tecnico tecnico) {
        return tecnicoService.findById(id)
                .flatMap(tecnicoExiste -> {
                    tecnico.setNome(tecnico.getNome());
                    tecnico.setStatus(tecnico.getStatus());

                    return tecnicoService.update(tecnico);
                })
                .map(updateTecnico -> ResponseEntity.ok(updateTecnico))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }*/


    @GetMapping("/buscaPorNome/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public Flux<ResponseEntity<Tecnico>> getByNome(@PathVariable String nome) {
        return tecnicoRepository.findByNome(nome)
                .filter(c -> c.getStatus().equals("Ativo"))
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @RequestMapping(value="/flux20Ativos", method= RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<TecnicoDTO>> findAllAtivos() {
        Flux<Tecnico> listFlux = tecnicoService.findAll();
        List<TecnicoDTO> listDto = listFlux.toStream()
                .sorted(Comparator.comparing(Tecnico::getId).reversed())
                .filter(c -> c.getStatus().equals("Ativo"))
                .map(TecnicoDTO::new)
                .limit(20)
                .collect( Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value="/flux20Inativos", method= RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<TecnicoDTO>> findAllInativos() {
        Flux<Tecnico> listFlux = tecnicoService.findAll();
        List<TecnicoDTO> listDto = listFlux.toStream()
                .sorted(Comparator.comparing(Tecnico::getId).reversed())
                .filter(c -> c.getStatus().equals("Inativos"))
                .map(TecnicoDTO::new)
                .limit(20)
                .collect( Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tecnico> streamTecnicoStatus() {
        return tecnicoService.findAll().delayElements(Duration.ofSeconds(1));
    }
}
