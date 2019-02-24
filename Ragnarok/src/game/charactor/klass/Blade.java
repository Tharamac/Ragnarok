package game.charactor.klass;

import game.charactor.Novice;

public class Blade extends Novice{
    private String[] skill_list;
    private int[] skill_atk;
    private int[] skill_stamina;


    public Blade(){
        super(250, 100,100);
        skill_list = new String[]{"Piercing","Cracker","Sword Block","Bluff"};
        skill_atk = new int[]{15,7,0,0};
        skill_stamina = new int[]{0,0,10,25};
    }


}
