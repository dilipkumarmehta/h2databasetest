package com.srs;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.srs.JdbcRepo;

@RestController
@RequestMapping(value = "/rest/aliens")
public class AlienResource {
	@Autowired
	AlienRepository repo;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Alien>> getAliens() {
		List<Alien> aliens = repo.findAll();
		return new ResponseEntity<List<Alien>>(aliens, HttpStatus.OK);
	}
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<Alien> saveAlien(@RequestBody Alien alien) {
		repo.save(alien);
		return new ResponseEntity<Alien>(alien, HttpStatus.OK);
	}

	/*@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public Alien getAlien(@PathVariable("id") int id) {
		return repo.getAlien(id);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<Alien> saveAlien(@RequestBody Alien alien) {
		repo.create(alien);
		return new ResponseEntity<Alien>(alien, HttpStatus.OK);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Alien updateAlien(@RequestBody Alien a) {
		repo.update(a);
		return a;

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public Alien deleteAlien(@PathVariable("id") int id) {
		Alien a = repo.getAlien(id);
		if (a.getId() != 0) {
			repo.delete(id);
		}
		return a;
	}*/

	/*
	 * @GET
	 * 
	 * @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML}) public
	 * List<Alien> getAliens(){ return repo.getAliens(); }
	 * 
	 * @POST
	 * 
	 * @Path("alien")
	 * 
	 * @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML}) public
	 * Alien ceateAlien(Alien a){ repo.create(a); return a; }
	 * 
	 * @PUT
	 * 
	 * @Path("alien")
	 * 
	 * @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML}) public
	 * Alien updateAlien(Alien a){ repo.update(a); return a; }
	 * 
	 * @GET
	 * 
	 * @Path("alien/{id}")
	 * 
	 * @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML}) public
	 * Alien getAlien(@PathParam("id") int id){ return repo.getAlien(id); }
	 * 
	 * @DELETE
	 * 
	 * @Path("alien/{id}")
	 * 
	 * @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML}) public
	 * Alien deleteAlien(@PathParam("id") int id){ Alien a=repo.getAlien(id);
	 * if(a.getId()!=0){ repo.delete(id); } return a; }
	 */
}
