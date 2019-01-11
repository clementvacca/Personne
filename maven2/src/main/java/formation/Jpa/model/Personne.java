package formation.Jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "person")
@SequenceGenerator(name="seqPersonne", sequenceName="seq_person", allocationSize=1,initialValue=100)
public class Personne {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqPersonne")
	private Integer id;
	@Column(name = "first", length = 150, nullable = true)
	private String prenom;
	@Column(name="last", length=150, nullable =true)
	private String nom;

	public Personne() {

	}
	public Personne(String prenom, String nom) {
		this.prenom=prenom;
		this.nom=nom;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personne other = (Personne) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
