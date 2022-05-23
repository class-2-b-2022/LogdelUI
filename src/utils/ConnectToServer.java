package utils;

import java.io.DataInputStream;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import formats.RequestBody;
import formats.ResponseBody;
import formats.User;

public class ConnectToServer {
	public static String removeLastCharacter(String str)
	{

		// Removing first and last character
		// of a string using substring() method
		str = str.substring(0, str.length() - 1);

		// Return the modified string
		return str;
	}
	public static ResponseBody connectToServer(RequestBody clientRequest) throws Exception {
		// establish a connection by providing host and port
		ResponseBody res = new ResponseBody();
		// number
		try (Socket socket = new Socket("localhost", 5450)) {

			// writing to server
			ObjectOutputStream requestStream = new ObjectOutputStream(socket.getOutputStream());

			// sending the user input to server
			ObjectMapper objectMapper = new ObjectMapper();
			String json = objectMapper.writeValueAsString(clientRequest);

			List<String> dataTosend = new ArrayList<>();
			dataTosend.add(json);
			// sending request
			requestStream.writeObject(dataTosend);

			// getting response
			DataInputStream in = new DataInputStream(socket.getInputStream());
			String jsonReturned = in.readUTF();
			ObjectMapper inputMapper = new ObjectMapper();
			JsonNode jsonNodeRoot = inputMapper.readTree(jsonReturned);
			jsonNodeRoot = inputMapper.readTree(jsonReturned);
			res.setMessage(jsonNodeRoot.get("message").asText());
			res.setData(ConnectToServer.removeLastCharacter(jsonReturned.split("data\":")[1].split(",\"message\"")[0]));
			res.setStatus((jsonNodeRoot.get("status").asText()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}

	public static void main(String[] args) throws Exception {
		User user = new User();
		user.setNames("test1");
		user.setPhone(781253647);
		user.setEmail("rdev@gmail.com");
		user.setPassword("nicemonn");
		user.setRole(1);

		RequestBody clientRequest = new RequestBody();
		clientRequest.setRoute("/users");
		clientRequest.setAction("register");
		clientRequest.setData(user);

		ResponseBody responseBody;
		try {
			responseBody = connectToServer(clientRequest);
			System.out.println("Data: " + responseBody.getData());
			System.out.println("Message: " + responseBody.getMessage());
			System.out.println("Status: " + responseBody.getStatus());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}

	}

}
