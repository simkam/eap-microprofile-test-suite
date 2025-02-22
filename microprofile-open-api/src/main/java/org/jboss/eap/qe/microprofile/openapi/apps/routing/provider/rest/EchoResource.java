package org.jboss.eap.qe.microprofile.openapi.apps.routing.provider.rest;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.servers.Server;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * Rest resource exposing echo operation
 */
@Path("/echo")
public class EchoResource {

    /**
     * Echoes the received message string
     *
     * @return Simple string containing the received message
     */
    @GET
    @Server(description = "Central Service Provider server", url = "http://127.0.0.1:8080/serviceProviderDeployment")
    @Produces(MediaType.TEXT_PLAIN)
    @APIResponses(value = {
            @APIResponse(responseCode = "404", description = "the Service provider echo endpoint was not found"),
            @APIResponse(responseCode = "200", description = "An echo response containing the message sent through the request", content = @Content(mediaType = MediaType.TEXT_PLAIN, schema = @Schema(implementation = String.class)))
    })
    @Operation(summary = "Get echo response from central Service Provider", description = "Service Provider app is called to get an echo response", operationId = "getEchoFromServiceProvider")
    public Response getEchoFromServiceProvider(@QueryParam("message") String message) {
        return Response.ok().entity(message)
                .build();
    }
}
