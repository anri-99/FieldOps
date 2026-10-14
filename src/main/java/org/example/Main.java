package org.example;

import repository.InMemoryInterventionRepository;
import repository.InterventionRepository;
import service.InterventionService;
import service.NotificationService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    static void main() {

        InterventionRepository repository = new InMemoryInterventionRepository();
        NotificationService notificationService = new NotificationService();
        InterventionService service =new InterventionService(repository, notificationService);
        FieldOpsController controller = new FieldOpsController(service);

        controller.startFieldOps();

    }
}
