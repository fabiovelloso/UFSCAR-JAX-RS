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

import br.ufscar.entities.Book;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author fabio
 */
@Path("bookcache")
public class BookCacheResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of BookCacheResource
     */
    public BookCacheResource() {
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getBook(@PathParam("id") int id) {
        Book book = new Book().getById(1);
        CacheControl cacheControl = new CacheControl();
        cacheControl.setMaxAge(600);
        cacheControl.setPrivate(true);
        cacheControl.setNoStore(true);
        Response.ResponseBuilder builder = Response.ok(book);
        builder.cacheControl(cacheControl);
        return builder.build();
    }

    @Produces(value = {MediaType.APPLICATION_ATOM_XML, MediaType.APPLICATION_JSON})
    @GET
    public List<Book> getAllBooks() {
        return null;
    }

}
