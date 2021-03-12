package HWLone;

/**
 * отсутствует класс Engine - добавил
 * класс Lorry надо признать абстрактным или реализовать абстрактный метод родителя. Т.к. от интерфейса нельзя
 * наследоваться следует имплементировать.
 * Изменить модификатор доступа к engine или убрать геттеры сеттеры.
 * В целях оптимизации я бы добавил или конструктор с параметрами или использовал тот самый паттер билдера.
 * */

public class exerciseTwo {

    interface Moveable {
        void move();
    }

    interface Stopable {
        void stop();
    }

    class Engine{
        private Double volume;

        public Engine(Double volume) {
            this.volume = volume;
        }

        public Double getVolume() {
            return volume;
        }

        public void setVolume(Double volume) {
            this.volume = volume;
        }
    }

    abstract class Car {
        private Engine engine;
        private String color;
        private String name;


        protected void start() {
            System.out.println("Car starting");
        }

        abstract void open();

        public Engine getEngine() {
            return engine;
        }

        public void setEngine(Engine engine) {
            this.engine = engine;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    class LightWeightCar extends Car implements Moveable {

        @Override
        void open() {
            System.out.println("Car is open");
        }

        @Override
        public void move() {
            System.out.println("Car is moving");
        }

    }

    class Lorry extends Car implements Moveable, Stopable {

        @Override
        void open() {

        }

        public void move() {
            System.out.println("Car is moving");
        }

        public void stop() {
            System.out.println("Car is stop");
        }
    }

}
