
public class BuilderPatternExample {
    public static void main(String[] args) {
        
        Computer basicComputer = new Computer.Builder()
                .setCPU("Intel i3")
                .setRAM("8GB")
                .setStorage("500GB HDD")
                .build();

        System.out.println(basicComputer);

      
        Computer gamingComputer = new Computer.Builder()
                .setCPU("Intel i7")
                .setRAM("32GB")
                .setStorage("1TB SSD")
                .build();

        System.out.println(gamingComputer);

        // Workstation Computer
        Computer workstationComputer = new Computer.Builder()
                .setCPU("AMD Ryzen 9")
                .setRAM("64GB")
                .setStorage("2TB SSD")
                .build();

        System.out.println(workstationComputer);
    }
}
