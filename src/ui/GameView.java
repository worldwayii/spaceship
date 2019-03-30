package ui;

import model.Grid;
import model.MasterShip;
import model.Square;
import viewmodel.GameViewModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class GameView {

    private GameViewModel viewModel;
    private JPanel mPanel;
    private JFrame mainFrame;
    private List<List<JPanel>> mSquares = new ArrayList<>();

    public GameView() {
        viewModel = new GameViewModel();
    }

    public void init(){
        mainFrame = new JFrame();

        viewModel.getGrid();


        mainFrame.setSize(500, 500);

        mPanel = new JPanel();
        mPanel.setSize(500, 500);
        GridLayout gridLayout = new GridLayout(Grid.GRID_SIZE, Grid.GRID_SIZE);
        mPanel.setLayout(gridLayout);

        for(int i = 0; i < Grid.GRID_SIZE; i++){
            List<JPanel> row = new ArrayList<>();
            for(int j = 0; j < Grid.GRID_SIZE; j++){
                JPanel square = new JPanel();
                square.setSize(new Dimension(120, 120));
                square.setLayout(new FlowLayout());

                if ((i + j) % 2 == 0) {
                    square.setBackground(Color.white);
                } else {
                    square.setBackground(Color.orange);
                }

                row.add(square);
                mPanel.add(square);

            }
            mSquares.add(row);
        }

        mainFrame.add(mPanel);//adding button in JFrame
        mainFrame.setVisible(true);
        subscribeToViewModel();

    }


    private void subscribeToViewModel() {
        viewModel.getGrid().observe(grid -> {
            if(grid == null) return;
            
            List<List<Square>> squares = grid.getGrid();
            MasterShip master = grid.getMasterShip();

            for(int i = 0; i < squares.size(); i++){
                for(int j = 0; j < squares.get(i).size(); j++){
                    JPanel square = mSquares.get(i).get(j);
                    square.removeAll();

                    if(master.getxLoc() == i && master.getyLoc() == j){
                        System.out.println("Master at: " + squares.get(i).get(j));
                        square.removeAll();
                        square.setLayout(new FlowLayout());

                        String path = "images/mastership.png";
                        // File file = new File(path);

                        ImageJPanel imageJPanel = new ImageJPanel();
                        imageJPanel.setImagePath(path);
                        imageJPanel.setBackground(new Color(0f,0f,0f,0f ));

                        square.add(imageJPanel);
                        square.revalidate();
                        square.repaint();
                    }
                }
                //mainFrame.revalidate();
                // mainFrame.setVisible(true);

            }


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
