package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find item by name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        Item[] foundItems = tracker.findByName(name);
        if (foundItems.length != 0) {
            for (Item item : foundItems) {
                System.out.print(item.getName() + " : " + item.getId());
            }
        } else {
            System.out.println("No matching items found");
        }
        return true;
    }
}
