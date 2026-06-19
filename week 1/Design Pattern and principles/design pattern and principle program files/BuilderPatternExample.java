public class BuilderPatternExample {
    static class Computer {
        private String cpu;
        private String ram;
        private String storage;
        private String graphicsCard;
        private Computer(Builder builder) {
            this.cpu = builder.cpu;
            this.ram = builder.ram;
            this.storage = builder.storage;
            this.graphicsCard = builder.graphicsCard;
        }
        public void showDetails() {
            System.out.println("Computer Configuration");
            System.out.println("CPU :" + cpu);
            System.out.println("RAM :" + ram);
            System.out.println("Storage :" + storage);
            System.out.println("Graphics Card :" + graphicsCard);
        }
        static class Builder {

            private String cpu;
            private String ram;
            private String storage;
            private String graphicsCard;

            public Builder setCPU(String cpu) {
                this.cpu = cpu;
                return this;
            }

            public Builder setRAM(String ram) {
                this.ram = ram;
                return this;
            }

            public Builder setStorage(String storage) {
                this.storage = storage;
                return this;
            }

            public Builder setGraphicsCard(String graphicsCard) {
                this.graphicsCard = graphicsCard;
                return this;
            }

            public Computer build() {
                return new Computer(this);
            }
        }
    }
    public static void main(String[] args) {

        Computer user1 = new Computer.Builder()
                .setCPU("Intel i5")
                .setRAM("16 GB")
                .setStorage("512 TB SSD")
                .setGraphicsCard("NVIDIA RTX 3080")
                .build();

        user1.showDetails();
    }
}