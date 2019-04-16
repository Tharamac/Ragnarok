package game.charactor.klass;

import game.charactor.Novice;

public class Blade extends Novice{
    private String[] skill_list;
    private int[] skill_atk;
    private int[] skill_stamina;

    public Blade(){
        super(1000, 250,15 , 4, "Blade", 200, new String[]{"Piercing", "Cracker", "Sword Block", "Bluff"}, new int[]{150,70,0,0},new int[]{0,0,20,50});
    }




}
