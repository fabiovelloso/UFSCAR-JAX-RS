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
package br.ufscar.ws.rest;

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

@Path("/regex")
public class RegexResource {

    @GET
    @Path("{id: [0-9]}")
    @Produces(value = {MediaType.TEXT_PLAIN})
    public String getEventById(@PathParam("id") int id) {
        switch (id) {
            case 1:
                return "Campus Party 2015";
            case 2:
                return "FISL 16";
            case 3:
                return "JavaOne Latin America 2015";
            default:
                return "14 E dia de Java";
        }
    }
    
    
    /**
     * Creates a new instance of RegexResource
     */
    public RegexResource() {
    }

    /**
     * Retrieves representation of an instance of
     * br.ufscar.ws.rest.RegexResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/xml")
    public String getXml() {
        //TODO return proper representation object
        return "<a>ccsd</a>";
    }
}
