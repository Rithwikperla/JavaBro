//venkata sujan dasari
//regno 124003076
//question no 30

import java.util.* ;
import java.awt.* ;
import java.awt.event.* ;
import javax.swing.* ;

class Vehicle{
    //in class Vehicle it contains the basic deatails of a vehicle
    String regNo ;
    String vehicleType ;
    String vehicleMake ;
    String ownerContactNo ;
    int serviceCost ;

    //constructor to initialize the vehicle variables

    public Vehicle(String regNo, String vehicleType, String vehicleMake, String ownerContactNo, int serviceCost) {
        this.regNo = regNo;
        this.vehicleType = vehicleType;
        this.vehicleMake = vehicleMake;
        this.ownerContactNo = ownerContactNo;
        this.serviceCost = serviceCost;
    }

}
//class that handles the storage and retrival of the given data
class ServiceManagement{
    //private function to validate phone number
    private boolean validatePhNO(String phno){
        System.out.println(phno.length());
        return phno.length() == 10;
    }
    //search in tree set if the regno already exists
    public boolean search(String regNo, TreeSet<Vehicle> vehicleSet){
        for(Vehicle v : vehicleSet){
            if(v.regNo.equals(regNo)){
                return true;
            }
        }
        return false;
    }
    //declared treeset with a comparatror for price
    TreeSet<Vehicle> ts = new TreeSet<Vehicle>(new Comparator<Vehicle>() {
        public int compare(Vehicle v1, Vehicle v2) {
            return v1.serviceCost - v2.serviceCost;
        }
    });

    public void addVehicle(Vehicle v)throws Exception{
        //in addvehicle function it adds given object vehicle to the treeset and does validate the values
        try{
            if(v.regNo.length()<=0) {
                throw new Exception("register No should not be empty") ;
            }
            if(search(v.regNo,ts)){
                throw new Exception("Vehicle already exists");
            }

            if(!validatePhNO(v.ownerContactNo)){
                throw new Exception("Invalid Contact Number");
            }
            if(v.serviceCost <= 0){
                throw new Exception("Invalid Service Cost");
            }
            else {
                ts.add(v);
            }
        }catch(Exception e){
            throw new Exception(e.getMessage().toString());
        }
    }

    public int getServiceCost(String regNo) throws Exception {
        //search for the given vehicle regno and return the cost of the regristratoin if regno not found throw exception saying vehicle not found
        for(Vehicle v : ts) {
            if(Objects.equals(v.regNo, regNo)) {
                return v.serviceCost;
            }
        }
        throw new Exception("Vehicle not found");
    }

