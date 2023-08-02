package de.woock.domain;

import static de.woock.domain.Status.AUFGENOMMEN;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import de.woock.infra.entity.Kopfdaten;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@SuppressWarnings({ "serial" })
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Configurable(autowire=Autowire.BY_TYPE)
public class Anfrage extends Kopfdaten implements Serializable {
	
	@Autowired @Transient private AnfragenOrdner anfragenOrdner;
	@Autowired @Transient private AnfragenBoard  anfragenBoard;

	private String anfrage;
	private String antwort;
	private Date   von;
	private Status status;
	
	public Anfrage stellen(String anfrage) {
		this.anfrage = anfrage;
		this.von     = new Date();
		this.status  = AUFGENOMMEN;
		return anfragenOrdner.abheften(this);	
	}

	public Anfrage weiterleitenAn(Abteilungen fuhrpark) {
	    anfragenBoard.neueAnfrageAnheften(this, fuhrpark);
	 	return this;
	}

	public void beantworten(String antwort) {
		this.antwort = antwort;
		anfragenOrdner.updaten(this);
	}
	
	public List<Anfrage> liste() {
		return anfragenOrdner.alleAnfragen();
	}
}
