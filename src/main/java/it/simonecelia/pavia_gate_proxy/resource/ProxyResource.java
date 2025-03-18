package it.simonecelia.pavia_gate_proxy.resource;

import io.quarkus.logging.Log;
import it.simonecelia.pavia_gate_proxy.client.ExternalServiceClient;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;


@Path ( "/proxy" )
public class ProxyResource {

	@Inject
	@RestClient
	ExternalServiceClient externalService;

	@GET
	@Produces ( MediaType.APPLICATION_JSON )
	public String proxyRequest ( @QueryParam ( "ip" ) String callerIp ) {
		Log.infof ( "Ricevuta chiamata da IP: %s", callerIp );
		return externalService.callTrigger ();
	}

	@GET
	@Path ( "/info" )
	@Produces ( MediaType.TEXT_HTML )
	public String getInfo ( @QueryParam ( "ip" ) String callerIp ) {
		Log.infof ( "Ricevuta chiamata /info da IP: %s", callerIp );
		return externalService.getInfo ();
	}
}