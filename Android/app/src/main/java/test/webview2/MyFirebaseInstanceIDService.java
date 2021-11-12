package test.webview2;


import static com.google.firebase.messaging.Constants.MessageNotificationKeys.TAG;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;

public class MyFirebaseInstanceIDService extends FirebaseMessagingService {

    public MyFirebaseInstanceIDService() {
    }

    @Override
    public void onNewToken(String token) {
        Log.d(TAG, "Refreshed token: " + token);

        sendRegistrationToServer(token);
    }

    private void sendRegistrationToServer(String token) {
        Log.d(TAG, "new token : " + token);
    }
}