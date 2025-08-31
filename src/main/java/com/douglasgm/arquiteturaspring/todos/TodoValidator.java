package com.douglasgm.arquiteturaspring.todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TodoValidator {

    @Autowired
    private TodoRepository repository;

    public void validar(TodosEntity todo){
        if(existeTodoComDescricao(todo.getDescricao())){
            throw new RuntimeException("Já existe um To-Do com descrição inserida.");
        }
    }

    private boolean existeTodoComDescricao(String descricao){
        return repository.existsByDescricao(descricao);
    }

}
