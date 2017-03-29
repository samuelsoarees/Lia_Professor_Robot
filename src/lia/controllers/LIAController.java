package lia.controllers;

import java.io.IOException;

import lia.model.Conhecimento;


public class LIAController {
	// Controlador que s� indica os caminhos para a camada de dados chamada model que est� abaixo
	Conhecimento c = new Conhecimento();
	
	
	// metodo para carregar o array antes da conversa come�ar
	public void carregaArray() {
		c.carregaArray();
	}
	// procurar a resposta com base no que foi passado como pergunta
	public String resposta(String pergunta) throws IOException {
		return c.procuraResposta(pergunta);
	}
	// guarda tudo que n�o sabe num txt
	public void descarregaPerguntasTXT() throws IOException {
		c.armazenaNovasPerguntasTXT();
	}
        
        public String guardaReposta(String resposta){
            return c.armazenaRespostaArray(resposta);
        }
        
        public void descarregaConhecimentoTXT() throws IOException{
            c.armazenaConhecimentoTXT();
        }
        
        
}
