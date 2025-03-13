package it.simonecelia.pavia_gate_proxy.client;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;


@RegisterRestClient ( configKey = "arduino-gate" )
public interface ExternalServiceClient {

	@GET
	@Path ( "/trigger" )
	String getResource ();
}
