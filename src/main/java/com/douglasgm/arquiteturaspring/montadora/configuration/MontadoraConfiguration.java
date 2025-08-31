package com.douglasgm.arquiteturaspring.montadora.configuration;

import com.douglasgm.arquiteturaspring.montadora.Carro;
import com.douglasgm.arquiteturaspring.montadora.Montadora;
import com.douglasgm.arquiteturaspring.montadora.Motor;
import com.douglasgm.arquiteturaspring.montadora.TipoMotor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import static java.awt.Color.WHITE;

@Configuration
public class MontadoraConfiguration {

//    public class Turbo {
//
//        private String turboM = "Turbo Médio.";
//        private String turboP = "Turbo Potente.";
//
//        public String getTurboM() {
//            return turboM;
//        }
//
//        public void setTurboM(String turboM) {
//            this.turboM = turboM;
//        }
//
//        public String getTurboP() {
//            return turboP;
//        }
//
//        public void setTurboP(String turboP) {
//            this.turboP = turboP;
//        }
//
//        Turbo obtendoTurboM = new Turbo();
//
//    };

    @Bean(name = "motorTrator")
    public Motor motorTrator() {
        Motor novoMotorT = new Motor();

        novoMotorT.setModelo("AqUaTiCo");
        novoMotorT.setTipo(TipoMotor.MOTOR_DE_TRATOR);
        novoMotorT.setLitragem(500.0);
        novoMotorT.setCilindros(9);
        novoMotorT.setCavalo(2);

        return novoMotorT;
    }

    @Bean(name = "motorAspirado")
    public Motor motorAspirado(){
        Motor novoMotor = new Motor();

        novoMotor.setCavalo(140);
        novoMotor.setCilindros(4);
        novoMotor.setLitragem(2.0);
        novoMotor.setTipo(TipoMotor.ASPIRADO);
        novoMotor.setModelo("XPTO-0");

        return novoMotor;
    }

    @Bean(name = "motorEletrico")
    public Motor motorEletrico(){
        var novoMotor = new Motor();

        novoMotor.setCavalo(120);
        novoMotor.setCilindros(3);
        novoMotor.setLitragem(3.0);
        novoMotor.setTipo(TipoMotor.ELETRICO);
        novoMotor.setModelo("HWT-5");

        return novoMotor;
    }

    @Bean(name = "motorTurbo")
    @Primary
    public Motor motorTurbo(){
        var novoMotor = new Motor();

        novoMotor.setCavalo(150);
        novoMotor.setCilindros(3);
        novoMotor.setLitragem(4.0);
        novoMotor.setTipo(TipoMotor.TURBO);
        novoMotor.setModelo("ZS-06P");

        return novoMotor;
    }

//    @Bean(name = "carro")
//    public Carro carro(Motor motor) {
//        var novoCarro = new Carro(motor);
//
//        novoCarro.setCor(WHITE);
//        novoCarro.setMontadora(Montadora.TOYTA);
//        novoCarro.setModelo("Yaris");
//
//        return novoCarro;
//    }

}
