package services;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import formats.ProductModel;
import models.InventoryModel;
import formats.RequestBody;
import formats.ResponseBody;
import org.json.JSONArray;
import org.json.JSONObject;
import utils.ClientServerConnector;
import utils.ConnectToServer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InventoryService {
    RequestBody requestBody;
    int branchId;
    Scanner scanner;
    String json;
    ObjectMapper objectMapper;
    ResponseBody responseBody;
    String correctedData;
    public InventoryService(int branchId) {
        this.branchId = branchId;
        this.requestBody = new RequestBody();
        this.objectMapper = new ObjectMapper();
        this.responseBody = new ResponseBody();
    }
    public List<InventoryModel> getInventory(){
        List<InventoryModel> inventories = new ArrayList<>();
        try {
            requestBody.setRoute("/inventory");
            requestBody.setAction("GET");
            requestBody.setData(branchId);

            json = objectMapper.writeValueAsString(requestBody);
            responseBody = ConnectToServer.connectToServer(requestBody);
            JSONArray jsonArray = new JSONArray(responseBody.getData().toString());
            System.out.println(jsonArray);
            for (int i=0; i<jsonArray.length(); i++) {
                JSONObject json = jsonArray.getJSONObject(i);
                InventoryModel inventoryModel = new InventoryModel();
                inventoryModel.setStatus((String) json.get("status"));
                inventoryModel.setBranchId((Integer) json.get("branchId"));
                inventoryModel.setProductId((Integer) json.get("productId"));
                inventoryModel.setQuantity((Integer) json.get("quantity"));
                inventoryModel.setProductName((String) json.get("productName"));
                inventoryModel.setPricePerBulk((Integer) json.get("pricePerBulk"));
                inventories.add(inventoryModel);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return inventories;
        }
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
    public void createInventory(InventoryModel inventoryModel) throws Exception {
        this.requestBody.setRoute("/inventory");
        this.requestBody.setAction("POST");
        this.requestBody.setData(inventoryModel);
        responseBody = ConnectToServer.connectToServer(requestBody);
    }
}
