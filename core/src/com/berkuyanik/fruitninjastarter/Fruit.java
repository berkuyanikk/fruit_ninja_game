package com.berkuyanik.fruitninjastarter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Fruit {
    public static float radius = 60f;

    public enum Type {
        REGULAR, EXTRA, ENEMY, LIFE
    }

    Type type;

    Fruit(Vector2 pos, Vector2 velocity) {
        this.pos = pos;
        this.velocity = velocity;
        type = Type.REGULAR;
    }

    Vector2 pos, velocity;
    public boolean living = true;

    public boolean clicked(Vector2 click) {
        if (pos.dst2(click) <= radius * radius + 1) return true;
        return false;
    }

    public void update(float dt) {
        velocity.y -= dt * (Gdx.graphics.getHeight() * 0.2f);
        velocity.x -= dt * Math.signum(velocity.x) * 5f;
        pos.mulAdd(velocity, dt);
    }

    public boolean outOfScreen() {
        return (pos.y < -2f * radius);
    }

    public final Vector2 getPos() {
        return pos;
    }
}
