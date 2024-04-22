

public class Dog {
    //properties ( in java they called field)
     String furColor;

    private String breed;

    private int age;

    private double size;

    //constructor //how we build dogs
    public Dog (String furColor, String breed, int age, double size){
        this.furColor = furColor;
        this.breed = breed;
        this.age = age;
        this.size = size;

    }

    // getter and setter
    public String getFurColor(){
        return this.furColor;

    }

    public void setFurColor ( String furColor){
        this.furColor = furColor;


    }



    //Behavior ( method/ function)
    public void barks(){
        System.out.println("woofs");
    }



}
