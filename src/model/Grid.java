package model;

import java.util.ArrayList;
import java.util.List;

public class Grid {

    private List<List<Square>> grid;
    public static final int GRID_SIZE = 4; //sets the size of the grid
    private MasterShip master;
    private List <EnemyShip> ships = new ArrayList<EnemyShip> ();


    public Grid() {
        grid = createEmptyGrid();
        master = new MasterShip();
    }


    // This method create and empty grid
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
        List<EnemyShip> shipsAtLoc = new ArrayList<>();
        for(int i = 0; i < ships.size(); i++){
            if(xLoc == ships.get(i).getxLoc() && yLoc == ships.get(i).getyLoc()) shipsAtLoc.add(ships.get(i));
        }
        return shipsAtLoc;
    }

    public boolean isMasterShipAt(int xLoc, int yLoc){
        return master.getxLoc() == xLoc && master.getyLoc() == yLoc;
    }

    public List<Square> getNeighboursFor(int xLoc, int yLoc){
        List<Square> neighbors = new ArrayList<>();

        if(xLoc == -1 || yLoc == -1){
            neighbors.add(grid.get(0).get(0));
            return neighbors;
        }


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

    public void moveMasterShip(int xLoc, int yLoc){
        // check whether the ship is being moved to a valid neighborhood square
        boolean movable = isMovableTo(master.getxLoc(), master.getyLoc(), xLoc, yLoc);
        if(!movable) return;

        master.setxLoc(xLoc);
        master.setyLoc(yLoc);
    }

    private boolean isMovableTo(int currentX, int currentY, int newX, int newY){
        List<Square> neighborhoods = getNeighboursFor(currentX, currentY);
        boolean found = false;
        for (int i = 0; i < neighborhoods.size(); i++){
            if(neighborhoods.get(i).getxLoc() == newX
                    && neighborhoods.get(i).getyLoc() == newY){
                found = true;
                break;
            }
        }
        return found;
    }


    public void moveShip(EnemyShip ship, int xLoc, int yLoc){

        if(ship == null) return;

        // check whether the ship is being moved to a valid neighborhood square
        boolean movable = isMovableTo(ship.getxLoc(), ship.getyLoc(), xLoc, yLoc);
        if(!movable) return;

        int pos = ships.indexOf(ship);

        ship.setxLoc(xLoc);
        ship.setyLoc(yLoc);
        if(pos != -1){
            ships.set(pos, ship);
        } else {
            ships.add(ship);
        }

    }

    public List<List<Square>> getGrid() {
        return grid;
    }

    @Override
    public String toString() {
        return "Grid{" +
                "master=" + master +
                ", ships=" + ships +
                '}';
    }

    public MasterShip getMasterShip() {
        return master;
    }
}
