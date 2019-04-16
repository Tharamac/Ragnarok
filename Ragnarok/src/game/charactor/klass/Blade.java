package game.charactor.klass;

import game.charactor.Novice;
import game.charactor.Skill;

import java.util.ArrayList;

public class Blade extends Novice{

    public Blade(){
        super(1000, 250,45 , 4, "Blade", 200,
                new Skill[]{
                        new Skill("Piercing","damage",0,100,0,0),
                        new Skill("Cracker","damage",15,200,0,0),
                        new Skill("Sword Block", "block" , 40,0,0.75,0),
                        new Skill("Sword Bluff","bluff",60,0,0,3)}
                        );
    }





}
