package de.woock.infra.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.woock.domain.Anfrage;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class AnfragenRESTController {
	
	@GetMapping("/anfragen")
	public List<Anfrage> alleAnfragen() {
		return new Anfrage().liste();
	}
}
