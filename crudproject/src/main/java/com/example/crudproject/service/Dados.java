package com.example.crudproject.service;

import com.example.crudproject.model.Jogo;
import com.example.crudproject.repository.JogoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Dados implements CommandLineRunner {

    private final JogoRepository repository;

    public Dados(JogoRepository repository) {
        this.repository = repository;

    }
    @Override
    public void run(String... args) throws Exception {

        if (repository.count() == 0) {

            Jogo jogo1 = new Jogo();
            jogo1.setNome("The Legend of Zelda");
            jogo1.setTipo("Aventura");
            jogo1.setNota(10);
            jogo1.setReview("Um clássico absoluto.");

            Jogo jogo2 = new Jogo();
            jogo2.setNome("FIFA 23");
            jogo2.setTipo("Esporte");
            jogo2.setNota(7);
            jogo2.setReview("Bom para jogar com amigos.");

            repository.save(jogo1);
            repository.save(jogo2);
        }
    }
}