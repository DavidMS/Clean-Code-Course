public class Notes {

    /**
     * DATA ABSTRACTION
     */

    public class Point {
        public double x;
        public double y;
    }

    public interface Point {
        double getX();

        double getY();

        void setCartesian(double x, double y);

        double getR();

        double getTheta();

        void setPolar(double r, double theta);
    }

    public interface Vehicle {
        double getFuelTankCapacityInGallons();

        double getGallonsOfGasoline();
    }

    public interface Vehicle {
        double getPercentFuelRemaining();
    }

    /**
     * DATA/OBJECTS ANTI-SYMETRY
     * 
     * Procedural code (code using data structures) makes it easy to add new
     * functions without changing the existing data structures. OO code, on the
     * other hand, makes it easy to add new classes without changing existing
     * functions.
     * 
     * Procedural code makes it hard to add new data structures because all the
     * functions must change. OO code makes it hard to add new functions because all
     * the classes must change.
     */

    public class Square {
        public Point topLeft;
        public double side;
    }

    public class Rectangle {
        public Point topLeft;
        public double height;
        public double width;
    }

    public class Circle {
        public Point center;
        public double radius;
    }

    public class Geometry {
        public final double PI = 3.141592653589793;

        public double area(Object shape) throws NoSuchShapeException {
            if (shape instanceof Square) {
                Square s = (Square) shape;
                return s.side * s.side;
            } else if (shape instanceof Rectangle) {
                Rectangle r = (Rectangle) shape;
                return r.height * r.width;
            } else if (shape instanceof Circle) {
                Circle c = (Circle) shape;
                return PI * c.radius * c.radius;
            }
            throw new NoSuchShapeException();
        }
    }

    public class Square implements Shape {
        private Point topLeft;
        private double side;

        public double area() {
            return side * side;
        }
    }

    public class Rectangle implements Shape {
        private Point topLeft;
        private double height;
        private double width;

        public double area() {
            return height * width;
        }
    }

    public class Circle implements Shape {
        private Point center;
        private double radius;
        public final double PI = 3.141592653589793;

        public double area() {
            return PI * radius * radius;
        }
    }

    /**
     * THE LAW OF DEMETER
     * 
     * a method f of a class C should only call the methods of these: • C • An
     * object created by f • An object passed as an argument to f • An object held
     * in an instance variable of C
     */

    // TRAIN WRECKS
    public class SceneController {

        EnemyBuilder enemyBuilder;
        BeaconManager beaconManager;

        public void update() {

            int enemyX = enemyBuilder.getLastSpawnedEnemy().getInitialPosition().getX();
            beaconManager.createBeacon(enemyX);

            // enemyBuilder.lastSpawnedEnemy.initialPosition.x;

            /*
             * Enemy lastSpawnedEnemy = enemyBuilder.getLastSpawnedEnemy(); Position
             * initialPosition = lastSpawnedEnemy.getInitialPosition(); int initialXPosition
             * = initialPosition.getX();
             * 
             * beaconManager.createBeacon(initialXPosition);
             */

            /*
             * enemyBuilder.createBeaconOnLastSpawnedEnemyPosition();
             */
        }

    }

    /**
     * DATA TRANSFER OBJECTS
     */

    /**
     * ACTIVE RECORDS
     */

}
