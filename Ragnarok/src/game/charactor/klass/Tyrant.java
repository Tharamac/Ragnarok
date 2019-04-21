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
                        new Skill("Fire Breath (40)","damage",40,100,0,0),
                        new Skill("Fireball (50)","damage",50,180,0,0),
                        new Skill("Flame Bluff (100)", "bluff" , 100,0,0.0,2.0),
                        new Skill("Meteor Strike (350)","damage",350,450,0,0)}
        );
    }



}
