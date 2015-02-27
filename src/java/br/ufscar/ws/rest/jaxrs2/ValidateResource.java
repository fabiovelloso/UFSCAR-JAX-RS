/**
 * Copyright 2015 Fabio Velloso 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.ufscar.ws.rest.jaxrs2;

import br.ufscar.validators.CPF;
import javax.validation.constraints.NotNull;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import org.agoncal.book.javaee7.chapter03.ex05.Email;

/**
 * REST Web Service
 *
 * @author fabio
 */
@Path("validate")
public class ValidateResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ValidateResource
     */
    public ValidateResource() {
    }

    /**
     * Retrieves representation of an instance of br.ufscar.ws.rest.jaxrs2.ValidateResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/xml")
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of ValidateResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
    }
    
     /**
     *
     * @param firstName
     * @param lastName
     * @param email
     * @param cpf
     */
    @POST
    @Consumes("application/x-www-form-urlencoded")
    public void validateUser(
            @NotNull @FormParam("firstName") String firstName,
            @NotNull @FormParam("lastName") String lastName,
            @NotNull @Email @FormParam("email") String email,
            @CPF @FormParam("cpf") String cpf) {

        System.out.println("Nome= " + firstName + " " + lastName + "\nemail= " + email+ "\ncpf= " + cpf);
    }
}
