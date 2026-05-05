package com.atvKafka.Consumer.consumer;

//Biblioteca e conexões com as demais classes
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

//Classe Consumer
@Component
public class produtoConsumer {

    //Função que irá consumir as mensagens dos tópicos
    @KafkaListener(topics = "produto", groupId = "grupo-produto")
    public void consumirEventos(String notificacao){
        System.out.println("Produto cadastrado com sucesso: " + notificacao + "!!!");
    }
}
