public class Dessert {
    int flavor,price;
    public static int numDesserts=0;
    public  void printDessert(){
        System.out.print(this.flavor);
        System.out.print(" "+this.price);
        System.out.println(" "+this.numDesserts);
    }
    public Dessert(int flavor, int price){
        this.flavor=flavor;
        this.price=price;
        numDesserts++;
    }
    public static void main(String[] args) {
        System.out.println("I love dessert!");
    }
}
