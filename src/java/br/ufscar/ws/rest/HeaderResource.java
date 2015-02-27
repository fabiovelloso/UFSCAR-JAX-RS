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

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;


/**
 * REST Web Service
 *
 * @author fabio
 */
@Path("header")
public class HeaderResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HeaderResource
     */
    public HeaderResource() {
    }

    /**
     * Retrieves representation of an instance of br.ufscar.ws.rest.HeaderResource
     * @param userAgent
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(value = {MediaType.TEXT_PLAIN})
    public String getUserAgent(@HeaderParam("User-Agent") String userAgent) {
        return userAgent;
    }

    
}
