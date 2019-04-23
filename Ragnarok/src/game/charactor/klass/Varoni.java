package game.charactor.klass;

import game.charactor.Novice;
import game.charactor.Skill;

public class Varoni extends Novice {
    public Varoni(){
        super(600, 200,25 , 4, "Varoni", 160,
                new Skill[]{
                        new Skill("S-Spear Attack","damage",0,50,0,0),
                        new Skill("X-Ray","damage",0,160,0,0),
                        new Skill("B-Barrier", "block" , 0,0,0.25,0),
                        new Skill("D-Deadly Punch","damage",200,650,0,0)},
                new double[]{0.0,0.5,0.8,0.8,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.2,1.2,1.5,2.0}

        );
    }

}
