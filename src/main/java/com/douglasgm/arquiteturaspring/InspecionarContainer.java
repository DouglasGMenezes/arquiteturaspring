package com.douglasgm.arquiteturaspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;

public class InspecionarContainer implements CommandLineRunner {
    private final ApplicationContext context;

    public InspecionarContainer(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("=== Beans gerenciados pelo Spring ===");
        String[] nomes = context.getBeanDefinitionNames();
        for (String nome : nomes) {
            System.out.println("➡️ " + nome);
        }
        System.out.println("Total de beans: " + nomes.length);
    }
}
