package br.com.fiap.projetoestagio.controllers;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.projetoestagio.models.Cadastro;

@RestController
public class CadastroController {
    
    @GetMapping("/api/cadastro")
    @ResponseBody
    public Cadastro realizandoCadastro() {

        Cadastro cadastro = new Cadastro("matheus@email.com", "matheusFiap20", "Matheus", new GregorianCalendar(1994, Calendar.AUGUST, 28), 111111111);

        return cadastro;
    }
}
