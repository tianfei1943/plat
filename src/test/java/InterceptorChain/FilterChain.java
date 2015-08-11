package InterceptorChain;

public interface FilterChain {
	
	public void doFilter(Request req,Response res);
	
	public void addFilter(Filter filter);
	
}
