package game.charactor.klass;

import game.charactor.Novice;

public class Tyrant extends Novice {
    private String[] skill_list;
    private int[] skill_atk;
    private int[] skill_stamina;

    public Tyrant(){
        super(1100, 400,30, 4 , "Tyrant", 250 ,new String[]{"Fire Breath","Fireball","Flamebluff","Meteor Strike"},new int[]{100,180,0,450},new int[]{40,50,80,350});
    }


}
