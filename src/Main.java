import model.Grid;

public class Main {

    public static void main(String[] args) {
        Grid grid = new Grid();
        System.out.println();
        System.out.println();
        System.out.println(grid.getNeighboursFor(1,1));
    }
}
