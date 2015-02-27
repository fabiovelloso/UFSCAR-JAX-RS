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
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 *
 * @author fabio
 */
@Path("/book")
public class BookResource {

    Book book;
    List allBooks;

    @Produces(value = {MediaType.APPLICATION_ATOM_XML, MediaType.APPLICATION_JSON})
    @GET
    public List<Book> getAllBooks() {    
        return allBooks;
    }

    @GET
    @Path("/{id}")
    @Produces(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getBook(@PathParam("id") int id) throws ClassNotFoundException {

        book = book.get(id);
        if (book == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return Response.status(200).entity(book).build();
    }

    @Consumes(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @POST
    public Response addBook(Book book) {
        return null;
    }

    @Consumes(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @PUT
    public Response updateBook(Book book, @HeaderParam("Content-Type") String contentType) {
   
        System.out.println("***** +>" + contentType);
        if (contentType.equals("application/json")) {
            return Response.status(200).entity(book).type(MediaType.APPLICATION_JSON).build();
        } else  {
            return Response.status(200).entity(book).type(MediaType.APPLICATION_XML).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteBook(@PathParam("id") String id) {
        allBooks.remove(id);
        return null;
    }

    public BookResource() {
        book = new br.ufscar.entities.Book();
        allBooks = new ArrayList();
        allBooks.add(book.get(1)); 
        allBooks.add(book.get(2));
    }

    public void printBook(Book book) {
        System.out.println("***** ISBN " + book.getISBN());
        System.out.println("ISBN13 " + book.getISBN13());
    }

}
