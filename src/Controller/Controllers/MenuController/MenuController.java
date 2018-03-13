package Controller.Controllers.MenuController;

import Controller.Controllers.Controller;
import View.MenuView.MainMenuView;
import View.MenuView.MenuViewPort;

public abstract class MenuController implements Controller {

    protected int selectedUpDown;
    protected int selectedRightLeft;

    protected MenuViewPort menuViewPort;

    public abstract void select();

    protected void setMenuViewPort(MenuViewPort menuViewPort){
        this.menuViewPort = menuViewPort;
    }

    public void scrollUp(){
        selectedUpDown -= 1;
        menuViewPort.scrollUp();
    }

    public void scrollDown(){
        selectedUpDown += 1;
        menuViewPort.scrollDown();
    }

    public void scrollLeft(){
        selectedRightLeft -= 1;
        menuViewPort.scrollLeft();
    }

    public void scrollRight(){
        selectedRightLeft += 1;
        menuViewPort.scrollRight();
    }

    @Override
    public void setActive() {
        menuViewPort.setVisible(true);
        menuViewPort.requestFocus();
    }
}
