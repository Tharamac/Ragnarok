package game.charactor.klass;

import game.charactor.Novice;
import game.charactor.Skill;

public class Nexus extends Novice {
    private String[] skill_list;
    private int[] skill_atk;
    private int[] skill_stamina;

    public Nexus(){
        super(700, 500,25 , 4, "Nexus", 100,
                new Skill[]{
                        new Skill("Freezing","damage",30,70,0,0),
                        new Skill("Snowball","damage",30,150,0,0),
                        new Skill("Ice Wall", "block" , 80,0,0.5,0),
                        new Skill("Blizzard","damage",300,350,0,0)}
        );
    }


}
