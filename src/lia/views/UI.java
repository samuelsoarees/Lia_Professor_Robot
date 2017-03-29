package lia.views;

import java.io.IOException;
import java.util.Scanner;

import lia.controllers.LIAController;

public class UI {
   LIAController lc = new LIAController();
   
   public String inicioConversa(String pergunta) throws IOException {
     
        lc.carregaArray();
        


        pergunta = pergunta.toUpperCase();

        // se a pessoa pedir para sair, ele vai guardar todas as perguntas num txt para futuras atualiza��es
        if (pergunta.equals("SAIR")) {
            lc.descarregaPerguntasTXT();
            lc.descarregaConhecimentoTXT();
            System.exit(0);
        }

        // vai procurar uma resposta na camada abaixo
        return lc.resposta(pergunta);

    }
    
    public String aprender(String pergunta){
        String msg="GUARDEI SUA PERGUNTA E DEPOIS LHE RESPONDO";
        
        
        if(pergunta.toUpperCase().equals("NÃO SEI")){ 
        return msg;
        } 
        return lc.guardaReposta(pergunta.toUpperCase());
        
    }
    
    

}
