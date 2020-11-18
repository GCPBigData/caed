package br.caed.controller;

import br.caed.domain.Pessoa;
import br.caed.repository.PessoaRepository;
import br.caed.service.PessoaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("pessoas")
@Slf4j
@RequiredArgsConstructor
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<Pessoa> listAll() {
        return pessoaRepository.findAll();
    }
}
