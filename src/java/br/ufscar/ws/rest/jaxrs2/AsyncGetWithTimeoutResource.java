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

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.container.TimeoutHandler;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author fabio
 */
@Path("asyncGetWithTimeout")
public class AsyncGetWithTimeoutResource {

    @GET
    @Produces(value = {MediaType.APPLICATION_XML})
    public void asyncGetWithTimeout(@Suspended
            final AsyncResponse asyncResponse) {
        asyncResponse.setTimeoutHandler(new TimeoutHandler() {
            @Override
            public void handleTimeout(AsyncResponse asyncResponse) {
                asyncResponse
                        .resume(Response.status(Response.Status.SERVICE_UNAVAILABLE)
                                .entity("<xml>Operation time out.</xml>").build());
            }
        });
        asyncResponse.setTimeout(5, TimeUnit.SECONDS);

        new Thread(new Runnable() {
            @Override
            public void run() {
                String result = veryExpensiveOperation();
                asyncResponse.resume(result);
            }

            private String veryExpensiveOperation() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(AsyncResource.class.getName()).log(Level.SEVERE, null, ex);
                }
                return "<xml>Processamento assincrono finalizado</xml>";
            }
        }).start();
    }
}
