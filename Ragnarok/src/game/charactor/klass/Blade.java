package game.charactor.klass;

import game.charactor.Novice;
import game.charactor.Skill;

import java.util.ArrayList;

public class Blade extends Novice{

    public Blade(){
        super(1000, 250,45 , 4, "Blade", 200,
                new Skill[]{
                        new Skill("Piercing (0)","damage",0,100,0,0),
                        new Skill("Cracker (15)","damage",15,200,0,0),
                        new Skill("Sword Block (40)", "block" , 40,0,0.75,0),
                        new Skill("Sword Bluff (60)","bluff",60,0,0,3)}
                        );
    }





}
