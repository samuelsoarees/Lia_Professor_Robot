package lia.models.entidades;


// entidade resposta para armazenar objetos respostas
public class Resposta {

	private int idResp;
	private String descricao;
	
	public Resposta(int idResp,String descricao){
		this.idResp=idResp;
		this.descricao=descricao;
		
		
	}

	public int getIdResp() {
		return idResp;
	}

	public void setIdResp(int idResp) {
		this.idResp = idResp;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
	
	
}
