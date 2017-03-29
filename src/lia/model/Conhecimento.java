package lia.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import lia.models.entidades.Pergunta;
import lia.models.entidades.Resposta;

public class Conhecimento {

    String[] separa = new String[2];

    List<Pergunta> p = new ArrayList();
    List<Resposta> r = new ArrayList();

  private static List<Pergunta> novasPerguntas = new ArrayList();
  private static List<Resposta> newRespostasParaConhecimento= new ArrayList();
  private static List<Pergunta> newPerguntasParaConhecimento = new ArrayList();
    
   private static Pergunta perguntaNova;
   private static Resposta respostaNova;

    // carregando array
    public void carregaArray() {

        String linhas;
        String pergunta, resposta;

        int n = 0;

        try {
            // Variaveis para ler arquivo
            FileReader arq = new FileReader("D:\\conhecimento.txt");
            BufferedReader lerArq = new BufferedReader(arq);

            // ler arquivo txt e adiciona no array linha
            while (lerArq.readLine() != null) {

                linhas = lerArq.readLine();

                separa = linhas.split("#");
                


                pergunta = separa[0].toString();
                resposta = separa[1].toString();

                Pergunta perg = new Pergunta(n, pergunta);
                Resposta resp = new Resposta(n, resposta);

                p.add(perg);
                r.add(resp);

                n++;

                separa[0] = "";
                separa[1] = "";

            }

            arq.close();

        } catch (IOException e) {
            System.err.printf("Erro de abertura de arquivo:%s.n", e.getMessage());
        }

    }

    // procurar respostas no array que foi carregado pelo txt no metodo acima
    public String procuraResposta(String pergunta) throws IOException {
        String msg ="NÃO SEI RESPONDER ESSA PERGUNTA AGORA, VOCÊ SABE?\nSE SOUBER ME DIZ A RESPOSTA, SE NÃO DIGA \"NÃO SEI\"";
        int n=0;
        boolean found = false;
        for (int i = 0; i < p.size(); i++) {

            if (p.get(i).getDescricao().equals(pergunta)) {
                found = true;
                return r.get(i).getDescricao();
            }

        }
        if (!found) {
            perguntaNova =new Pergunta(n, pergunta);
            novasPerguntas.add(perguntaNova);
            
            return msg;
        }

        return null;
    }

    // quando sair do programa, é chamado esse metodo para guardar todo array no txt para responder depois
    public void armazenaNovasPerguntasTXT() throws IOException {

        try (FileWriter arq = new FileWriter("D:\\novasPerguntas.txt")) {
            PrintWriter gravarArq = new PrintWriter(arq);
            
            
            for (int i = 0; i < novasPerguntas.size(); i++) {
                
                gravarArq.printf(novasPerguntas.get(i).getDescricao() + "# %n");
                arq.flush();
                
            }
        }

    }

  
   public void armazenaConhecimentoTXT() throws IOException{
        try (FileWriter arq = new FileWriter("D:\\novoConhecimento.txt")) {
            PrintWriter gravarArq = new PrintWriter(arq);
            
            
            for (int i = 0; i < newPerguntasParaConhecimento.size(); i++) {
                
                gravarArq.printf(newPerguntasParaConhecimento.get(i).getDescricao() + "#"+newRespostasParaConhecimento.get(i).getDescricao()+" %njump%n");
                arq.flush();
                
            }
        }
   }
   
   public String armazenaRespostaArray(String resposta){
       String msg = "GUARDEI SUA RESPOSTA, OBRIGADO POR ME AJUDAR";
       respostaNova= new Resposta(0, resposta);
       newPerguntasParaConhecimento.add(novasPerguntas.get(novasPerguntas.size()-1));
       newRespostasParaConhecimento.add(respostaNova);
       p.add(novasPerguntas.get(novasPerguntas.size()-1));
       r.add(respostaNova);
      
       return msg;
   }
  
   
  
}
