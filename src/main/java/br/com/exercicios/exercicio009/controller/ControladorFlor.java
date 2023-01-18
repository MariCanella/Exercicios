package br.com.exercicios.exercicio009.controller;

import br.com.exercicios.exercicio009.model.ModeloFlor;
import br.com.exercicios.exercicio009.repository.RepositorioFlor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flores")
public class ControladorFlor {

    @Autowired
    private RepositorioFlor flowerRepository;

    @GetMapping()
    public List<ModeloFlor> ListarFlor(){
        return (List<ModeloFlor>) flowerRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ModeloFlor salvarFlor(@RequestBody ModeloFlor flowerModel){
        flowerRepository.save(flowerModel);
        return flowerModel;
    }
    @PutMapping(value = "/{id}")
    public void atualizar (@PathVariable Long id, @RequestBody ModeloFlor flowerModel) throws Exception {
        ModeloFlor novaFlor = flowerRepository.findById(id).orElseThrow(() -> new Exception("Não existe flor com o Id flor" + id));
        novaFlor.setNome(flowerModel.getNome());
        novaFlor.setLocalizacao(flowerModel.getLocalizacao());
        flowerRepository.save(novaFlor);
    }

    @DeleteMapping(value = "/deleta/{id}")
    public void deletar(@PathVariable Long id) throws Exception {
        ModeloFlor novaFlor = flowerRepository.findById(id).orElseThrow(() -> new Exception("Não existe flor com o Id flor" + id));
        flowerRepository.delete(novaFlor);
    }
}
