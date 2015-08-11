package InterceptorChain;

public interface Filter {
	
	public void preFilter(Request req,Response res,FilterChain chain);
	
	public void afterFilter(Request req,Response res,FilterChain chain);
	
}
