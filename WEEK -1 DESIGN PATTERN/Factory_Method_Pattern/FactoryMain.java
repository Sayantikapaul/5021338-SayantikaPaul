public class FactoryMain {
    public static void main(String[] args) {
        OsFactorySystem osf = new OsFactorySystem();
        Os obj = osf.getInstance("window");
        obj.specs();
    }
}
