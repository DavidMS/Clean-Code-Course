
/*Encapsulation of behavior associated with getting or setting the property -
  this allows additional functionality (like validation) to be added more easily later.

  Hiding the internal representation of the property while exposing a property using an alternative representation.

  Insulating your public interface from change - allowing the public interface to remain constant while the
  implementation changes without affecting existing consumers.

  Controlling the lifetime and memory management (disposal) semantics of the property -
  particularly important in non-managed memory environments (like C++ or Objective-C).

  Providing a debugging interception point for when a property changes at runtime -
  debugging when and where a property changed to a particular value can be quite difficult without this in some languages.

  Improved interoperability with libraries that are designed to operate against property getter/setters -
  Mocking, Serialization, and WPF come to mind.

  Allowing inheritors to change the semantics of how the property behaves and is exposed by overriding the
  getter/setter methods.

  Allowing the getter/setter to be passed around as lambda expressions rather than values.

  Getters and setters can allow different access levels - for example the get may be public,
  but the set could be protected.*/

public class ObjectsAndDataStructures {

    private int width;
    private int height;
    private int totalEnemies;
    private int mainEnemyPosition;


    private int level;
    private int totalPoints;

    private EnemySpawner enemySpawner;
    private BeaconManager beaconManager;

    public void createBeaconForEnemy() {

        int beaconPosition = enemySpawner.getLastSpawnedEnemy().getInitialPosition().getX();
        beaconManager.createBeacon(beaconPosition);

    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public EnemySpawner getEnemySpawner() {
        return enemySpawner;
    }

    public void setEnemySpawner(EnemySpawner enemySpawner) {
        this.enemySpawner = enemySpawner;
    }

    public BeaconManager getBeaconManager() {
        return beaconManager;
    }

    public void setBeaconManager(BeaconManager beaconManager) {
        this.beaconManager = beaconManager;
    }
}