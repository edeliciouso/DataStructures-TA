public abstract class Rectangle extends Shape{
    int width;
    int height;


    Rectangle rect = new Rectangle() {
        @Override
        public void getArea(){
            int area = width * height;
        }
    };
}
