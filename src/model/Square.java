package model;

import java.util.ArrayList;

public class Square {

	private final int xLoc;
	private final int yLoc;
	ArrayList <EnemyShip> ships = new ArrayList<EnemyShip> ();
	MasterShip theMasterShip = null;
	int number;

	public Square(int xLoc, int yLoc) {
		this.xLoc = xLoc;
		this.yLoc = yLoc;
	}


	public ArrayList<EnemyShip> getShips() {
		return ships;
	}

	public int getxLoc() {
		return xLoc;
	}

	public int getyLoc() {
		return yLoc;
	}

	public MasterShip getTheMasterShip() {
		return theMasterShip;
	}

	@Override
	public String toString() {
		return "(" + xLoc + ", " + yLoc + ")";
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Square)) return false;

		Square square = (Square) obj;

		return xLoc == square.xLoc && yLoc == square.yLoc;
	}
}
