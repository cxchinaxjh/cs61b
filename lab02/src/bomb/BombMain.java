package bomb;

import common.IntList;

public class BombMain {
    public static void answers(String[] args) {
        int phase = 2;
        if (args.length > 0) {
            phase = Integer.parseInt(args[0]);
        }
        // TODO: Find the correct inputs (passwords) to each phase using debugging techniques
        Bomb b = new Bomb();
        if (phase >= 0) {
            b.phase0("39291226");
        }
        if (phase >= 1) {
            IntList ans=new IntList(0,null);
            ans.rest=new IntList(9,null);
            ans.rest.rest=new IntList(3,null);
            ans.rest.rest.rest=new IntList(0,null);
            ans.rest.rest.rest.rest=new IntList(8,null);
            b.phase1(ans); // Figure this out too
        }
        if (phase >= 2) {
            b.phase2("793227803");
        }
    }
}
