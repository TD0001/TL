package game.enemy;

import game.Background;
import game.FrameCounter;
import game.GameObject;

import java.util.Random;

public class EnemySummoner extends GameObject {
    FrameCounter summonCounter;

    public EnemySummoner() {
        this.summonCounter = new FrameCounter(100);

    }
    public void run() {
        if (this.summonCounter.count()) {
            if (new Random().nextInt(2)==1) {
                EnemyType1 enemy = GameObject.recycleGameObjects(EnemyType1.class);
                enemy.position.set(new Random().nextInt(384)
                        ,20+new Random().nextInt(150));
            } else {
                EnemyType2 enemy = GameObject.recycleGameObjects(EnemyType2.class);
                enemy.position.set(new Random().nextInt(384)
                        ,20+new Random().nextInt(150));
            }
            this.summonCounter.reset();
        }

    }
}
