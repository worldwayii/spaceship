package model;

public enum EnemyShip {
    BATTLE_SHOOTER(-1, -1),
    BATTLE_CRUISER(-1, -1),
    BATTLE_STAR(-1, -1);

    private int xLoc;
    private int yLoc;

    EnemyShip(int xLoc, int yLoc) {
        this.xLoc = xLoc;
        this.yLoc = yLoc;
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
        return "EnemyShip{" +
                "xLoc=" + xLoc +
                ", yLoc=" + yLoc +
                '}';
    }
}
