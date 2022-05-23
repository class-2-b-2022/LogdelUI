package services;

import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

import formats.ProductModel;
import formats.RequestBody;
import formats.ResponseBody;
import utils.ConnectToServer;


public class ProductService {

	RequestBody requestBody;
	int branchId;
	Scanner scanner;
	String json;
	ObjectMapper objectMapper;
	ResponseBody responseBody;
	String correctedData;
		   public String createProduct(ProductModel productModel) throws Exception {
		        this.requestBody.setRoute("/inventory/products");
		        this.requestBody.setAction("POST");
		        this.requestBody.setData(productModel);
		        responseBody = ConnectToServer.connectToServer(requestBody);
		        return responseBody.getMessage();
		    
	

}
}

