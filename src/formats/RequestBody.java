package formats;

public class RequestBody {
	 private String route;///users
	    private String action;//regist
	    private Object data;
	    public RequestBody(){}
	    public RequestBody(String route, String action, Object data){
	        this.route = route;
	        this.action = action;
	        this.data = data;
	    }
	    public String getRoute() {
	        return route;
	    }

	    public void setRoute(String route) {
	        this.route = route;
	    }

	    public String getAction() {
	        return action;
	    }

	    public void setAction(String action) {
	        this.action = action;
	    }

	    public Object getData() {
	        return data;
	    }

	    public void setData(Object data) {
	        this.data = data;
	    }
}