    public ArrayList<String> listAllVehicles() {
        //return a array list of string that contain all vehicle information
        ArrayList<String> al = new ArrayList<String>();
        for(Vehicle v : ts) {
            String str = "RegNo: "+v.regNo + "\n" +"Vehcile Type: "+ v.vehicleType + "\n" + "Vehicle Make"+v.vehicleMake+"\n"+"OwnerContactNo: "+v.ownerContactNo+"\n"+"ServiceCost: "+v.serviceCost;
            al.add(str);
        }
        return al;
    }
}
//the main gui of the program contains in theis class
class GUI extends JFrame implements ActionListener{
    //declare all swing components here
    JLabel lblRegNo, lblVehicleType, lblVehicleMake, lblOwnerContactNo, lblServiceCost;
    JTextField txtRegNo, txtVehicleMake, txtOwnerContactNo, txtServiceCost;
    JButton btnAddVehicle, btnGetServiceCost, btnListAllVehicles;
    JTextArea txtArea;
    JComboBox<String> cmbVehicleType;
    ServiceManagement sm = new ServiceManagement();
    JScrollPane scrolTxtArea ;
    GUI(){
        //set title for the frame
        setTitle("Vehicle Management");
        //set size for the frame
        setSize(700, 575);
        //set layout for the frame
        setLayout(null);
        //set close operation for the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set location for the frame
        setLocationRelativeTo(null);
        //set background color for the frame
        getContentPane().setBackground(Color.LIGHT_GRAY);
        //set font for the frame
        Font f = new Font(Font.SANS_SERIF, Font.PLAIN, 20);
        //string array for combobox
        String[] vehicleType = {"TwoWeeler", "FourWeeler"};


        //declare all swing components here
        lblRegNo = new JLabel("Registration Number");
        lblVehicleType = new JLabel("Vehicle Type");
        lblVehicleMake = new JLabel("Vehicle Make");
        lblOwnerContactNo = new JLabel("Owner Contact Number");
        lblServiceCost = new JLabel("Service Cost");
        txtRegNo = new JTextField();
        txtVehicleMake = new JTextField();
        txtOwnerContactNo = new JTextField();
        txtServiceCost = new JTextField();
        btnAddVehicle = new JButton("Add Vehicle");
        btnGetServiceCost = new JButton("Get Service Cost");
        btnListAllVehicles = new JButton("List All Vehicles");
        txtArea = new JTextArea();
        cmbVehicleType = new JComboBox<String>(vehicleType);

        //set font for all swing components here
        lblRegNo.setFont(f);
        lblVehicleType.setFont(f);
        lblVehicleMake.setFont(f);
        lblOwnerContactNo.setFont(f);
        lblServiceCost.setFont(f);
        txtRegNo.setFont(f);
        txtVehicleMake.setFont(f);
        txtOwnerContactNo.setFont(f);
        txtServiceCost.setFont(f);
        btnAddVehicle.setFont(f);
        btnGetServiceCost.setFont(f);
        btnListAllVehicles.setFont(f);
        txtArea.setFont(f);
        cmbVehicleType.setFont(f);
        //set bounds for all swing components here
        lblRegNo.setBounds(50, 50, 200, 30);
        lblVehicleType.setBounds(50, 100, 200, 30);
        lblVehicleMake.setBounds(50, 150, 200, 30);
        lblOwnerContactNo.setBounds(50, 200, 250, 30);
        lblServiceCost.setBounds(50, 250, 200, 30);
        txtRegNo.setBounds(400, 50, 200, 30);
        txtVehicleMake.setBounds(400, 150, 200, 30);
        txtOwnerContactNo.setBounds(400, 200, 200, 30);
        txtServiceCost.setBounds(400, 250, 200, 30);
        btnAddVehicle.setBounds(50, 300, 200, 30);
        btnGetServiceCost.setBounds(250, 300, 200, 30);
        btnListAllVehicles.setBounds(450, 300, 200, 30);
        txtArea.setBounds(50, 350, 500, 150);
        cmbVehicleType.setBounds(400, 100, 200, 30);
        //add all swing components here
        add(lblRegNo);
        add(lblVehicleType);
        add(lblVehicleMake);
        add(lblOwnerContactNo);
        add(lblServiceCost);
        add(txtRegNo);
        add(txtVehicleMake);
        add(txtOwnerContactNo);
        add(txtServiceCost);
        add(btnAddVehicle);
        add(btnGetServiceCost);
        add(btnListAllVehicles);
        add(txtArea);
        add(cmbVehicleType);
        //add action listener for all swing components here
        btnAddVehicle.addActionListener(this);
        btnGetServiceCost.addActionListener(this);
        btnListAllVehicles.addActionListener(this);
        //make text area scrollable
        txtArea.setLineWrap(true);
        scrolTxtArea = new JScrollPane(txtArea);
        scrolTxtArea.setBounds(50, 350, 600, 150);
        add(scrolTxtArea);
        //set visible for all swing components here
        setVisible(true);   
        //change the background color of JFrame
        getContentPane().setBackground(Color.CYAN);
        setResizable(false);
    }
    //action listener
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAddVehicle) {
            //get all values from text areas and create a object and send it to vehicle managment
            try {
                String regNo = txtRegNo.getText();
                String vehicleType = (String) cmbVehicleType.getSelectedItem();
                String vehicleMake = txtVehicleMake.getText();
                String ownerContactNo = txtOwnerContactNo.getText();
                int serviceCost = Integer.parseInt(txtServiceCost.getText());
                Vehicle v = new Vehicle(regNo, vehicleType, vehicleMake, ownerContactNo, serviceCost);
                sm.addVehicle(v);
                //show pop up if item added successfully
                JOptionPane.showMessageDialog(null, "Vehicle added successfully");
            }
            catch (Exception ex) {
                //show pop up if item not added successfully
                JOptionPane.showMessageDialog(null, ex.getMessage().toString());
            }
        }
        else if (e.getSource() == btnGetServiceCost) {
            try {
                //search the service cost by taking regno of the vehicle
                String regNo = (txtRegNo.getText());
                int serviceCost = sm.getServiceCost(regNo);
                txtArea.setText("Service Cost is " + serviceCost);
            }
            catch (Exception ex) {
                //show pop up if there is an exception
                JOptionPane.showMessageDialog(null, ex.getMessage().toString());
            }
        }
        //get info about all the vehicles
        else if (e.getSource() == btnListAllVehicles) {
            ArrayList<String> al = sm.listAllVehicles();
            txtArea.setText("");
            for (String v : al) {
                txtArea.append(v.toString() + "\n");
            }
        }
    }
}

//main class that contains the gui
public class vechicleManagment{
    public static void main(String[] args){
        GUI g = new GUI();
        g.setVisible(true);

    }
}