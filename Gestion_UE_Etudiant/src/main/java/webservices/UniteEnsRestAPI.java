package webservices;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;


import entities.UniteEnseignement;
import metiers.UniteEnseignementBusiness;

import javax.ws.rs.*;

@Path("/ue")
public class UniteEnsRestAPI {
    static UniteEnseignementBusiness helper =
            new UniteEnseignementBusiness();

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //getListUES
    public Response getListUe() {
        return Response.status(200)
                .entity(helper.getListeUE())
                .build();

    }

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response addUniteEnseignement(UniteEnseignement ue) {
        if (helper.addUniteEnseignement(ue)) {
            return Response.status(201).entity("succes").build();
        } else {
            return Response.status(400).entity("erreur").build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{code}")
    public Response getUEByCode(@PathParam(("code")) int code) {
        return Response.status(200)
                .entity(helper.getUEByCode(code))
                .build();


    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response getUEBySemestre(@QueryParam(("semestre")) int semestre) {
        return Response.status(200)
                .entity(helper.getUEBySemestre(semestre))
                .build();

    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response updateUniteEnseignement(@QueryParam("code") int code, UniteEnseignement updatedUE) {
        return Response.status(200)
                .entity(helper.updateUniteEnseignement(code, updatedUE))
                .build();

    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response deleteUniteEnseignement(@QueryParam("code") int code) {
        return Response.status(200)
                .entity(helper.deleteUniteEnseignement(code))
                .build();
    }
}


