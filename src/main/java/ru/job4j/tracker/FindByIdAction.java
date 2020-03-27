package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "=== Find item by ID ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter id to search: ");
        Item desiredObject = tracker.findById(id);
        if (desiredObject != null) {
            System.out.println(desiredObject.getName());
        } else {
            System.out.println("Item not found");
        }
        return true;
    }
}
