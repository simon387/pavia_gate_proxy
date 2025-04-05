package it.simonecelia.pavia_gate_proxy.interceptor;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;


@Provider
public class CustomResponseExceptionMapper implements ResponseExceptionMapper<RuntimeException> {

	@Override
	public RuntimeException toThrowable ( Response response ) {
		if ( response.getStatus () == 500 ) {
			return new RuntimeException ( "Connection reset by peer" );
		}
		return null;
	}
}