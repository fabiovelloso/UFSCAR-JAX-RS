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
package br.ufscar.ws.rest.jaxrs2.client;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.client.AsyncInvoker;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 *
 * @author fabio
 */
public class AsyncTimeoutClient {
    
     public static void main(String[] args) {


        AsyncTimeoutClient client = new AsyncTimeoutClient();
         try {
             client.execute();
         } catch ( InterruptedException | ExecutionException ex) {
             Logger.getLogger(AsyncTimeoutClient.class.getName()).log(Level.SEVERE, null, ex);
         }

    }
      private void execute() throws InterruptedException, ExecutionException {

        Client client = ClientBuilder.newClient();
        WebTarget target = client
                .target("http://localhost:8080/UFSCar-JAX-RS/webresources/asyncGetWithTimeout");
        final AsyncInvoker asyncInvoker = target.request().async();
        final Future<Response> responseFuture = asyncInvoker.get();
        System.out.println("Request assincrono.");
        try {
            final Response response = responseFuture.get();
            System.out.println(response.readEntity(String.class));
           
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(AsyncClient.class.getName())
                    .log(Level.SEVERE, null, ex);
        }

    }
    
}
