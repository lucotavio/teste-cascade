package br.com.luciano.testecascade;

import br.com.luciano.testecascade.entity.Dependente;
import br.com.luciano.testecascade.entity.Socio;
import br.com.luciano.testecascade.repository.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
    
    @Autowired
    private SocioRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        deletarDependentes();
    }
    
    public void inserirSocio(){
        Dependente dependente1 = new Dependente("Karine");
        Dependente dependente2 = new Dependente("Pedro");
        
        Socio socio = new Socio("Luciano");
        socio.adicionarDependente(dependente1);
        socio.adicionarDependente(dependente2);
        repository.save(socio);
    }
    
    public void deletarDependentes(){
        Dependente dependente1 = new Dependente("Karine");
        
        Socio socio = new Socio("Luciano");
        socio.setId(1);
        socio.adicionarDependente(dependente1);
        repository.update(socio);
    }

}
