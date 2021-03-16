public class Cohesion {


    private static int MAX_STAMINA = 100;

    private InputManager inputManager;
    private CollisionDetector collisionDetector;
    private AnimationController animationController;

    private RigidBody2d rigidBody2d;

    private int health;
    private int magic;
    private int stamina;
    private int powerUp;
    private boolean attacking = false;

    public void Start() {
        health = 100;
        powerUp = 0;
        stamina = MAX_STAMINA;
    }

    public void Update() {
        if(inputManager.getKey("right")) {
            rigidBody2d.forward();
            animationController.playAnimation("walking");
        }
        if(inputManager.getKey("left")) {
            rigidBody2d.backward();
            animationController.playAnimation("walking");
        }
        if(inputManager.getKey("jump")) {
            jump();
        }

        if(inputManager.getKey("fire")) {
            attack();
        }
        if(inputManager.getKey("magic")) {
            magic();
        }
        if(inputManager.getKey("powerUpAttack")) {
            powerUpAttack();
        }
        if(stamina < MAX_STAMINA) {
            stamina++;
        }
    }

    public void attack() {
        attacking = true;
        stamina--;
        powerUp++;
        animationController.playAnimation("attack");
    }

    public void magic() {
        magic--;
        animationController.playAnimation("magic");
    }

    public void powerUpAttack() {
        powerUp--;
        stamina--;
        stamina--;
        animationController.playAnimation("powerUpAttack");
    }

    public void jump() {
        animationController.playAnimation("jump");
        rigidBody2d.up();
    }

    public void onEnterCollision2d(Collider collider) {
        if(collider.getTag("damage")) {
            health--;
            if(attacking){
                powerUp++;
                attacking = false;
            }
        }
    }





}