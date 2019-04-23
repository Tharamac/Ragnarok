package game.charactor.klass;

import game.charactor.Novice;
import game.charactor.Skill;

public class Tyrant extends Novice {
    private String[] skill_list;
    private int[] skill_atk;
    private int[] skill_stamina;

    public Tyrant(){
        super(1100, 400,60 , 4, "Tyrant", 250,
                new Skill[]{
                        new Skill("Fire Breath","damage",40,100,0,0),
                        new Skill("Fireball","damage",50,180,0,0),
                        new Skill("Flame Bluff", "bluff & block" , 100,0,0.8,2.0),
                        new Skill("Meteor Strike","damage",350,450,0,0)},
                new double[]{0.0,0.0,0.0,0.5,0.5,0.8,0.8,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.2,1.2,1.5,2.0}
        );
    }



}
