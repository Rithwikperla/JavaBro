/* Uses actions with a tool bar and a menu. */

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class jtoolbar extends JFrame {
    protected JTextArea textArea;
    protected String newline = "\n";
    protected Action leftAction;
    protected Action middleAction;
    protected Action rightAction;

    public jtoolbar() {
        //Do frame stuff.
        super("ActionDemo");
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //Create the toolbar and menu.
        JToolBar toolBar = new JToolBar();
        JMenu mainMenu = new JMenu("Menu");
        createActionComponents(toolBar, mainMenu);

        //Create the text area used for output.
        textArea = new JTextArea(5, 30);
        JScrollPane scrollPane = new JScrollPane(textArea);

        //Lay out the content pane.
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        contentPane.setPreferredSize(new Dimension(400, 150));
        contentPane.add(toolBar, BorderLayout.SOUTH);
        contentPane.add(scrollPane, BorderLayout.CENTER);
        setContentPane(contentPane);

        //Set up the menu bar.
        JMenuBar mb = new JMenuBar();
        mb.add(mainMenu);
        mb.add(createAbleMenu());
        setJMenuBar(mb);
    }

    protected void createActionComponents(JToolBar toolBar,
                                          JMenu mainMenu) {
        JButton button = null;
        JMenuItem menuItem = null;

        //first button and menu item
        leftAction = new AbstractAction("Go left", 
                             new ImageIcon("e:/3.jpg")) {
            public void actionPerformed(ActionEvent e) {
                displayResult("Action for first button/menu item", e);
            }
        };
        button = toolBar.add(leftAction);
        button.setText(""); //an icon-only button
        button.setToolTipText("This is the left button");
        menuItem = mainMenu.add(leftAction);
        menuItem.setIcon(null); //arbitrarily chose not to use icon in menu

        //second button and menu item
        middleAction = new AbstractAction("Do something", 
                             new ImageIcon("e:/1.jpg")) {
            public void actionPerformed(ActionEvent e) {
                displayResult("Action for second button/menu item", e);
            }
        };
        button = toolBar.add(middleAction);
        button.setText("");
        button.setToolTipText("This is the middle button");
        menuItem = mainMenu.add(middleAction);
        menuItem.setIcon(null); //arbitrarily chose not to use icon in menu

        //third button and menu item
        rightAction = new AbstractAction("Go right", 
                             new ImageIcon("e:/2.jpg")) {
            public void actionPerformed(ActionEvent e) {
                displayResult("Action for third button/menu item", e);
            }
        };
        button = toolBar.add(rightAction);
        button.setText("");
        button.setToolTipText("This is the right button");
        menuItem = mainMenu.add(rightAction);
        menuItem.setIcon(null); //arbitrarily chose not to use icon in menu
    }

    protected JMenu createAbleMenu() {
        JMenu ableMenu = new JMenu("Action State");
        JCheckBoxMenuItem cbmi = null;

        cbmi = new JCheckBoxMenuItem("First action enabled");
        cbmi.setSelected(true);
        cbmi.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                JCheckBoxMenuItem mi = (JCheckBoxMenuItem)(e.getSource());
                boolean selected =
                    (e.getStateChange() == ItemEvent.SELECTED);
                leftAction.setEnabled(selected);
            }
        });
        ableMenu.add(cbmi);

        cbmi = new JCheckBoxMenuItem("Second action enabled");
        cbmi.setSelected(true);
        cbmi.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                JCheckBoxMenuItem mi = (JCheckBoxMenuItem)(e.getSource());
                boolean selected = 
                    (e.getStateChange() == ItemEvent.SELECTED);
                middleAction.setEnabled(selected);
            }
        });
        ableMenu.add(cbmi);

        cbmi = new JCheckBoxMenuItem("Third action enabled");
        cbmi.setSelected(true);
        cbmi.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                JCheckBoxMenuItem mi =
                    (JCheckBoxMenuItem)(e.getSource());
                boolean selected =
                    (e.getStateChange() == ItemEvent.SELECTED);
                rightAction.setEnabled(selected);
            }
        });
        ableMenu.add(cbmi);

        return ableMenu;
    }

    protected void displayResult(String actionDescription,
                                 ActionEvent e) {
        String s = ("Action event detected by: "
                  + actionDescription 
                  );
        textArea.append(s);
    }

    public static void main(String[] args) {
        jtoolbar frame = new jtoolbar();
        frame.pack();
        frame.setVisible(true);
    }
}