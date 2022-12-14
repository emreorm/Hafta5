package Kodlama.io.Kodlama.io.Devs.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Table(name="technologies")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Technology {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")		
	private int id;
	@Column(name="TechnologyName")
	private String name;
	
	@ManyToOne
	@JoinColumn(name= "languageId", referencedColumnName = "id")
	private Language language;

}
