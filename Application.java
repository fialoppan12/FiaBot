package fiaBot;

/**
 * 
 * Basic gui.
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
 
 
public class Application extends JFrame {
       
  private static final long serialVersionUID = 1L;
	private WordGraph graph = new WordGraph();
    private JTextArea chat = new JTextArea();
    private JTextField answer = new JTextField();
    
    public Application() {
        super("FiaBot1.0");
        setLayout(new BorderLayout());
        chat.setEditable(false);
        answer.addKeyListener(new keyList());
       
        add(new JScrollPane(chat), BorderLayout.CENTER);
        add(answer, BorderLayout.SOUTH);
       
        graph.setup(Setup.lasin());
                   
        setSize(400,300);
        setLocationByPlatform(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
       
           
    private class keyList implements KeyListener {
 
        @Override
        public void keyPressed(KeyEvent kev) {
                // TODO Auto-generated method stub      
        }
		 
        @Override
        public void keyReleased(KeyEvent kev) {
            if (kev.getKeyCode()==KeyEvent.VK_ENTER) {
                chat.append("you: "+answer.getText()+"\n");
				graph.readInput(answer.getText());
				answer.setText("");
				chat.append("bot: "+graph.getAnswer()+"\n");
            }
        }
		 
        @Override
        public void keyTyped(KeyEvent arg0) {
                // TODO Auto-generated method stub     
		}
	       
	}
   
    public static void main(String[]args) {
        new Application();
    }
 
}
