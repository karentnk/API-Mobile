package com.example.crudproject.controller;

import com.example.crudproject.model.Jogo;
import com.example.crudproject.service.JogoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/jogos")
public class JogoController {

    private final JogoService service;

    public JogoController(JogoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Jogo>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }
    @GetMapping("/")
    public String inicio() {
        return "API funcionando";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogo> buscarPorId(@PathVariable Long id) {

        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Jogo> cadastrar(@RequestBody Jogo jogo) {

        Jogo novo = service.cadastrar(jogo);

        return ResponseEntity.status(201).body(novo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jogo> atualizar(@PathVariable Long id,
                                          @RequestBody Jogo jogo) {

        return service.atualizar(id, jogo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {

        if (service.deletar(id)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
