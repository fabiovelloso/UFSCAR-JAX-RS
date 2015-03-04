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
package br.ufscar.ws.rest.jaxrs2;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author fabio
 */
@Path("async")
public class AsyncResource {

    @GET
    @Produces(value = {MediaType.APPLICATION_XML})
    public void asyncGet(@Suspended final AsyncResponse asyncResponse) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                String result = veryExpensiveOperation();
                asyncResponse.resume(result);
            }

            private String veryExpensiveOperation() {

                try {
                    //  Thread.currentThread().sleep(5000);
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(AsyncResource.class.getName()).log(Level.SEVERE, null, ex);
                }

                return "<message>Processamento assincrono finalizado</message>";
            }
        }).start();

    }
}

/*
 *  try {
                    Thread.currentThread().sleep(10000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(AsyncResource.class.getName()).log(Level.SEVERE, null, ex);
                }
 */
