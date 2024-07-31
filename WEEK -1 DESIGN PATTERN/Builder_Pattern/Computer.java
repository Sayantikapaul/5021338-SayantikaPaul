public class Computer {
    // Attributes
    private String CPU;
    private String RAM;
    private String storage;
  

    // Private constructor to prevent direct instantiation
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
    }

  
    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", storage=" + storage + "]";
    }

    // Builder Class
    public static class Builder {
        private String CPU;
        private String RAM;
        private String storage;

    
        // Methods to set each attribute
        public Builder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public Builder setRAM(String RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        // Build method to create an instance of Computer
        public Computer build() {
            return new Computer(this);
        }
    }
}
