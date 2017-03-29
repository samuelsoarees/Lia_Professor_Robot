package lia.models.entidades;


// entidade pergunta para adicionar perguntas
public class Pergunta {

	private int idPer;
	private String descricao;

	public Pergunta(int idPer, String descricao) {
		this.idPer=idPer;
		this.descricao=descricao;

	}

	public int getIdPer() {
		return idPer;
	}

	public void setIdPer(int idPer) {
		this.idPer = idPer;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
