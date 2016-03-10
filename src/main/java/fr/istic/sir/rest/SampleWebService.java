package fr.istic.sir.rest;

import java.util.Collection;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import domain.*;
import services.*;

@Path("/hello")
public class SampleWebService {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello, how are you?";
    }
    
    @GET
    @Path("/home")
    @Produces(MediaType.APPLICATION_JSON)
    public Home getHome() {
        Home h = new Home(12, 12);
        
        return h;
    }
    
    @GET
    @Path("/persons")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Person> getPersons() {
        PersonService persService = new PersonServiceImpl();
        return persService.getPerson();
    }
    
    @POST
    @Path("/persons")
    @Produces(MediaType.APPLICATION_JSON)
    public void postPersons(Person p) {
        PersonService persService = new PersonServiceImpl();
        persService.addPerson(p.getFirstName(), p.getLastName(), p.getMail());
    }
    
    @DELETE
    @Path("/persons/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deletePerson(@PathParam("id") int id){
    	
    	PersonService persService = new PersonServiceImpl();
    	persService.deleteById(id);
    	
    }

}