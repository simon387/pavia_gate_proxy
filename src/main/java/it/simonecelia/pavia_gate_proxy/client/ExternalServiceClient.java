package it.simonecelia.pavia_gate_proxy.client;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;


@RegisterRestClient ( configKey = "arduino-gate" )
public interface ExternalServiceClient {

	@GET
	@Path ( "/trigger" )
	String callTrigger ();

	@GET
	@Path ( "/info" )
	@Produces ( MediaType.TEXT_HTML )
	String getInfo ();
}
