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


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author fabio
 */
public class SimpleClient {

    public static void main(String[] args) {

        SimpleClient sc = new SimpleClient();
       sc.print();
       //   sc.printFluent();
      //    sc.printParameters();
    }

    public void print() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080");

        Invocation.Builder builder;
        builder = target.request("text/html");
        Invocation invocation = builder.buildGet();
        String response = invocation.invoke(String.class);
        System.out.println(response);
        client.close();
    }

    public void printFluent() {
        Client client = ClientBuilder.newClient();
        Response response = client.target("http://localhost:8080")
                .request("text/html").get();
        System.out.println(response.readEntity(String.class));
        System.out.println(response.getStatus());
        client.close();
    }

    public void printParameters() {
        Client client = ClientBuilder.newClient();

        String entity = client.target("http://localhost:8080")
                .path("webresource/aula")
                .queryParam("ufscar-header", "UFSCar")
                .request(MediaType.TEXT_PLAIN_TYPE)
                .header("disciplina", "Compiladores")
                .get(String.class);

        System.out.println(entity);

        client.close();

    }
}
