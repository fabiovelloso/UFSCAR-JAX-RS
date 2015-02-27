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

import java.net.URI;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
/**
 *
 * @author fabio
 */
public class UriBuilderClient {
    
    URI uri;
    static Response response;

    public static void main(String[] args) {
        UriBuilderClient uriBuilderClient = new UriBuilderClient();
        response = uriBuilderClient.callUri(); 
        System.out.println(response);
    }

    public Response callUri() {
        Client client = ClientBuilder.newClient();
        uri = this.buildUri();
        System.out.println("*** Uri: "+uri);  
        return client.target(uri).request("text/html").get();           
    }
    
    public URI buildUri() {
   
         return UriBuilder.fromUri("http://{host}/{ano}?trilha={trilha}")
         .resolveTemplate("host", "www.javaone.com.br")
         .resolveTemplate("ano", "2015")
         .resolveTemplate("trilha", "Java EE").build(); 
        
    }
}
