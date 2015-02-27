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
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author fabio
 */
@Path("querycount")
public class HelloQueryParamResource {
    
    @GET
    @Produces(value = {MediaType.TEXT_PLAIN})
    public String getProducts(@QueryParam("num") int countUntil) {
        StringBuilder result = new StringBuilder("");
        for (int i = 1; i <= countUntil; i++) {
            result.append(i).append(" ");
        }
        return result.toString();
    }


    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HelloQueryParamResource
     */
    public HelloQueryParamResource() {
    }


    
    // result.deleteCharAt(result.length()-1);
}



