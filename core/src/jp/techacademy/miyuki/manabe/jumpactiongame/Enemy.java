package jp.techacademy.miyuki.manabe.jumpactiongame;

import com.badlogic.gdx.graphics.Texture;

import java.util.Random;

public class Enemy extends GameObject {
    // 横幅、高さ
    public static final float ENEMY_WIDTH = 0.75f;
    public static final float ENEMY_HEIGHT = 0.75f;



    // 状態
    public static final int ENEMY_EXIST = 0;
    public static final int ENEMY_NONE = 1;

    int mState;
    float mheightTop,mheightBottom;

    Random mRandom = new Random();

    public Enemy(Texture texture, int srcX, int srcY, int srcWidth, int srcHeight) {
        super(texture, srcX, srcY, srcWidth, srcHeight);
        setSize(ENEMY_WIDTH, ENEMY_HEIGHT);
        velocity.y = mRandom.nextFloat()*5;
        mheightTop  = mRandom.nextFloat()*GameScreen.WORLD_HEIGHT+1f;
        mheightBottom = mheightTop-1f;
    }

    public float getHeightTop(){
        return mheightTop;
    }
    public float getHeightBottom(){
        return mheightBottom;
    }

    // 座標を更新する
    public void update(float deltaTime) {

        if (getY() > mheightTop) {
                velocity.y = -velocity.y;
        }
        if (getY() < mheightBottom) {
                velocity.y = -velocity.y;
        }
        setY(getY() + velocity.y * deltaTime);
    }
}