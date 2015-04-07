package fil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fil.data.Contrainte;
import fil.repository.ContrainteRepository;

@RestController
@RequestMapping("/contrainte")
public class ContrainteController {

	@Autowired
	private ContrainteRepository contrainteRepository;

	@RequestMapping(value = "/add/{idUser}", method = RequestMethod.POST)
	public Contrainte create(@PathVariable("idUser") final String idUser,
			@RequestParam("motif") final String motif,
			@RequestParam("debut") final int debut,
			@RequestParam("fin") final int fin,
			@RequestParam("importance") final int importance) {
		final Contrainte contrainte = new Contrainte(idUser, motif, importance,
				debut, fin);
		this.contrainteRepository.save(contrainte);
		return contrainte;
	}

	@RequestMapping(value = "/list/{idUser}", method = RequestMethod.GET)
	public List<Contrainte> read(@PathVariable("idUser") final String idUser) {
		return this.contrainteRepository.findByIdUser(idUser);

	}

	@RequestMapping(value = "/update/{idUser}", method = RequestMethod.POST)
	public Contrainte update(@PathVariable("idUser") final String idUser,
			@RequestParam("id") final String id,
			@RequestParam("motif") final String motif,
			@RequestParam("debut") final int debut,
			@RequestParam("fin") final int fin,
			@RequestParam("importance") final String importance) {
		final Contrainte contrainte = new Contrainte(id, idUser, motif, debut,
				fin, Integer.parseInt(importance));
		this.contrainteRepository.save(contrainte);
		return contrainte;
	}

	@RequestMapping(value = "/delete/{idUser}/{idContrainte}", method = RequestMethod.DELETE)
	public void remove(@PathVariable("idUser") final String idUser,
			@PathVariable("idContrainte") final String id) {
		this.contrainteRepository.delete(new Contrainte(id, idUser));
	}

}
