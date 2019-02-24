package game.charactor.klass;

import game.charactor.Novice;

public class Nexus extends Novice {
    private String[] skill_list;
    private int[] skill_atk;
    private int[] skill_stamina;

    public Nexus(){
        super(150, 250,180);
        skill_list = new String[]{"Freezing","Snowball","Ice Wall","Blizzard"};
        skill_atk = new int[]{7,15,0,35};
        skill_stamina = new int[]{15,5,10,45};
    }
}
