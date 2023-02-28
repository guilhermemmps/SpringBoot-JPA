package org.example.localizacao.domain.repository.specs;

import org.example.localizacao.domain.entity.Cidade;
import org.springframework.data.jpa.domain.Specification;

public abstract class CidadeSpecs {

    public static Specification<Cidade> nomeEqual(String nome){
        return (root, query, cb) -> cb.equal( root.get("nome"),nome  );
    }

    public static Specification<Cidade> habitantesGreaterThan(Long value){
        return (root, query, cb) -> cb.greaterThan( root.get("habitantes"),value  );
    }

    public static Specification<Cidade> habitantesBetween(Long initialValue, Long endValue){
        return (root, query, cb) -> cb.between( root.get("habitantes"), initialValue, endValue );
    }

    public static Specification<Cidade> nomeLike(String nome) {
        return (root, query, cb) -> cb.like(cb.upper(root.get("nome")), "%" + nome + "%".toUpperCase());
    }
}
