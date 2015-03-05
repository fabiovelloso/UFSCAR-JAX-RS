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

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author fabio
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(br.ufscar.entities.TestExceptionResource.class);
        resources.add(br.ufscar.ws.rest.BookCacheResource.class);
        resources.add(br.ufscar.ws.rest.BookResource.class);
        resources.add(br.ufscar.ws.rest.DefaultValueResource.class);
        resources.add(br.ufscar.ws.rest.ExceptionResource.class);
        resources.add(br.ufscar.ws.rest.HeaderResource.class);
        resources.add(br.ufscar.ws.rest.HelloJSONXMLResource.class);
        resources.add(br.ufscar.ws.rest.HelloParamResource.class);
        resources.add(br.ufscar.ws.rest.HelloQueryParamResource.class);
        resources.add(br.ufscar.ws.rest.HelloWorldResource.class);
        resources.add(br.ufscar.ws.rest.MatrixResource.class);
        resources.add(br.ufscar.ws.rest.NoticiasResource.class);
        resources.add(br.ufscar.ws.rest.RegexResource.class);
        resources.add(br.ufscar.ws.rest.filters.NamedPoweredByResponseFilter.class);
        resources.add(br.ufscar.ws.rest.filters.PoweredByResponseFilter.class);
        resources.add(br.ufscar.ws.rest.jaxrs2.AsyncGetWithTimeoutResource.class);
        resources.add(br.ufscar.ws.rest.jaxrs2.AsyncResource.class);
        resources.add(br.ufscar.ws.rest.jaxrs2.GenericResource.class);
        resources.add(br.ufscar.ws.rest.jaxrs2.RegexValidationResource.class);
        resources.add(br.ufscar.ws.rest.jaxrs2.TestFiltersResource.class);
        resources.add(br.ufscar.ws.rest.jaxrs2.ValidateResource.class);
    }
    
}
