package HWLone;

public class exerciseThree {

    interface Moveable{
        void move(int x,int y);
    }

    class Top implements Moveable{
        private int x,y;

        public Top(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public void move(int x, int y) {
            this.x+=x;
            this.y+=y;
        }
    }


    abstract class Figure implements Moveable{

    }

    class Triangle extends Figure{
        Top topA, topB, topC;

        public Triangle(Top topA, Top topB, Top topC) {
            this.topA = topA;
            this.topB = topB;
            this.topC = topC;
        }

        @Override
        public void move(int x, int y) {
            topA.move(x,y);
            topB.move(x,y);
            topC.move(x,y);
        }
    }

    class Rectangle extends Figure{
        private Top top;
        private int width;
        private int length;

        public Rectangle(Top top, int width, int length) {
            this.top = top;
            this.width = width;
            this.length = length;
        }

        @Override
        public void move(int x, int y) {
            top.move(x,y);
        }
    }

    class Circle extends Figure{
        private int radius;
        private Top center;

        public Circle(int radius, Top center) {
            this.radius = radius;
            this.center = center;
        }

        @Override
        public void move(int x, int y) {
            center.move(x,y);
        }
    }


}
