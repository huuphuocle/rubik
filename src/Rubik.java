public class Rubik extends Node {
    private Cell[] state;

    public Rubik(){
        Cell[] state = new Cell[8];
    }

    public Rubik(Cell[] state){
        this.state = state;
    }

    @Override
    public Rubik clone(){
        Cell[] cells = new Cell[8];
        for(int i = 0; i < 8; ++i){
            cells[i] = new Cell(state[i].faces);
        } 
        return new Rubik(cells);
    }

    public static Rubik finalState(){
        Cell[] cells = new Cell[8];
        cells[0] = new Cell(new Color[]{Color.WHITE, Color.BLUE, Color.RED});
        cells[1] = new Cell(new Color[]{Color.WHITE, Color.ORANGE, Color.BLUE});
        cells[2] = new Cell(new Color[]{Color.WHITE, Color.GREEN, Color.ORANGE});
        cells[3] = new Cell(new Color[]{Color.WHITE, Color.RED, Color.GREEN});
        cells[4] = new Cell(new Color[]{Color.YELLOW, Color.RED, Color.BLUE});
        cells[5] = new Cell(new Color[]{Color.YELLOW, Color.BLUE, Color.ORANGE});
        cells[6] = new Cell(new Color[]{Color.YELLOW, Color.ORANGE, Color.GREEN});
        cells[7] = new Cell(new Color[]{Color.YELLOW, Color.GREEN, Color.RED});

        return new Rubik(cells);
    }

    public void moveD(){
        Cell temp = state[7];
        state[7] = state[6];
        state[6] = state[5];
        state[5] = state[4];
        state[4] = temp;
    }

    public void moveD2(){
        Cell temp = state[7];
        state[7] = state[4];
        state[4] = state[5];
        state[5] = state[6];
        state[6] = temp;
    }

    public void moveB(){        
        Cell temp = state[3];
        state[3] = state[2];
        state[2] = state[6];
        state[6] = state[7];
        state[7] = temp;
        state[3].shiftF();
        state[2].shiftB();
        state[6].shiftF();
        state[7].shiftB();
    }

    public void moveB2(){
        moveB();moveB();moveB();
        // Cell temp = state[3];
        // state[3] = state[7];
        // state[7] = state[6];
        // state[6] = state[2];
        // state[2] = temp;
    }

    public void moveR(){
        Cell temp = state[1];
        state[1] = state[5];
        state[5] = state[6];
        state[6] = state[2];
        state[2] = temp;
        state[1].shiftB();
        state[5].shiftF();
        state[6].shiftB();
        state[2].shiftF();
    }

    public void moveR2(){
        moveR();moveR();moveR();
        // Cell temp = state[1];
        // state[1] = state[2];
        // state[2] = state[6];
        // state[6] = state[5];
        // state[5] = temp;
    }

    @Override
    public boolean equals(Object o){
        Rubik ro = (Rubik) o;
        for(int i = 0; i < 8; ++i){
            if(!state[i].equals(ro.state[i])) return false;
        } 
        return true;
    }

    public void print(){
        System.out.println("===================================");

        System.out.print("U : ");
        System.out.println(state[0].faces[0] + ", " + state[1].faces[0] 
                            + ", " + state[2].faces[0] + ", " + state[3].faces[0]);

        System.out.print("D : ");
        System.out.println(state[4].faces[0] + ", " + state[5].faces[0] 
                        + ", " + state[6].faces[0] + ", " + state[7].faces[0]);

        System.out.print("R : ");
        System.out.println(state[1].faces[1] + ", " + state[2].faces[2] 
                            + ", " + state[5].faces[2] + ", " + state[6].faces[1]);

        System.out.print("L : ");
        System.out.println(state[0].faces[2] + ", " + state[3].faces[1] 
                            + ", " + state[4].faces[1] + ", " + state[7].faces[2]);

        System.out.print("F : ");
        System.out.println(state[0].faces[1] + ", " + state[1].faces[2] 
                            + ", " + state[4].faces[2] + ", " + state[5].faces[1]);

        System.out.print("B : ");
        System.out.println(state[2].faces[1] + ", " + state[3].faces[2] 
                            + ", " + state[6].faces[2] + ", " + state[7].faces[1]);

        System.out.println("===================================");
    }

    // Placeholder
    // @Override
    // public int getLabel(){
    //     return 0;
    // }
}
