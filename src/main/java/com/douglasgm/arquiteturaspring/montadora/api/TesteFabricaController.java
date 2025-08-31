package com.douglasgm.arquiteturaspring.montadora.api;

import com.douglasgm.arquiteturaspring.montadora.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carros")
public class TesteFabricaController {

    @Autowired
    @Aspirado
    private Motor motorAspirado;
    @Autowired
    @Eletrico
    private Motor motorEletrico;
    @Autowired
    @Trator
    private Motor motorT;

    @PostMapping("/aspirado")
    public CarroStatus ligarCarro(@RequestBody Chave chave){
        var carroHonda = new HondaHRV(motorAspirado);
        CarroStatus ligar = carroHonda.darIgnicao(chave);
        return ligar;
    }

    @PostMapping("/eletrico")
    public CarroStatus ligarOutroCarro(@RequestBody Chave chave){
            var outroCarro = new HondaHRV(motorEletrico);
            CarroStatus ligarOutro = outroCarro.darIgnicao(chave);
        return ligarOutro;
    }

    @PostMapping("/trator")
    public CarroStatus moterT(@RequestBody Chave chave) {
        var carroTrator = new HondaHRV(motorT);
        CarroStatus ligarTrator = carroTrator.darIgnicao(chave);
        return ligarTrator;
    }


}
