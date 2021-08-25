package game.charactor.klass;

import game.charactor.Novice;
import game.charactor.Skill;

public class Bomberman extends Novice {
    public Bomberman(){
        super(900,320,30,5,"Bomberman",300,
                new Skill[]{
                        new Skill("Grenade","damage",20,120,0,0),
                        new Skill("Cluster Bomb","damage",50,190,0,0),
                        new Skill("Rocket Mania","damage",150,275,0,0),
                        new Skill("Charge","bluff & block",200,0,0.8,1.0),
                        new Skill("Land Mine","reflect",75,0,0,1.5)
                },
                new double[]{0.0,0.0,0.0,0.2,0.4,0.5,0.5,0.5,0.8,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.2,1.2,1.5,1.5,2.0}
        );
    }
}
