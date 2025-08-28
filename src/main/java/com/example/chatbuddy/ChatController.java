package com.example.chatbuddy;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import org.springframework.web.bind.annotation.*;

@RestController
public class ChatController {

    @GetMapping("/")
    public String getRoot() {
        return "Hello world";
    }

    @GetMapping("/greet")
    public String getGreet(@RequestParam String name) {
        return "Hello " + name + "!";
    }

    @GetMapping("/send")
    public String getSend(@RequestParam String token) {
        final Message msg = Message.builder()
            .setToken(token)
            .setNotification(
                Notification.builder()
                    .setTitle("Spring Boot Push")
                    .setBody("This is for testing ...")
                    .build()
            )
            .build();
        try {
            String response = FirebaseMessaging.getInstance().send(msg);
            return "Message sent: " + response;
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}

// --- Tokens ---
// samsung: cif1IhjITSu5_k0T8Svewp:APA91bHgyOL0H4oGTEyiTNfZvdIMHKeYAQuzire9-ELXDXjYglIzpLFfVL3oG7ikjrRpuY2da6TB_Jm-JSR3RJ9D63P5JheaeR1VY9-HH29Hl1NsOGAjFuw
// Emulator: eAL8sG-cQoKf143HNPdvRn:APA91bGKOF6b5geyxWjWyeolZPzw_Sw_U6spI38XX2qBcVTA4bhOTeCYKnziaQGo-roCLHFk1MI-n4yUKmrR_n84kjYzD_O36dx4ppPnMhA2WHjpU7QsfGQ