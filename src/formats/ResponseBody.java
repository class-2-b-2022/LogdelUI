package formats;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ResponseBody implements Serializable {
	 private String message;//created
	    private String status;//201
	    private Object data;
	    public ResponseBody(){}
	    public ResponseBody(String message, String status, String data){
	        this.status = status;
	        this.message = message;
	        this.data = data;
	    }
	    public String getMessage() {
	        return message;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public Object getData() {
	        return data;
	    }



	    public void setMessage(String message) {
	        this.message = message;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }

	    public void setData(Object data) {
	        this.data = data;
	    }


}
