// Observer Interface
interface Observer {
    void onAlertReceived(Event event);

    String getUserType(); // Used by the policy to filter
}

class SecurityTeam implements Observer {
    public void onAlertReceived(Event event) {
        System.out.println("SECURITY ALERT: Deploying team to " + event.getLocation());
    }

    public String getUserType() {
        return "Security";
    }
}

class MaintenanceTeam implements Observer {
    public void onAlertReceived(Event event) {
        System.out.println("MAINTENANCE: Ticket created for " + event.getType());
    }

    public String getUserType() {
        return "Maintenance";
    }
}

class StudentApp implements Observer {
    public void onAlertReceived(Event event) {
        System.out.println("STUDENT APP PUSH: Warning! " + event.getType() + " reported.");
    }

    public String getUserType() {
        return "Student";
    }
}