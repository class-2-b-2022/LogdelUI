//package services;
//
//import java.util.Scanner;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import formats.ProductModel;
//import formats.RequestBody;
//import formats.ResponseBody;
//import utils.ConnectToServer;
//
//
//public class ProductService {
//
//	RequestBody requestBody;
//	int branchId;
//	Scanner scanner;
//	String json;
//	ObjectMapper objectMapper;
//	ResponseBody responseBody;
//	String correctedData;
//	 public ProductService(int branchId) {
//	        this.branchId = branchId;
//	        this.requestBody = new RequestBody();
//	        this.objectMapper = new ObjectMapper();
//	        this.responseBody = new ResponseBody();
//	    }
//		   public String createProduct(ProductModel productModel) throws Exception {
//		        this.requestBody.setRoute("/products");
//		        this.requestBody.setAction("POST");
//		        this.requestBody.setData(productModel);
//		        responseBody = ConnectToServer.connectToServer(requestBody);
//		        return responseBody.getMessage();
//		    
//	
//
//}
//}
//
package services;


import com.fasterxml.jackson.databind.ObjectMapper;
import formats.ProductModel;

import formats.RequestBody;
import formats.ResponseBody;

import utils.ConnectToServer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class ProductService {
    RequestBody requestBody;
    int branchId;
    Scanner scanner;
    String json;
    ObjectMapper objectMapper;
    ResponseBody responseBody;
    String correctedData;
    public ProductService(int branchId) {
        this.branchId = branchId;
        this.requestBody = new RequestBody();
        this.objectMapper = new ObjectMapper();
        this.responseBody = new ResponseBody();
    }

    public List<ProductModel> getProducts() throws Exception {
        List<ProductModel> products = new ArrayList<>();
        try{
            requestBody.setRoute("/products");
            requestBody.setAction("GET");
            requestBody.setData(branchId);
            json = objectMapper.writeValueAsString(requestBody);
            responseBody = ConnectToServer.connectToServer(requestBody);
            JSONArray jsonArray = new JSONArray(responseBody.getData().toString());
            for (int i=0; i<jsonArray.length(); i++) {
                JSONObject json = jsonArray.getJSONObject(i);
                ProductModel productModel = new ProductModel();
                productModel.setProductType((String) json.get("productType"));
                productModel.setProductName((String) json.get("productName"));
                productModel.setProductId((int) json.get("productId"));
                productModel.setPricePerBulk((int) json.get("pricePerBulk"));
                products.add(productModel);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return products;
        }
    }
    public String createProduct(ProductModel productModel) throws Exception {
        this.requestBody.setRoute("/products");
        this.requestBody.setAction("POST");
        this.requestBody.setData(productModel);
        responseBody = ConnectToServer.connectToServer(requestBody);
        return responseBody.getMessage();
    }
}

