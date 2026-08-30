package org.example;

import repository.InMemoryInterventionRepository;
import repository.InterventionRepository;
import service.InterventionService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    static void main() {

        InterventionRepository repository = new InMemoryInterventionRepository();
        InterventionService service =new InterventionService(repository);
        FieldOpsController controller = new FieldOpsController(service);

        controller.startFieldOps();

    }
}
