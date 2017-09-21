package model;

public class Usuario {
	
	 private int idUsuario;
	    private int rg;
	    private String nome;
	    private String sobrenome;
	    private String senha;
		public int getIdUsuario() {
			return idUsuario;
		}
		public void setIdUsuario(int idUsuario) {
			this.idUsuario = idUsuario;
		}
		public int getRg() {
			return rg;
		}
		public void setRg(int rg) {
			this.rg = rg;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getSobrenome() {
			return sobrenome;
		}
		public void setSobrenome(String sobrenome) {
			this.sobrenome = sobrenome;
		}
		public String getSenha() {
			return senha;
		}
		public void setSenha(String senha) {
			this.senha = senha;
		}

}
