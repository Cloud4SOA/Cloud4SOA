package eu.cloud4soa.adapter.rest.request;

import java.io.Serializable;

import eu.cloud4soa.adapter.rest.aop.Method;
import eu.cloud4soa.adapter.rest.aop.Method.HttpMethod;
import eu.cloud4soa.adapter.rest.aop.Path;
import eu.cloud4soa.adapter.rest.aop.Path.Component;
import eu.cloud4soa.adapter.rest.response.ExtendedMonitorResponse;

/**
 * Request for resource <strong>Monitor</strong> 
 * <br><code>htt[p|ps]://baseUrl/monitor/extend</code>.<br>
 * 
 * Response will contain details of that requested resource(where applicable).
 * 
 * @author Denis Neuling (dn@cloudcontrol.de)
 */
@Method(HttpMethod.GET)
@Path(component=Component.MONITOR, path="/extend")
public class ExtendedMonitorRequest extends Request<ExtendedMonitorResponse> implements Serializable{
	private static final long serialVersionUID = 2378456309862621042L;

	public ExtendedMonitorRequest(){
	}
}
