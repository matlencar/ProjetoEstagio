import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.projetoestagio.models.Publicacao;

@RestController
public class PublicacaoController{
    
    @GetMapping("/api/publicacao")
    @ResponseBody
    public Publicacao show(){

        Publicacao publicacao = new Publicacao(new String("Ola"), LocalDate.now(), "Programando em java");

        return publicacao;
    }
}