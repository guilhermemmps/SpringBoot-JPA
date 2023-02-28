package org.example.localizacao.service;


import org.example.localizacao.domain.entity.Cidade;
import org.example.localizacao.domain.repository.CidadeRepository;
import org.example.localizacao.domain.repository.specs.CidadeSpecs;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CidadeService {

    private CidadeRepository cidadeRepository;

    public CidadeService(CidadeRepository cidadeRepository){
        this.cidadeRepository = cidadeRepository;
    }

    public void listarCidadesPorNomeSQL(){
        cidadeRepository
                .findByNomeSqlNativo("Rio de Janeiro")
                .forEach(System.out::println);

    }


    public void listarCidadesPorNome(){
        Pageable pageable = PageRequest.of(1,2);
        cidadeRepository.findByNomeLike("%%%%", pageable).forEach(System.out::println);
    }

    public void listarCidadesPorHabitante(){
        cidadeRepository.findByHabitantes(7770000L).forEach(System.out::println);
    }

    public void listarCidadesPorQuantidadeHabitantes() {
        cidadeRepository.findByHabitantes(3213213L);
    }

    @Transactional
    public void salvarCidade(){
        var cidade = new Cidade(1L,"Sao Paulo",13493234L);
        cidadeRepository.save(cidade);
    }

    public void listarCidades(){
        List<Cidade> all = cidadeRepository.findAll();
        if(all.isEmpty()){
            System.out.println("Vazio");
        }
        else {
            System.out.println("Nao esta vazio");
            all.forEach(System.out::println);
        }
    }


    public List<Cidade> filtroDinamico(Cidade cidade){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase();

        Example<Cidade> example = Example.of(cidade, matcher);

        return cidadeRepository.findAll(example);
    }

    public void listarCidadesByNomeSpec(){
        Specification<Cidade> spec = CidadeSpecs.nomeEqual("Rio de Janeiro").and(CidadeSpecs.habitantesGreaterThan(1000L));
        cidadeRepository.findAll(spec).forEach(System.out::println);
    }

}
