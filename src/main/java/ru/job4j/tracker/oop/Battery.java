package ru.job4j.tracker.oop;

public class Battery {
    private int load;

    public Battery(int load) {
        this.load = load;
    }

    public void exchange(Battery anotherBattery) {
        anotherBattery.load += this.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery battery1 = new Battery(100);
        Battery battery2 = new Battery(10);
        System.out.println("Заряд первой батареи :" + battery1.load + ". Заряд второй батареи :" + battery2.load);
        battery1.exchange(battery2);
        System.out.println("Заряд первой батареи :" + battery1.load + ". Заряд второй батареи :" + battery2.load);
    }
}
