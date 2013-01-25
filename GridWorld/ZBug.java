import info.gridworld.actor.Bug;
import java.awt.Color;
import info.gridworld.grid.Location;

public class ZBug extends Bug {
  
  private int sideLength;
  private int part;
  private int currentStep;
  
  public ZBug(int sidelength) {
    sideLength = sidelength;
    part = 1;
    currentStep = 0;
    this.setDirection(Location.EAST);
    this.setColor(Color.YELLOW);
  }
  
  public ZBug() {
    sideLength = 3;
    part = 1;
    currentStep = 0;
    this.setDirection(Location.EAST);
    this.setColor(Color.YELLOW);
  }
  
  public void act() {
    if (this.canMove() && part <= 3 && currentStep < sideLength) {
      move();
      currentStep++;
    } else if (part == 1) {
      this.setDirection(Location.SOUTHWEST);
      currentStep = 0;
      part++;
    } else if (part == 2) {
      this.setDirection(Location.EAST);
      currentStep = 0;
      part++;
    } else {
      if (this.canMove())
        move();
      this.removeSelfFromGrid();
    }
  }
}