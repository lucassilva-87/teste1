package com.programacao.web.fatec.api_fatec.Controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExercicioController {
    @GetMapping("")
    public String HelloWorld(){
        return "Hello";
    }

    @GetMapping("{nome}")
    public String HelloWorld(@PathVariable Optional<String> nome){
        return nome.isPresent() ? nome.get(): "dd";
    }
    @GetMapping("/get-idade/{idade}")
    public String RetornaIdade(@PathVariable Integer idade){
        try{
            if(idade < 0){
                throw new NumberFormatException();
            }
            if(idade < 12){
                return "Criança";
            }
            else if(idade <= 18){
                return "Adolescente";
            }
            else if(idade <= 60){
                return "Adulto";
            }else{
                return "Idoso";
            }
        }catch(NumberFormatException e){
            return "Idade inválida";
        }
    }

    @GetMapping("/get-num/{num}")
    public String verificaParImpar(@PathVariable Optional<String> num){
        num.ifPresent(value -> System.out.println("Numero: " + value));
 
        try{
        int numInt = Integer.parseInt(num.get());
        if (numInt % 2 == 0 && numInt > 0){
            return "Número é par";
        }else if (numInt % 2 != 0 && numInt > 0){
            return "Número é impar";
        }else if (numInt == 0){
            return "Número é 0";
        } else {
            return "Número inválido";
        }
    }catch(NumberFormatException e) {
        return "O valor não é um número, informe novamente";
    }
}
}