import javax.swing.JLabel;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class GameObject extends JLabel{
    protected boolean interactable;
    protected BufferedImage image;
    protected int x;
    protected int y;
    protected boolean isVisible;

    public GameObject(int x, int y, boolean interactable, boolean isVisible){
        this.interactable = interactable;
        this.isVisible = isVisible;
        this.x = x;
        this. y = y;
        this.setLocation(x,y);
        
    }

  public abstract void update();
  public abstract void interact();

  public void render(Graphics g){
        if(isVisible && image != null){
            g.drawImage(image,x,y, null);
        }
  }

 public boolean hasCollidedWith(GameObject other) {
        // TODO implement collision detection here
        if(this.getX() <= other.getX() + other.getWidth()){//left of hero right of obj
            return true;
        }
        if(this.getX() + this.getWidth() >= other.getX() ){//right of hero left of obj
            return true;
        }
        if(this.getY() <= other.getY() + other.getHeight()){//up of hero down of obj
            return true;
        }
        if(this.getY() + this.getHeight() >= other.getY() ){//down of hero up of obj
            return true;
        }
        return false;
    }

public boolean getInteractable(){
    return interactable;
}
public boolean getVisibility(){
    return isVisible;
}



    
}
