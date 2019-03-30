package viewmodel;

import model.EnemyShip;
import model.Grid;
import model.Square;
import rx.MutableObservable;
import rx.Observable;

import java.util.List;

public class GameViewModel {

    private MutableObservable<Grid> grid = new MutableObservable<>();
    private MutableObservable<Boolean> masterWins = new MutableObservable<>();
    private MutableObservable<Boolean> enemyWins = new MutableObservable<>();

    public GameViewModel() {
        start();
    }

    public Observable<Grid> getGrid() {
        return grid;
    }

    public Observable<Boolean> getMasterWins() {
        return masterWins;
    }

    public void addBattleShooter() {
        Grid g = grid.getValue();

        g.moveShip(EnemyShip.BATTLE_SHOOTER, 0, 0);

        grid.setValue(g);
        masterHasWon();
    }

    private void masterHasWon(){
        masterWins.setValue(true);
    }

    public void restartGame(){
        start();
    }

    private void start(){
        this.grid.setValue(new Grid());
    }
}
