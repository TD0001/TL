public class Animal {
    // thuoc tinh
    int legsNumber;
    String shapeOfHead;
    String name;

    // ham tao
    public Animal() {
        legsNumber = 4;
        shapeOfHead = "Oval";
        name = "Kiki";
    }

    public Animal(int legsNumber
            , String shapeOfHead, String name) {
        this.legsNumber = legsNumber;
        this.shapeOfHead = shapeOfHead;
        this.name = name;
    }

    // phuong thuc
    public void run() {
        System.out.println("Running");
    }

    public void sayHello() {
        System.out.println(this.name + " hello");
    }
}
