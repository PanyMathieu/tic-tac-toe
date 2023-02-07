import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class tic implements ActionListener  {

Random random = new Random();
JFrame frame= new JFrame();
int i;

JPanel titre_panel=new JPanel();
JPanel boutton_panel = new JPanel();
JLabel text_field= new JLabel();
JButton[] buttons= new JButton[10];
boolean joueur1_tour;

// constructeur 
   public  tic(){
       i =0;
    frame.setTitle("TIC-TAC-TOE");// titre de la fenetre 
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(800,800);
frame.getContentPane().setBackground(new Color(50,50,50));
frame.setLayout(new BorderLayout());
frame.setVisible(true);

text_field.setBackground(Color.white);// couleur darriere plan du semi titre
text_field.setForeground(Color.gray);
text_field.setFont(new Font("ink free",Font.BOLD,75));
text_field.setHorizontalAlignment(JLabel.CENTER);
 text_field.setText("TIC-TAC-TOE");
 text_field.setOpaque(true);

titre_panel.setLayout(new BorderLayout());
titre_panel.setBounds(0,0,800,100);
boutton_panel.setLayout(new GridLayout(3,3));
boutton_panel.setBackground( new Color (150,150,150));
this.relancer();
   }

public void relancer(){
    for(int i=0 ;i<9;i++){
    buttons[i]=new JButton();
    boutton_panel.add(buttons[i]);
    buttons[i].setFont(new Font("",Font.BOLD,120));// taille et police des bouttons 
    buttons[i].setFocusable(false);
    buttons[i].addActionListener(this);
}


titre_panel.add(text_field);
frame.add(titre_panel,BorderLayout.NORTH);// 
frame.add(boutton_panel); 
premiertour();
 
    }
    
     
    public void actionPerformed (ActionEvent e) // aFFICHAGE DE NOM DU JOUER ET Boutton 
    {
      
for (int i=0;i<9;i++){
    if (e.getSource()== buttons[i]){
        if (joueur1_tour){
            if (buttons[i].getText()==""){
                buttons[i].setForeground(Color.gray);
              
                buttons[i].setText("X");
                joueur1_tour=false;
                text_field.setText("Tour du joueur O");
                check();
            }
        } 
        else {
            if (buttons[i].getText()=="")
                {
                buttons[i].setForeground(Color.black);
             
                buttons[i].setText("O");
                joueur1_tour=true;
            text_field.setText("Tour du joueur X");
            check();
            }
        }

    }
}

    }

public void premiertour(){
try {
    Thread.sleep(2000);// 
} catch (InterruptedException e) {
   
    e.printStackTrace();
}
 
    if(random.nextInt(2)==0){
        joueur1_tour=true;
        text_field.setText("Tour du joueur  X");
    }
  else{
        joueur1_tour=false;
        text_field.setText("Tour du joueur O");
    }
}


// verification des conditions 
public void check() {

//condition X  gagne 
if((buttons[0].getText()=="X") && (buttons[1].getText()=="X") && (buttons[2].getText()=="X") ){
    Xgagne(0, 1, 2);
}
if((buttons[3].getText()=="X") && (buttons[4].getText()=="X") && (buttons[5].getText()=="X") ){
    Xgagne(3, 4, 5);

}
if((buttons[6].getText()=="X") && (buttons[7].getText()=="X") && (buttons[8].getText()=="X") ){
    Xgagne(6, 7, 8);
}
if((buttons[0].getText()=="X") && (buttons[3].getText()=="X") && (buttons[6].getText()=="X") ){
    Xgagne(0, 3, 6);
}
if((buttons[1].getText()=="X") && (buttons[4].getText()=="X") && (buttons[7].getText()=="X") ){
    Xgagne(1, 4, 7);

}
if((buttons[2].getText()=="X") && (buttons[5].getText()=="X") && (buttons[8].getText()=="X") ){
    Xgagne(2, 5, 8);
}

if((buttons[0].getText()=="X") && (buttons[4].getText()=="X") && (buttons[8].getText()=="X") ){
    Xgagne(0, 4, 8);
}
if((buttons[2].getText()=="X") && (buttons[4].getText()=="X") && (buttons[6].getText()=="X") ){
    Xgagne(2, 4, 6);

}

//condition O gagne

if((buttons[0].getText()=="O") && (buttons[1].getText()=="O") && (buttons[2].getText()=="O") ){
    Ogagne(0, 1, 2);
}
if((buttons[3].getText()=="O") && (buttons[4].getText()=="O") && (buttons[5].getText()=="O") ){
    Ogagne(3, 4, 5);

}
if((buttons[6].getText()=="O") && (buttons[7].getText()=="O") && (buttons[8].getText()=="O") ){
    Ogagne(6, 7, 8);
}
if((buttons[0].getText()=="O") && (buttons[3].getText()=="O") && (buttons[6].getText()=="O") ){
    Ogagne(0, 3, 6);
}
if((buttons[1].getText()=="O") && (buttons[4].getText()=="O") && (buttons[7].getText()=="O") ){
    Ogagne(1, 4, 7);

}
if((buttons[2].getText()=="O") && (buttons[5].getText()=="O") && (buttons[8].getText()=="O") ){
    Ogagne(2, 5, 8);
}

if((buttons[0].getText()=="O") && (buttons[4].getText()=="O") && (buttons[8].getText()=="O") ){
    Ogagne(0, 4, 8);
}

if((buttons[2].getText()=="O") && (buttons[4].getText()=="O") && (buttons[6].getText()=="O") ){
    Ogagne(2, 4, 6);
}




}

    public void Xgagne( int a ,int b, int c){
     
buttons[a].setBackground(Color.BLUE);
buttons[b].setBackground(Color.BLUE);
buttons[c].setBackground(Color.blue);
for (int i=0;i<9;i++){
    buttons[i].setEnabled(false );

}

JOptionPane.showMessageDialog(frame, "joueur X a gagné", null, JOptionPane.INFORMATION_MESSAGE);


    }

public void Ogagne( int a ,int b, int c){
    buttons[i].setBackground(Color.GREEN);
    buttons[i].setBackground(Color.GREEN);
    buttons[i].setBackground(Color.GREEN);
    for (int i=0;i<9;i++){
        buttons[i].setEnabled(false);

    }
  
    JOptionPane.showMessageDialog(frame, "joueur O a gagné", null, JOptionPane.INFORMATION_MESSAGE);
   
    }

    
}

    
        
      
        
    
        
    

    


  