/**
 * Copyright 2015 Fabio Velloso
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package br.ufscar.ws.rest;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;

/**
 * REST Web Service
 *
 * @author fabio
 */
@Path("test")
public class ExceptionResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ExceptionResource
     */
    public ExceptionResource() {
    }

    /**
     * Retrieves representation of an instance of
     * br.ufscar.ws.rest.ExceptionResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/xml")
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    @GET
    @Path("/event/{id}")
    public String getEvent(@PathParam("id") int id) {
        switch (id) {
            case 1:
                return "FISL";
            case 2:
                throw new WebApplicationException(401);
            case 3:
                throw new WebApplicationException("dsdsdsd",
                        new java.lang.Throwable("*** Mensagem Throwable"), 500);
            default:
                return "Software Livre";
        }
    }

}
