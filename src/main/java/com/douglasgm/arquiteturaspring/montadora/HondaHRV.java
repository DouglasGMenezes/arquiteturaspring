package com.douglasgm.arquiteturaspring.montadora;

import java.awt.*;

public class HondaHRV extends Carro {

    public HondaHRV(Motor motor) {
        super(motor);
        setModelo("HRV");
        setCor(Color.GRAY);
        setMontadora(Montadora.HONDA);
    }

}
