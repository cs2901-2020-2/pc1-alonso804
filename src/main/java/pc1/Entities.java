package pc1;

import java.util.List;

public class Entities {
    private List<String> notifications;

    public void notificate(String profesor) {
        notifications.add(profesor);
    }
}
