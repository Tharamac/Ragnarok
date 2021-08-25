package game.charactor.klass;

import game.charactor.Novice;
import game.charactor.Skill;

public class Handshadow extends Novice {

    public Handshadow(){
        super(800, 300,100 , 4, "Handshadow", 190,
                new Skill[]{
                        new Skill("Rock","damage",0,150,0,0),
                        new Skill("Paper","damage",0,150,0,0),
                        new Skill("Scissors", "damage" ,0,150,0,0),
                        new Skill("Lucky Star","block & bluff",100,0,0.75,2.25)},
                new double[]{0.0,0.8,0.5,0.8,0.8,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.2,1.2,1.5,2.0}

        );
    }
}
