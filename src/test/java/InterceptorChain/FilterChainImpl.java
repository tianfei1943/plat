package InterceptorChain;

import java.util.ArrayList;
import java.util.List;

public class FilterChainImpl implements FilterChain {

	private List<Filter> list = new ArrayList<Filter>();
	
	private int index = 0;
	
	public void addFilter(Filter filter){
		list.add(filter);
	}
	
	@Override
	public void doFilter(Request req, Response res) {
		if(list.size() == 0 || list.size() == index){
			return;
		}
		Filter filter = list.get(index);
		index++;
		filter.preFilter(req, res, this);
		filter.afterFilter(req, res, this);
	}

}
