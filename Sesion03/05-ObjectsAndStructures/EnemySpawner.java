public class EnemySpawner {

    private List<Enemy> enemiesPool = new ArrayList<Enemy>();
    private Enemy lastSpawnedEnemy;

    public List<Enemy> getEnemiesPool() {
        return enemiesPool;
    }

    public void setEnemiesPool(List<Enemy> enemiesPool) {
        this.enemiesPool = enemiesPool;
    }

    public Enemy getLastSpawnedEnemy() {
        return lastSpawnedEnemy;
    }

    public void setLastSpawnedEnemy(Enemy lastSpawnedEnemy) {
        this.lastSpawnedEnemy = lastSpawnedEnemy;
    }
}