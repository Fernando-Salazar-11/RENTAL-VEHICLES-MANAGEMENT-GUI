
package proyecto.pkgfinal;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import javax.swing.JFrame;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Ventana extends JFrame{   
    private JList listaNombres;
    private JList listaNombres2;
    private JList listaNombres3;
    private JList listaClientes;
    private JList listaRentados;
    private DefaultListModel modelo;
    private DefaultListModel modelo1;
    private DefaultListModel modelo2;
    private DefaultListModel modelo3;
    private DefaultListModel modelo4;
    private JButton cliente;
    private JButton rentar;
    private JButton recibir;
    private JButton mantenimiento;
    private JMenuBar menu;
    private JMenu reportes;
    private JMenu look;
    private JMenuItem reporte;
    private JMenuItem color1;
    private JMenuItem color2;
    private JMenuItem color3;
    private JMenuItem color4;
    private JMenuItem color5;
    
    ArrayList<Cliente> clientes = new ArrayList<>();
    ArrayList<Familiar> familiares = new ArrayList<>();
    ArrayList<Camioneta> camionetass = new ArrayList<>();
    ArrayList<Deportivo> deportivos = new ArrayList<>();
    
        
    public Ventana(){ 
       try{
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
       Familiar[] autosFamiliares = new Familiar[3]; 
       autosFamiliares = crearAutosFamiliares();
       
       Camioneta[] camionetas = new Camioneta[3];
       camionetas = crearCamionetas();
       
       Deportivo [] autosDeportivos = new Deportivo[3];
       autosDeportivos = crearDeportivos();       
       
        
       JPanel panelListas = new JPanel(new GridLayout(1, 4, 10, 10)); // Panel para las listas
       JPanel panelBotones = new JPanel(new GridLayout(1, 4, 10, 10));
       JPanel panel = new JPanel(new GridLayout(3, 3, 10, 10));
        
       modelo = new DefaultListModel();
       modelo1 = new DefaultListModel();
       modelo2 = new DefaultListModel();
       modelo3 = new DefaultListModel();
       modelo4 = new DefaultListModel();
       listaNombres = new JList (modelo);
       listaNombres2 = new JList (modelo1);
       listaNombres3 = new JList (modelo2);  
       listaClientes = new JList (modelo3);
       listaRentados = new JList (modelo4);
       cliente = new JButton ("Agregar nuevo cliente");
       rentar = new JButton ("Rentar");
       recibir = new JButton ("Recibir");
       mantenimiento  = new JButton ("Mantenimiento");
       menu = new JMenuBar();
       reportes = new JMenu("Reportes");
       look = new JMenu("Diseño");
       reporte = new JMenuItem("Generar reporte de rentas");
       color1 = new JMenuItem("Rojo");
       color2 = new JMenuItem("Azul");
       color3 = new JMenuItem("Rosa");
       color4 = new JMenuItem("Verde");
       color5 = new JMenuItem("Gris");
       
       reportes.add(reporte);
       look.add(color1);
       look.add(color1);
       look.add(color2);
       look.add(color3);
       look.add(color4);
       look.add(color5);
       menu.add(reportes);
       menu.add(look);
       
       modelo.addElement("Autos Familiares");
       for (int i = 0; i < autosFamiliares.length; i++){
           String marca = autosFamiliares[i].getMarca();
           String modeloAuto = autosFamiliares[i].getModelo();
           modelo.addElement(marca + " " + modeloAuto); 
           familiares.add(autosFamiliares[i]);
       }
       
       modelo1.addElement("Camionetas");
       for (int i = 0; i < camionetas.length; i++){
           String marca = camionetas[i].getMarca();
           String modeloAuto = camionetas[i].getModelo();
           modelo1.addElement(marca + " " + modeloAuto);
           camionetass.add(camionetas[i]);
       }
       
       modelo2.addElement("Autos Deportivos");
       for (int i = 0; i < autosDeportivos.length; i++){
           String marca = autosDeportivos[i].getMarca();
           String modeloAuto = autosDeportivos[i].getModelo();
           modelo2.addElement(marca + " " + modeloAuto);
           deportivos.add(autosDeportivos[i]);
       }
       
       modelo3.addElement("Clientes");
       modelo4.addElement("Autos Rentados");
       
       panelListas.add(new JScrollPane(listaNombres));
       panelListas.add(new JScrollPane(listaNombres2));
       panelListas.add(new JScrollPane(listaNombres3));
       panelListas.add(new JScrollPane(listaClientes));
              
       panelBotones.add(cliente);
       panelBotones.add(recibir);
       panelBotones.add(mantenimiento);
       panelBotones.add(rentar);
       
       panel.add(menu);
       panel.add(panelListas);
       panel.add(listaRentados);
       panel.add(panelBotones);       
       
        setContentPane(panel);
       
       
        
        ActionListener nuevoCliente = new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               try{
               String nombre = JOptionPane.showInputDialog("Ingrese el nombre:");
               String telefono = JOptionPane.showInputDialog("Ingrese el teléfono:");
               String correo = JOptionPane.showInputDialog("Ingrese el correo:");
               clientes.add(new Cliente(nombre, correo, Long.parseLong(telefono)));
               String cliente = clientes.getLast().getNombre();
               modelo3.addElement(cliente);  
               }
               catch(Exception err){
                    JOptionPane.showMessageDialog(null, err.getMessage());
                }
           }
        };
        cliente.addActionListener(nuevoCliente);
        
        ActionListener rentarAuto = new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               try{
               if(! listaNombres.isSelectionEmpty()){
                   rentarFamiliar();                     
               }
               if(! listaNombres2.isSelectionEmpty()){
                   rentarCamioneta();
                                    
               }
               if(! listaNombres3.isSelectionEmpty()){
                   rentarDeportivo();
               }   
               }
               catch(Exception err){
                    JOptionPane.showMessageDialog(null, err.getMessage());
                }
           }
        };
        rentar.addActionListener(rentarAuto);
        
        ActionListener darMantenimiento = new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               try{
               if(! listaRentados.isSelectionEmpty()){
                   JOptionPane.showMessageDialog(null, "No se puede dar mantenimiento"
                           + " a un auto no recibido");
                   listaRentados.clearSelection();
               }
               else{
                   if(! listaNombres.isSelectionEmpty()){
                        mantenimietoFamiliar();
                        listaNombres.clearSelection();
                        listaClientes.clearSelection();
                    }
                    if(! listaNombres2.isSelectionEmpty()){
                        mantenimietoCamionetas();
                        listaNombres2.clearSelection();
                        listaClientes.clearSelection();
                    }
                    if(! listaNombres3.isSelectionEmpty()){
                        mantenimietoDeportivos();
                        listaNombres3.clearSelection();
                        listaClientes.clearSelection();
                    } 
               }
               
           }
               catch(Exception err){
                    JOptionPane.showMessageDialog(null, err.getMessage());
                }
           }
        };
        mantenimiento.addActionListener(darMantenimiento);  
        
        ActionListener recibirAuto = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
            if (!listaRentados.isSelectionEmpty()) {
                String seleccionado = (String) listaRentados.getSelectedValue();

                // Buscar y actualizar el auto en la lista de familiares
                for (Familiar familiar : familiares) {
                    String descripcion = familiar.getMarca() + " " + familiar.getModelo();
                    if (seleccionado.contains(descripcion)) {
                        familiar.recibir(familiar);
                        break;
                    }
                }

                // Buscar y actualizar el auto en la lista de camionetas
                for (Camioneta camioneta : camionetass) {
                    String descripcion = camioneta.getMarca() + " " + camioneta.getModelo();
                    if (seleccionado.contains(descripcion)) {
                        camioneta.recibir(camioneta);
                        break;
                    }
                }

                // Buscar y actualizar el auto en la lista de deportivos
                for (Deportivo deportivo : deportivos) {
                    String descripcion = deportivo.getMarca() + " " + deportivo.getModelo();
                    if (seleccionado.contains(descripcion)) {
                        deportivo.recibir(deportivo);
                        break;
                    }
                }
                // Remover el auto de la lista de autos rentados
                modelo4.removeElement(seleccionado);
                listaRentados.clearSelection();
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un auto rentado para recibir.");
                }   
            }
            catch(Exception err){
                    JOptionPane.showMessageDialog(null, err.getMessage());
                }
        }
            
        };
        recibir.addActionListener(recibirAuto);
        
        ActionListener generarReporte = new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               try{
                   File file = new File("Reporte.txt");
                    if (!file.exists()){
                        file.createNewFile();
                    }
                    
                    //Agrega toString() en las clases
                    
                    FileOutputStream fos = new FileOutputStream(file, true);//true para no perder datos
                    ObjectOutputStream escribir = new ObjectOutputStream(fos);
                    
                    for(int i = 0; i < familiares.size(); i++){
                        if (familiares.get(i).isDisponivilidad() == false){
                            Familiar coche = familiares.get(i);
                            escribir.writeObject(coche.toString(coche));
                        }
                    }     
                    
                    for(int i = 0; i < camionetass.size(); i++){
                        if (camionetass.get(i).isDisponivilidad() == false){
                            Camioneta coche = camionetass.get(i);
                            escribir.writeObject(coche.toString(coche));
                        }
                    }  
                    
                    for(int i = 0; i < deportivos.size(); i++){
                        if (deportivos.get(i).isDisponivilidad() == false){
                            Deportivo coche = deportivos.get(i);
                            escribir.writeObject(coche.toString(coche));
                        }
                    }                 
                    
                    escribir.close();
                    fos.close();
                    JOptionPane.showMessageDialog(null, "Reporte en binario generado");
               }
               catch(Exception err){
                   JOptionPane.showMessageDialog(null, "Error\n" +
                           err.getMessage());
               }
           }
        };
        reporte.addActionListener(generarReporte);
        
        ActionListener colores = new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               try{
               if(e.getSource() == color1){
                   cambiarRojo();
               }
               if(e.getSource() == color2){
                   cambiarAzul();
               }
               if(e.getSource() == color3){
                   cambiarRosa();
               }
               if(e.getSource() == color4){
                   cambiarVerde();
               }
               if(e.getSource() == color5){
                   cambiarGris();
               }
           }
               catch(Exception err){
                    JOptionPane.showMessageDialog(null, err.getMessage());
                }
           }
           
        };
        color1.addActionListener(colores);
        color2.addActionListener(colores);
        color3.addActionListener(colores);
        color4.addActionListener(colores);
        color5.addActionListener(colores);
           
        ListSelectionListener selecccionDeListas = new ListSelectionListener() {
           @Override
           public void valueChanged(ListSelectionEvent e) {
               try{
               if(! e.getValueIsAdjusting()){
                    if(e.getSource() == listaNombres){
                        listaNombres2.clearSelection();
                        listaNombres3.clearSelection();
                        listaRentados.clearSelection();
                    }
                    if(e.getSource() == listaNombres2){
                        listaNombres.clearSelection();
                        listaNombres3.clearSelection();
                        listaRentados.clearSelection();

                    }
                    if(e.getSource() == listaNombres3){
                        listaNombres2.clearSelection();
                        listaNombres.clearSelection();
                        listaRentados.clearSelection();
                    }    
                    if(e.getSource() == listaRentados){
                        listaNombres.clearSelection();
                        listaNombres2.clearSelection();
                        listaNombres3.clearSelection();
                    }
               }               
               }
               catch(Exception err){
                    JOptionPane.showMessageDialog(null, err.getMessage());
                }
           }
       };
       listaNombres.addListSelectionListener(selecccionDeListas);
       listaNombres2.addListSelectionListener(selecccionDeListas);
       listaNombres3.addListSelectionListener(selecccionDeListas);
       listaRentados.addListSelectionListener(selecccionDeListas);
       
       } 
       catch(Exception e){
           JOptionPane.showMessageDialog(null, e.getMessage());
       }
    }
    
    
    
    public void rentarFamiliar(){
        try{
        int index;
        if(listaNombres.isSelectionEmpty() == false){
            if(listaClientes.isSelectionEmpty() == false){
                index = listaNombres.getSelectedIndex() - 1;
                if(familiares.get(index).isDisponivilidad() == false){
                    JOptionPane.showMessageDialog(null, "Auto ya rentado");
                    listaNombres.clearSelection();
                }
                else{
                    Familiar rentado = familiares.get(index);
                    //familiares.get(index).rentar(rentado); 
                    if (!rentado.rentar(rentado)){
                        JOptionPane.showMessageDialog(null, "No se puede rentar\n"
                        + "El vehiculo necesita mantenimiento");
                        listaNombres.clearSelection();
                        listaClientes.clearSelection();
                    }
                    else{
                        int cl = listaClientes.getSelectedIndex()-1;                    
                        String cliente = clientes.get(cl).getNombre();  
                        String auto = rentado.getMarca() + " " + rentado.getModelo();                  
                        modelo4.addElement(auto + " rentado por " + cliente); 
                        //familiares.get(index).setCliente(clientes.get(cl)); 
                        rentado.setCliente(clientes.get(cl));
                        listaNombres.clearSelection();
                        listaClientes.clearSelection();
                    }
                                        
                }                         
            }
                else{
                    JOptionPane.showMessageDialog(null, "Elija un cliente");
               }
        }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }    
    
    public void rentarCamioneta(){
        try{
        int index;
        if(listaNombres2.isSelectionEmpty() == false){
            if(listaClientes.isSelectionEmpty() == false){
                index = listaNombres2.getSelectedIndex() - 1;
                if(camionetass.get(index).isDisponivilidad() == false){
                    JOptionPane.showMessageDialog(null, "Auto ya rentado");
                    listaNombres2.clearSelection();
                }
                else{
                    Camioneta rentado = camionetass.get(index);
                    if (!rentado.rentar(rentado)){
                        JOptionPane.showMessageDialog(null, "No se puede rentar\n"
                        + "El vehiculo necesita mantenimiento");
                        listaNombres2.clearSelection();
                        listaClientes.clearSelection();
                    }
                    else{
                        int cl = listaClientes.getSelectedIndex()-1;                    
                        String auto = rentado.getMarca() + " " + rentado.getModelo();
                        String cliente = clientes.get(cl).getNombre();                    
                        modelo4.addElement(auto + " rentado por " + cliente); 
                        rentado.setCliente(clientes.get(cl)); 
                        listaNombres2.clearSelection();
                        listaClientes.clearSelection();
                    }
                                                
                }                         
            }
                else{
                    JOptionPane.showMessageDialog(null, "Elija un cliente");
               }
        }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void rentarDeportivo(){
        try{
        int index;
        if(listaNombres3.isSelectionEmpty() == false){
            if(listaClientes.isSelectionEmpty() == false){
                index = listaNombres3.getSelectedIndex() - 1;
                if(deportivos.get(index).isDisponivilidad() == false){
                    JOptionPane.showMessageDialog(null, "Auto ya rentado");
                    listaNombres3.clearSelection();
                }
                else{
                    Deportivo rentado = deportivos.get(index);
                    if (!rentado.rentar(rentado)){
                        JOptionPane.showMessageDialog(null, "No se puede rentar\n"
                        + "El vehiculo necesita mantenimiento");
                        listaNombres3.clearSelection();
                        listaClientes.clearSelection();
                    }
                    else{
                        int cl = listaClientes.getSelectedIndex()-1;                    
                        String auto = rentado.getMarca() + " " + rentado.getModelo();
                        String cliente = clientes.get(cl).getNombre();                    
                        modelo4.addElement(auto + " rentado por " + cliente); 
                        rentado.setCliente(clientes.get(cl)); 
                        listaNombres3.clearSelection();
                        listaClientes.clearSelection();
                    }
                                                
                }                         
            }
                else{
                    JOptionPane.showMessageDialog(null, "Elija un cliente");
               }
        }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    
    
    public void mantenimietoFamiliar(){
        try{
        int index = listaNombres.getSelectedIndex() - 1;
        Familiar mantenimiento = familiares.get(index);
        if(!mantenimiento.isDisponivilidad()){
            JOptionPane.showMessageDialog(null, "No se puede dar mantenimiento \n"
                    + "Auto rentado");
            listaNombres.clearSelection();
        }
        else{
            mantenimiento.darMantenimieto(mantenimiento); 
            JOptionPane.showMessageDialog(null, "Mantenimiento realizado exitosamente");
        } 
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void mantenimietoCamionetas(){
        try{
        int index = listaNombres2.getSelectedIndex() - 1;
        Camioneta mantenimiento = camionetass.get(index);
        if(!mantenimiento.isDisponivilidad()){
            JOptionPane.showMessageDialog(null, "No se puede dar mantenimiento \n"
                    + "Auto rentado");
            listaNombres2.clearSelection();
        }
        else{
            mantenimiento.darMantenimieto(mantenimiento);               
        }    
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void mantenimietoDeportivos(){
        try{
        int index = listaNombres3.getSelectedIndex() - 1;
        Deportivo mantenimiento = deportivos.get(index);
        if(!mantenimiento.isDisponivilidad()){
            JOptionPane.showMessageDialog(null, "No se puede dar mantenimiento \n"
                    + "Auto rentado");
            listaNombres3.clearSelection();
        }
        else{
            mantenimiento.darMantenimieto(mantenimiento);               
        }   
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void cambiarRojo(){
        try{
        listaNombres.setBackground(Color.red);
        listaNombres2.setBackground(Color.red);
        listaNombres3.setBackground(Color.red);
        listaClientes.setBackground(Color.red);
        listaRentados.setBackground(Color.red);
        cliente.setBackground(Color.red);
        rentar.setBackground(Color.red);
        recibir.setBackground(Color.red);
        mantenimiento.setBackground(Color.red);
        menu.setBackground(Color.red);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void cambiarAzul(){
        try{
        listaNombres.setBackground(Color.BLUE);
        listaNombres2.setBackground(Color.BLUE);
        listaNombres3.setBackground(Color.BLUE);
        listaClientes.setBackground(Color.BLUE);
        listaRentados.setBackground(Color.BLUE);
        cliente.setBackground(Color.BLUE);
        rentar.setBackground(Color.BLUE);
        recibir.setBackground(Color.BLUE);
        mantenimiento.setBackground(Color.BLUE);
        menu.setBackground(Color.BLUE);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void cambiarRosa(){
        try{
        listaNombres.setBackground(Color.pink);
        listaNombres2.setBackground(Color.pink);
        listaNombres3.setBackground(Color.pink);
        listaClientes.setBackground(Color.pink);
        listaRentados.setBackground(Color.pink);
        cliente.setBackground(Color.pink);
        rentar.setBackground(Color.pink);
        recibir.setBackground(Color.pink);
        mantenimiento.setBackground(Color.pink);
        menu.setBackground(Color.pink);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void cambiarVerde(){
        try{
        listaNombres.setBackground(Color.GREEN);
        listaNombres2.setBackground(Color.GREEN);
        listaNombres3.setBackground(Color.GREEN);
        listaClientes.setBackground(Color.GREEN);
        listaRentados.setBackground(Color.GREEN);
        cliente.setBackground(Color.GREEN);
        rentar.setBackground(Color.GREEN);
        recibir.setBackground(Color.GREEN);
        mantenimiento.setBackground(Color.GREEN);
        menu.setBackground(Color.GREEN);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void cambiarGris(){
        try{
        listaNombres.setBackground(Color.GRAY);
        listaNombres2.setBackground(Color.GRAY);
        listaNombres3.setBackground(Color.GRAY);
        listaClientes.setBackground(Color.GRAY);
        listaRentados.setBackground(Color.GRAY);
        cliente.setBackground(Color.GRAY);
        rentar.setBackground(Color.GRAY);
        recibir.setBackground(Color.GRAY);
        mantenimiento.setBackground(Color.GRAY);
        menu.setBackground(Color.GRAY);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public Familiar[] crearAutosFamiliares (){
        try{
        Familiar[] autosFamiliares = new Familiar[3];       
        autosFamiliares[0] = new Familiar(5, "Toyota", "Corola", 1250, 1429, true);
        autosFamiliares[1] = new Familiar(8, "Volvo", "XC-90", 3000, 1427, true);
        autosFamiliares[2] = new Familiar(5, "Honda", "Acord", 2000, 1845, true);
        return autosFamiliares;  
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return new Familiar[0];
        }
    }
    
    public Camioneta[] crearCamionetas(){
        try{
        Camioneta[] camionetas = new Camioneta[3];
        camionetas[0] = new Camioneta(1229, "Nissan", "NP300", 3000, 2345, true);
        camionetas[1] = new Camioneta(3434, "Chevrolet", "Silverdado-3500", 5000, 2145, true);
        camionetas[2] = new Camioneta(2100, "Ford", "F-250", 4300, 2385, true);
        return camionetas;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return new Camioneta[0];
        }
        
    }
    
    public Deportivo[] crearDeportivos(){
        try{
        Deportivo [] autosDeportivos = new Deportivo[3];
        autosDeportivos[0] = new Deportivo(332, "Nissan", "370z", 3430, 3455, true);
        autosDeportivos[1] = new Deportivo(410, "Ford", "Mustang GT", 5530, 3193, true);
        autosDeportivos[2] = new Deportivo(755, "Corvette", "ZR1", 10000, 3184, true);
        return autosDeportivos;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return new Deportivo[0];
        }
    }
    
}
