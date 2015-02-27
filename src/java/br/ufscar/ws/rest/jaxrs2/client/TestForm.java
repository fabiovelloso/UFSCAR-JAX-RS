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
package br.ufscar.ws.rest.jaxrs2.client;

import br.ufscar.entities.Book;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.client.Entity;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author fabio
 */
public class TestForm {

    public static void main(String[] args) {
        TestForm testForm = new TestForm();
        testForm.call();
    }

    private void call() {    
     Client client = ClientBuilder.newClient();
     WebTarget target = client.target("http://localhost:8080/ufscar/form.html");
     Form form = new Form();
     form.param("bookName", "Java the Good Parts");
     Book bean = target.request(MediaType.APPLICATION_JSON_TYPE)
         .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE),
         Book.class);
        client.close();
      
    }
}