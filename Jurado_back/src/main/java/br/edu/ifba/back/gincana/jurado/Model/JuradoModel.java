package br.edu.ifba.back.gincana.jurado.Model;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import br.edu.ifba.backgincana.model.Notas_Criterio;
	import br.edu.ifba.backgincana.model.Jurado_has_prova;
	import javax.persistence.Table;
	import javax.persistence.ManyToOne;
	import javax.persistence.JoinColumn;

	import lombok.Data;

	@Data
	@Entity
	@Table (name = "Jurado")

	public class JuradoModel {

		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		
		
		@Column (name = "idJurado")
		private long idJurado;  
		
		@Column (name = "nomeJurado", nullable = false, unique = true)
		private  String nomeJurado;

		@ManyToOne
		@JoinColumn(nullable = false)
		private Jurado_has_Prova jurado_has_Prova;
		
		@ManyToOne
		@JoinColumn(nullable = false)
		private Notas_Criterio notas_criterio;

		public JuradoModel(long idJurado, String nomeJurado, Jurado_has_Prova jurado_has_Prova, Notas_Criterio notas_criterio) {
			super();
			this.idJurado = idJurado;
			this.nomeJurado = nomeJurado;
			this.jurado_has_Prova = jurado_has_Prova;
			this.notas_criterio = notas_criterio;
		}

		public long getIdJurado() {
			return idJurado;
		}

		public void setIdJurado(long idJurado) {
			this.idJurado = idJurado;
		}

		public String getNomeJurado() {
			return nomeJurado;
		}

		public void setNomeJurado(String nomeJurado) {
			this.nomeJurado = nomeJurado;
		}

		public Jurado_has_Prova getJurado_has_Prova() {
			return jurado_has_Prova;
		}

		public void setJurado_has_Prova(Jurado_has_Prova jurado_has_Prova) {
			this.jurado_has_Prova = jurado_has_Prova;
		}

		public Notas_Criterio getNotas_criterio() {
			return notas_criterio;
		}

		public void setNotas_criterio(Notas_Criterio notas_criterio) {
			this.notas_criterio = notas_criterio;
		}
		
		
			}

