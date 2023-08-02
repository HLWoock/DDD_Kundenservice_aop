package de.woock.infra.message;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;

@SuppressWarnings("serial")
@AllArgsConstructor
public class Zettel implements Serializable{
	
	private Long   id;
	private String anfrage;
	private String antwort;
	private Date   von;


}
