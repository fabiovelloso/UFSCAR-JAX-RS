/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.ws.rest.jaxrs2;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author fabio
 */
@Path("generic")
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of br.ufscar.ws.rest.jaxrs2.GenericResource
     * @return an instance of java.lang.String
     */
    /*
    @GET
    @Produces("application/xml")
    public String getXml() {
        throw new UnsupportedOperationException();
    }
    */

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
   
    
    @DELETE
    @Consumes("application/xml")
    @Produces("application/xml")
    public Response deleteXml() {
        System.out.println("**** DELETE");
        return Response.noContent().build();
    }
}
