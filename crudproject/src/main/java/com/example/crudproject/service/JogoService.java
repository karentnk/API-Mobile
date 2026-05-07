package com.example.crudproject.service;

import com.example.crudproject.model.Jogo;
import com.example.crudproject.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogoService {

    private final JogoRepository repository;

    public JogoService(JogoRepository repository) {
        this.repository = repository;
    }

    public List<Jogo> listarTodos() {
        return repository.findAll();
    }

    public Optional<Jogo> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Jogo cadastrar(Jogo jogo) {
        return repository.save(jogo);
    }

    public Optional<Jogo> atualizar(Long id, Jogo dados) {

        return repository.findById(id).map(jogo -> {

            jogo.setNome(dados.getNome());
            jogo.setTipo(dados.getTipo());
            jogo.setNota(dados.getNota());
            jogo.setReview(dados.getReview());

            return repository.save(jogo);
        });
    }

    public boolean deletar(Long id) {

        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }

        return false;
    }
}