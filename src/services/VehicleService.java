package services;

import com.fasterxml.jackson.databind.ObjectMapper;
import formats.RequestBody;
import formats.ResponseBody;
import formats.VehicleModel;
import models.InventoryModel;
import org.json.JSONArray;
import org.json.JSONObject;
import utils.ConnectToServer;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleService {
    RequestBody requestBody;
    Scanner scanner;
    String json;
    ObjectMapper objectMapper;
    ResponseBody responseBody;

    public VehicleService() {
        this.requestBody = new RequestBody();
        this.objectMapper = new ObjectMapper();
        this.responseBody = new ResponseBody();
    }

    public List<VehicleModel> getVehicles(){
        List<VehicleModel> vehicles = new ArrayList<>();
        try {
            requestBody.setRoute("/delivery/vehicles");
            requestBody.setAction("view");

            json = objectMapper.writeValueAsString(requestBody);
            responseBody = ConnectToServer.connectToServer(requestBody);
            JSONArray jsonArray = new JSONArray(responseBody.getData().toString() + "]");
            for (int i=0; i<jsonArray.length(); i++) {
                JSONObject json = jsonArray.getJSONObject(i);
                VehicleModel vehicle = new VehicleModel();
                vehicle.setBrand((String) json.get("brand"));
                vehicle.setVehicleId((Integer) json.get("vehicleId"));
                vehicle.setOwner(json.get("owner").toString());
                vehicle.setDescription(json.get("description").toString());
                vehicle.setPlateNbr(json.get("plateNbr").toString());
                vehicle.setModel(json.get("model").toString());
                vehicles.add(vehicle);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return vehicles;
        }
    }

    public Object[][] getAllVehiclesAsObject(){
        List<VehicleModel> vehicles = getVehicles();
        Object[][] data = new Object[vehicles.size()][];
        for(int i=0;i< vehicles.size();i++){
            VehicleModel vehicle = vehicles.get(i);
            data[i] = new Object[vehicles.size()];
            data[i] = new String[]{String.valueOf(vehicle.getVehicleId()), vehicle.getModel(), vehicle.getPlateNbr(), vehicle.getBrand(), vehicle.getDescription()};
        }
        return data;
    }
}
