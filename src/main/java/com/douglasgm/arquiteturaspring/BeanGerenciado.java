package com.douglasgm.arquiteturaspring;

import com.douglasgm.arquiteturaspring.todos.TodoRepository;
import com.douglasgm.arquiteturaspring.todos.TodoValidator;
import com.douglasgm.arquiteturaspring.todos.TodosEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Lazy(value = false)
@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)
//  @Scope(WebApplicationContext.SCOPE_SESSION)
//    @Scope("singleton") // default
//@Scope("request")
//@Scope("session")
//@Scope("application")
//@Scope("prototype")
public class BeanGerenciado {

    @Autowired
    private TodoRepository repository;
    @Autowired
    private TodoValidator validator;

    public BeanGerenciado( TodoRepository repository , TodoValidator validator ) {
        this.repository = repository;
        this.validator = validator;
    }

    public void setRepository(TodoRepository repository){
        this.repository = repository;
    }

    public void alterar(){
        var todo = new TodosEntity();
        validator.validar(todo);
    }

}
