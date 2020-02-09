package game.charactor.klass;

import game.charactor.Novice;
import game.charactor.Skill;

public class Psycho extends Novice {
    public Psycho(){
        super(750,420,30,4,"Psycho",150,
                new Skill[]{
                        new Skill("Mind Snap","damage",20,120,0,0),
                        new Skill("Hypnotised","bluff",100,0,0,0.5),
                        new Skill("Mind Crush","damage",250,275,0,0),
                        new Skill("Bullet Control","reflect",150,0,0.8,1.0)
                },
                new double[]{0.0,0.5,0.5,0.8,1.0,1.0,1.0,1.0,1.0,1.0,1.2,1.2,1.5,2.0}
                );
    }
}
