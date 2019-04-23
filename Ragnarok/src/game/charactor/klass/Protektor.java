package game.charactor.klass;

import game.charactor.Novice;
import game.charactor.Skill;

public class Protektor extends Novice{
    public Protektor() {
        super(740,600,40,5,"Protektor",300,
                new Skill[]{
                        new Skill("Protek","block",0,0,0.75,0),
                        new Skill("Pink Ponk","reflect",55,0,0.65,0.5),
                        new Skill("Power Stream", "bluff & block" , 250,0,0.55,1.5),
                        new Skill("Extraboost","bluff",200,0,0,3),
                        new Skill("Groundpak","damage",450,520,0,0),
                    }
                );
    }
}
