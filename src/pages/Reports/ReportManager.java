package pages.Reports;

import com.fasterxml.jackson.databind.ObjectMapper;
import components.InventoryReport;
import formats.RequestBody;
import formats.ResponseBody;
import utils.ConnectToServer;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

public class ReportManager {
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_MAG = "\u001b[1;35m";
    public static final String ANSI_RESET = "\u001B[0m";

    public List<InventoryReport> viewReports() throws Exception{
        ObjectMapper inputMapper = new ObjectMapper();
        RequestBody clientRequest = new RequestBody();
        clientRequest.setRoute("/reports");
        clientRequest.setAction("view");
        utils.ConnectToServer clientServerConnector = new ConnectToServer();
        ResponseBody responseBody = clientServerConnector.connectToServer(clientRequest);
        System.out.println(responseBody.getData());
        String leftAlignFormat = "| %-11s | %-4d |%n";
        String json = (String) responseBody.getData();
        List<InventoryReport> inventoryReports= Arrays.asList(inputMapper.readValue(json, InventoryReport[].class));

        System.out.println(ANSI_MAG +"\t\t\t\t List of all reports "+ANSI_RESET);
        System.out.format("\t\t| Date \t\t | Company \t| Product  | Status\t| Quantity |\n");

        for(InventoryReport reportModel: inventoryReports){
            Date date = reportModel.getDate();
            String company = reportModel.getCompanyName();
            String product = reportModel.getProduct();
            String status = reportModel.getStatus();
            Integer quantity = reportModel.getQuantity();
//
//                String line = String.format("\t\t| "+date+"  | "+company+"\t| "+product+"\t | "+status+"\t\t| "+quantity+  "\t|");
//                System.out.format(line+"\n");
            String line = String.format("    %s    |   %s   | %s  | %s  | %s ",date,company,product,status,quantity);
            System.out.format(leftAlignFormat, line,2,3);
        }
        return inventoryReports;
    }
}
