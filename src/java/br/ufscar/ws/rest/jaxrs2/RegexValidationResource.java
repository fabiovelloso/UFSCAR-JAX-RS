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
package br.ufscar.ws.rest.jaxrs2;

import br.ufscar.entities.Book;
import javax.validation.constraints.Pattern;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author fabio
 */
@Path("/regexvalidation")
public class RegexValidationResource {

    /**
     * Creates a new instance of RegexValidationResource
     */
    public RegexValidationResource() {
    }

    /**
     * Retrieves representation of an instance of br.ufscar.ws.rest.jaxrs2.RegexValidationResource
     * @param id
     * @return 
     */
    @GET
    @Path("{id}")
    public Book getBookById(@PathParam("id")
    @Pattern(regexp = "[0-9]+", message = "The bookid must be a valid number")
        String id)   {
        //return book.get(id);   
       return new Book(2, "Design Patterns: Elements of Reusable Object-Oriented Software", "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides", "0-201-63361-2", "978-0-201-63361-0");     
    } 
    
    @Produces(value = {MediaType.TEXT_XML})
    @GET
    public String getAllBooks() {
        return null;
    }

}
