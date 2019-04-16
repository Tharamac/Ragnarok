package game.charactor.klass;

import game.charactor.Novice;

public class Nexus extends Novice {
    private String[] skill_list;
    private int[] skill_atk;
    private int[] skill_stamina;

    public Nexus(){
        super(700, 500,25, 4,"Nexus",100,new String[]{"Freezing","Snowball","Ice Wall","Blizzard"}, new int[]{70,150,0,350},new int[]{30,30,80,300});

    }


}
