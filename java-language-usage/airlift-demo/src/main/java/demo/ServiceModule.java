package demo;

import com.google.inject.Binder;
import com.google.inject.Module;

import static io.airlift.jaxrs.JaxrsBinder.jaxrsBinder;

public class ServiceModule
		implements Module
{
	@Override
	public void configure(Binder binder)
	{
		jaxrsBinder(binder).bind(ServiceResource.class);
	}
}
