package ui;

import model.Grid;
import viewmodel.GameViewModel;

import javax.swing.*;

public class GameView {

    private GameViewModel viewModel;
    public GameView() {
        viewModel = new GameViewModel();
    }

    public void init(){
        JFrame f = new JFrame();

        Grid grid =  new Grid();
        grid.creatEmptyGrid();

        JButton b = new JButton("click");//creating instance of JButton
        b.setBounds(130,100,100, 40);//x axis, y axis, width, height
        b.addActionListener(a -> {
            viewModel.addBattleShooter();
        });

        f.add(b);//adding button in JFrame

        f.setSize(400,500);//400 width and 500 height
        f.setLayout(null);//using no layout managers
        f.setVisible(true);//making the frame visible

        subscribeToViewModel();

    }

    private void subscribeToViewModel() {
        viewModel.getGrid().observe(grid -> {
            System.out.println(grid.toString());
        });

        viewModel.getMasterWins().observe(b -> {
            if(b != null && b){
                System.out.println("Yikes!! The master has won");
                // TODO Implement what to do when master wins
                // show message
                // end game
                // restart game
            }
        });
    }


}
