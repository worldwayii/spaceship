package model;

import java.util.ArrayList;
import java.util.List;

public class Grid {

    private List<List<Square>> grid;
    private final int GRID_SIZE = 4;


    public Grid() {
        grid = createEmptyGrid();
    }

    private List<List<Square>> createEmptyGrid() {
        List<List<Square>> mat = new ArrayList<>(GRID_SIZE);

        for (int i = 0; i < 4; i++) {
            List<Square> row = new ArrayList<>(GRID_SIZE);
            mat.add(i, row);
            for (int j = 0; j < 4; j++) {
                row.add(j, new Square(i, j));
            }
            System.out.println(row.toString());
        }
        return mat;
    }

    public List<EnemyShip> getShipsOnSquare(int xLoc, int yLoc){
        return grid.get(xLoc).get(yLoc).getShips();
    }

    public boolean isMasterShipOn(int xLoc, int yLoc){
        return grid.get(xLoc).get(yLoc).getTheMasterShip() != null;
    }

    public List<Square> getNeighboursFor(int xLoc, int yLoc){
        List<Square> neighbors = new ArrayList<>();
        // calculate teh range of squares that can be moved to
        int minX = xLoc > 0 ? xLoc - 1 : xLoc;
        int maxX = xLoc < GRID_SIZE - 1 ? xLoc + 1 : xLoc;
        int minY = yLoc > 0 ? yLoc - 1 : yLoc;
        int maxY = yLoc < GRID_SIZE - 1 ? yLoc + 1 : yLoc;

        for (int i = minX; i <= maxX; i++){
            for (int j = minY; j <= maxY; j++){
                // do not add the current location
                if (i != xLoc || j != yLoc) {
                    neighbors.add(grid.get(i).get(j));
                }
            }
        }
        return neighbors;
    }


    public void moveShip(EnemyShip aShip, int xLoc, int yLoc){

    }

}
