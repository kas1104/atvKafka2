package com.atvKafka.Spring.controller;

//Bibliotecas e conexões com as demais classes
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Classe controller
@RestController
@RequestMapping("/produto")
public class ProdutoController {

    //Variáveis que instanciam as demais classes
    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "produto";

    //Construtor que instancia as variáveis
    public ProdutoController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    //Metodo Post que irá enviar uma mensagem para o tópico criado do kafka
    @PostMapping
    public String enviarProduto(@RequestBody String mensagem){
        kafkaTemplate.send(TOPIC, mensagem);
        return "Produto cadastrado com sucesso!!" + mensagem;

    }
}
