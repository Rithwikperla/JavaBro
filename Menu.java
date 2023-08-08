import javax.swing.*;

public class menuexample{
    JMenu menu,submenu;
    JFrame frame;
    JMenuItem i1,i2,i3,i4;
    JMenuBar menubar;

    menuexample(){
        menu = new JMenu("Menu");
        submenu = new JMenu("submenu");
        frame = new JFrame("Menu");
        menubar = new JMenuBar();
        i1 = new JMenuItem("Item 1");
        i2 = new JMenuItem("Item 2");
        i3 = new JMenuItem("Item 3");
        i4 = new JMenuItem("Item 4");
        menu.add(i1);
        menu.add(i2);
        menu.add(i3);
        menu.add(submenu);
        submenu.add(i4);

    }
    public static void main(String args[]){
        new menuexample();
    }
}