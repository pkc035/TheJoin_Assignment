package test.fwd.service;

import com.google.firebase.messaging.Notification;

public interface FcmService {
	
	void init() throws Exception;
	
	void sendTest(String status) throws Exception;
	
}
