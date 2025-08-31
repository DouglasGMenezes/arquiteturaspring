package com.douglasgm.arquiteturaspring.todos;

import com.douglasgm.arquiteturaspring.todos.exceptions.RespostasErros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TodoService {

    private TodoRepository repository;
    private TodoValidator validator;
    private MailSender enviarMail;

    public TodoService(TodoRepository repository, TodoValidator validator, MailSender enviarMail) {
        this.repository = repository;
        this.validator = validator;
        this.enviarMail = enviarMail;
    };

    public TodosEntity salvar(TodosEntity novoTodo) {
        try {
            validator.validar(novoTodo);
            return repository.save(novoTodo);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    };


    public void atualizar(TodosEntity atualiado) {
        repository.save(atualiado);
        String status = atualiado.getConcluido() == Boolean.TRUE ? "Concluido" : "Nao concluido";
        enviarMail.enviar("To-do " + atualiado.getDescricao() + " foi atualizado para " + status );
    };

    public TodosEntity obter(Integer id) {
        return repository.findById(id).orElse(null);
    };

    public String deletar(Integer id) {

        if(repository.findById(id).isPresent()) {
            repository.deleteById(id);
            return  "deletado com sucesso.";
        } else {
           throw new RespostasErros( "To-Do com: "+ id + " não encontrado.");
        }

    };

}
