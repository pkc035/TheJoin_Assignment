package test.fwd.service;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.BatchResponse;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.MulticastMessage;
import com.google.firebase.messaging.SendResponse;

public class FcmUtil {
	public void send_FCM(List<String> tokenId, String title, String content){
		try{
				String url = "C:\\Users\\thejoin31\\workspace\\test2\\test2\\src\\main\\resources\\fcm\\fbtest-541ed-firebase-adminsdk-5uq7r-cb377fd6ca.json";
				FileInputStream serviceAccount = new FileInputStream(url);
				
				FirebaseOptions options = new FirebaseOptions.Builder()
						.setCredentials(GoogleCredentials.fromStream(serviceAccount))
						.build();
				
				FirebaseApp.initializeApp(options);
				System.out.println("FcmUtil.java - Firebase Test");
				
				MulticastMessage message = MulticastMessage.builder()
					    .putData("title", title)
					    .putData("content",content)
					    .addAllTokens(tokenId)
					    .build();
					
						BatchResponse response = FirebaseMessaging.getInstance().sendMulticast(message);	
						
						if (response.getFailureCount() > 0) {
							  List<SendResponse> responses = response.getResponses();
							  List<String> failedTokens = new ArrayList<>();
							  for (int i = 0; i < responses.size(); i++) {
								  
							    if (!responses.get(i).isSuccessful()) {
							      failedTokens.add(tokenId.get(i));
							    }
							    
							  }
							 
						}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
