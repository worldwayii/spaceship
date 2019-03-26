package model;

import java.util.Random;

public class MasterShip {

    private int xLoc;
    private int yLoc;

    public MasterShip() {
        int[] initialPos = generateInitialPosition();
        xLoc = initialPos[0];
        yLoc = initialPos[1];
    }

    private int[] generateInitialPosition(){
        Random random = new Random();
        int x = random.nextInt(Grid.GRID_SIZE);
        int y = random.nextInt(Grid.GRID_SIZE);
        return new int[]{x,y};
    }

    public int getxLoc() {
        return xLoc;
    }

    public int getyLoc() {
        return yLoc;
    }

    public void setxLoc(int xLoc) {
        this.xLoc = xLoc;
    }

    public void setyLoc(int yLoc) {
        this.yLoc = yLoc;
    }

    @Override
    public String toString() {
        return "MasterShip{" +
                "xLoc=" + xLoc +
                ", yLoc=" + yLoc +
                '}';
    }
}
