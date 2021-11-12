package test.fwd.service.impl;

import java.io.FileInputStream;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.AndroidConfig;
import com.google.firebase.messaging.AndroidNotification;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;

import test.fwd.service.FcmService;


@Service("FcmService")
public class FcmImpl implements FcmService {

	@SuppressWarnings("deprecation")
	@Override
	public void init() throws Exception {
		try{
			String url = "FireBase Key 경로";
			FileInputStream serviceAccount = new FileInputStream(url);
			
			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
					.build();
			
			FirebaseApp.initializeApp(options);
			System.out.println("FcmImpl.java - init()");
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public void sendTest(String status) throws Exception {
		try{
			// [START send_to_token]
		    // This registration token comes from the client FCM SDKs.
			String registrationToken = "Android FireBase Token"; 
		    String title = "";
		    String body = "";
		    
			if(status=="Update"){
				title="Update";
				body="게시판 수정";
			}
			else{
				title="Delete";
				body="게시판 삭제";
			}
			
			// See documentation on defining a message payload.
		    Message message = Message.builder()
		    		.setAndroidConfig(AndroidConfig.builder()
		    		.setPriority(AndroidConfig.Priority.NORMAL)
		    		.setNotification(AndroidNotification.builder()
		    				.setTitle(title)
		    				.setBody(body)
		    				.build())
		    		.build())
		        .setToken(registrationToken)
		        .build();	
		    
		    // Send a message to the device corresponding to the provided
		    // registration token.
		    String response = FirebaseMessaging.getInstance().send(message);
		    
		    // Response is a message ID string.
		    System.out.println("Successfully sent message: " + response);
		    // [END send_to_token]
		    
		    System.out.println("FcmImpl.java - sendTest()");
		    
		}
		catch(Exception e){
			System.out.println("FcmImpl.java - SendTestError : " + e.getMessage());
		}
	}

}
