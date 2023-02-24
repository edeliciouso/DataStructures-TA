public class Rectangle extends Shape{
    int width;
    int height;

    public Rectangle(int width,  int height, String color) {
        super(color);
        this.width = width;
        this.height = height;
    }
    @Override
    public int getArea(){
        return this.width * this.height;
    }
}