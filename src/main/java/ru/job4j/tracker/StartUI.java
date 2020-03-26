package ru.job4j.tracker;


public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select menu: ");
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                String name2 = input.askStr("Enter name: ");
                Item item = new Item(name2);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Show all items ====");
                for (Item item : tracker.findAll()) {
                    System.out.println(item.getName() + " : " + item.getId());
                }
            } else if (select == 2) {
                System.out.println("=== Edit Item ====");
                String id = input.askStr("Enter the id of the item you want to edit: ");
                String name = input.askStr("Enter new name: ");
                Item item = new Item(name);
                if (tracker.replace(id, item)) {
                    System.out.println("Successfully changed");
                } else {
                    System.out.println("Error, item not found");
                }
            } else if (select == 3) {
                System.out.println("=== Delete Item ====");
                String id = input.askStr("Enter the id of the item you want to delete: ");
                if (tracker.delete(id)) {
                    System.out.println("Item deleted");
                } else {
                    System.out.println("Error, item not found");
                }
            } else if (select == 4) {
                System.out.println("===  Find Item by id ====");
                String id = input.askStr("Enter id to search: ");
                Item desiredObject = tracker.findById(id);
                if (desiredObject != null) {
                    System.out.println(tracker.findById(id).getName());
                } else {
                    System.out.println("Item not found");
                }
            } else if (select == 5) {
                System.out.println("=== Find items by name ====");
                System.out.print("Enter name: ");
                String name = input.askStr("Enter name: ");
                Item[] foundItems = tracker.findByName(name);
                if (foundItems.length != 0) {
                    for (Item item : foundItems) {
                        System.out.println(item.getName() + " : " + item.getId());
                    }
                } else {
                    System.out.println("No matching items found");
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("0. Add new item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit program");
        // добавить остальные пункты меню.
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}