package com.douglasgm.arquiteturaspring.todos;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/todo")
public class TodoController {

    private TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @PostMapping
    public TodosEntity salvar(@RequestBody TodosEntity entity){
        return service.salvar(entity);
    }

    @PutMapping("{id}")
    public TodosEntity atualizar(@RequestBody TodosEntity entity, @PathVariable("id") Integer id){
        entity.setId(id);
        service.atualizar(entity);
        return entity;
    }

    @GetMapping("{id}")
    public TodosEntity obter(@PathVariable("id") Integer id){
        return service.obter(id);
    }

    @DeleteMapping("{id}")
    public String deletar(@PathVariable("id") Integer id){
        return service.deletar(id);
    }
}
