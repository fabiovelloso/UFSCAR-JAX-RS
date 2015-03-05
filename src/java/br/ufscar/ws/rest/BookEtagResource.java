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

import br.ufscar.entities.Book;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author fabio
 */
@Path("booketag")
public class BookEtagResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of BookEtagResource
     */
    public BookEtagResource() {
    }



    @GET
    @Path("{id}")
    @Produces(value = {MediaType.APPLICATION_ATOM_XML, MediaType.APPLICATION_JSON})
    public Response getBookById(@PathParam("id") Integer id, @Context Request request) {
        Book book = new Book().getById(id);
        EntityTag etag = new EntityTag(hash(book.getName() + book.getISBN()));
        CacheControl cacheControl = new CacheControl();
        cacheControl.setPrivate(true);
        cacheControl.setNoStore(true);
        cacheControl.setMaxAge(60);
        Response.ResponseBuilder builder = request.evaluatePreconditions(etag);
        if (builder != null) {
            builder.cacheControl(cacheControl);
        } else {
            builder = Response.ok(book);
            builder.cacheControl(cacheControl);
            builder.tag(etag);
        }
        return builder.build();
    }

    @GET
    @Produces(value = {MediaType.APPLICATION_ATOM_XML, MediaType.APPLICATION_JSON})
    public List<Book> getAllBooks() {
        return null;
    }

    public String hash(String param) {
        MessageDigest messageDigest;
        BigInteger hash = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            hash = new BigInteger(1, messageDigest.digest(param.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hash.toString(16);
    }
}
