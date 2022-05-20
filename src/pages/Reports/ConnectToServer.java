package pages.Reports;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import formats.RequestBody;
import formats.ResponseBody;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ConnectToServer {
    public ResponseBody res = new ResponseBody();
    public ResponseBody connectToServer(RequestBody clientRequest)throws Exception
    {

        try (Socket socket = new Socket("192.168.0.127", 5015)) {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

            // reading from server
            DataInputStream in = new DataInputStream(socket.getInputStream());

            // sending the user input to server
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(clientRequest);

            List<String> dt = new ArrayList<>();
            dt.add(json);
            out.writeObject(dt);
            String jsonReturned =  in.readUTF();
            ObjectMapper inputMapper = new ObjectMapper();
            JsonNode jsonNodeRoot = inputMapper.readTree(jsonReturned);
            res.setMessage(jsonNodeRoot.get("status").asText());
            res.setData(jsonReturned.split("data\":")[1].split(",\"message\"")[0]);
            return res;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

