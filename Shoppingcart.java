import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class Item{
    int item_id;
    String item_name;
    String item_type;
    int quantity;
    float item_price;
    Item()
    {   
        item_id = 0;
        item_name = "none";
        item_type = "none";
        quantity = 0;
        item_price = 0;
    }
    Item(int id,String name,String type,int qt,float cost)
    {
        item_id = id;
        item_name = name;
        item_type = type;
        quantity = qt;
        item_price = cost; 
    }

    public String toString()
    {
        return ("Item id: " + item_id + "item name: " + item_name + "item type: " + item_type + "Quantity: " +  quantity + "item price: " + item_price );
    }
}
class  inventory{
    Item[] arr = new Item[5];
    inventory(){ 
        arr[0] = new Item(102, "Sugar","Grocery",100,10.2f);
        arr[1] = new Item(1004,"Salt","Grocery",100,10.0f);
        arr[2] = new Item(1006,"Phone","Grocery",150,100.0f);
        arr[3] = new Item(1008,"TV","Grocery",10,52500.0f);
        arr[4] = new Item(1010,"RC car","Grocery",999,12.0f);
    }
    public Item[] ViewAllitem()
    {
        return arr;
    }
    public float calculateTotal(){
        float total = 0;
        for(int i = 0;i<5;i++){
            total = total + arr[i].item_price;
        }
        return total;
    }
    public void updateItemQuantity(int id,int qty){
        for(int i =0;i<5;i++){
            if(arr[i].item_id == id )
            {
                arr[i].quantity = qty;
            }
        }
    }
    public void RemoveItem(int id)
    {
        for(int i =0;i<5;i++){
            if(arr[i].item_id == id )
            {
                arr[i].item_id = -1;
            }
        }
    }
}
class Shoppingcart implements ActionListener{
    int cart_id;
    float total_price;
    JLabel showItemId,ShowQuantity;
    JTextField input_itemid;
    JTextField input_quantity;
    JButton Viewcart,UpdateQuantity,Removeitem;
    JTextArea showitems;
    JFrame frame;
    public Shoppingcart()
    {
        
        frame = new JFrame("Shopping Cart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setLayout(null);

        showItemId = new JLabel("Item id");
        showItemId.setBounds(50,25,50,40);
        frame.add(showItemId);

        ShowQuantity = new JLabel("Quantity");
        ShowQuantity.setBounds(50,50,50,40);
        frame.add(ShowQuantity);

        input_itemid = new JTextField();
        input_itemid.setBounds(125,25,75,25);
        frame.add(input_itemid);

        input_quantity = new JTextField();
        input_quantity.setBounds(125,50,75,25);
        frame.add(input_quantity);

        Viewcart = new JButton("view cart");
        Viewcart.setBounds(50,100,100,30);
        frame.add(Viewcart);
        Viewcart.addActionListener(this);
        
        UpdateQuantity = new JButton("Update");
        UpdateQuantity.setBounds(175,100,100,30);
        frame.add(UpdateQuantity);
        UpdateQuantity.addActionListener(this);

        Removeitem = new JButton("Remove");
        Removeitem.setBounds(100,150,100,30);
        frame.add(Removeitem);
        Removeitem.addActionListener(this);

        showitems = new JTextArea();
        showitems.setBounds(300,50,200,150);
        frame.add(showitems);
        
    }
        inventory stock = new inventory();
        public static void main(String args[]){
        Shoppingcart sh = new Shoppingcart();
        
        }
        
        public void actionPerformed(ActionEvent e){
            
            if(e.getSource() == Viewcart )    
            {
                for (Item i:stock.ViewAllitem()){
                showitems.append(Integer.valueOf(i.item_id).toString()+ "  " + i.item_name + "  " + i.item_type + "  " + "  " + i.quantity + "  " + i.item_price + "\n");}

            }
            if(e.getSource() == UpdateQuantity){
                int id = Integer.parseInt(input_itemid.getText());
                int entered_qt = Integer.parseInt(input_quantity.getText());
                showitems.setText(" ");
                
               for (Item i:stock.ViewAllitem()){
                   if(i.item_id == id)
                   {
                       stock.updateItemQuantity(id, entered_qt);
                   }
                
               }
               for (Item i:stock.ViewAllitem()){
                showitems.append(Integer.valueOf(i.item_id).toString()+ "  " + i.item_name + "  " + i.item_type + "  " + "  " + i.quantity + "  " + i.item_price + "\n");}
               
            }
            if(e.getSource() == Removeitem){
                int id = Integer.parseInt(input_itemid.getText());
                showitems.setText(" ");
                for (Item i:stock.ViewAllitem()){
                   if(i.item_id == id)
                   {
                       stock.RemoveItem(id);
                   }
                
               }
               for (Item i:stock.ViewAllitem()){
                    showitems.append(Integer.valueOf(i.item_id).toString()+ "  " + i.item_name + "  " + i.item_type + "  " + "  " + i.quantity + "  " + i.item_price + "\n");}
               
            }       
    }  
    }
    