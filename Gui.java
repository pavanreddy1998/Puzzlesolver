import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Stack;
import java.util.TimerTask;
import java.util.Timer;
import java.awt.event.*;
import java.lang.*;
import java.awt.event.KeyEvent.*;
import java.awt.event.KeyListener.*;
import java.awt.Graphics.*;

/**
 * The main Gui window for the system. displays the grid of tiles and will show how solutions were found
 * 
 * @author Eqwen Cluley
 * @version v1
 */
public class Gui
{
    
    private JFrame window;
    
    
    private JPanel gridPanel;
    private JLabel[][] grid;
    private Container pane;
    private Timer timer;
	int pz[][]=new int[100][100];
	int z=0,k,l;
    

    /**
     * Builds a Gui window and initalises the puzzle.  It also setsup a timer object to be used later when a solution has been found.
     */
    public Gui()
    {
        timer = new Timer();
        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        pane = window.getContentPane();
        draw();
		
		
	
    }

    /**
     * Redraws the grid, based upon the current puzzle.  By updating the puzzle, and calling this method you can change the display
     */
    public void draw()
    {
        pane.removeAll();
        gridPanel = null;
        gridPanel = new JPanel();
        grid = new JLabel[4][4];
        pane.setLayout(new FlowLayout());
        gridPanel.setLayout(new GridLayout(0,4));
		if(z==0){MakeSquare();
		  z=1;
		}
        for(int i =0; i<4;i++){
            for(int j = 0; j<4; j++){
				int m=GetSquare(i,j);
                grid[i][j] = new JLabel(""+m, 4);
                grid[i][j].setFont(new Font("Sans-serif", Font.BOLD, 24));
                grid[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
                if(m == 16){
                    grid[i][j].setText("  ");
                }
                gridPanel.add(grid[i][j]);
            }
        }
        pane.add(gridPanel);
        JPanel controlls = new JPanel();
        controlls.setLayout(new GridLayout(2, 3));
        
        JButton shuff = new JButton("SHUFFLE");
        shuff.addActionListener(new SolveListener("shuff"));
        JButton solveBF = new JButton("UP");
        solveBF.addActionListener(new SolveListener("BF"));
		JButton solve = new JButton("SOLVE");
        solve.addActionListener(new SolveListener("solve"));
		JButton left = new JButton("LEFT");
        left.addActionListener(new SolveListener("left"));
		
        JButton solveAS = new JButton("DOWN");
		solveAS.addActionListener(new SolveListener("AS"));
		JButton right = new JButton("RIGHT");
        right.addActionListener(new SolveListener("right"));
        
        
        
        controlls.add(shuff);
        controlls.add(solveBF);
		controlls.add(solve);
		 controlls.add(left);
        controlls.add(solveAS);
		 controlls.add(right);
        
        pane.add(controlls);
		
        
        window.setSize(600,200);
        window.setVisible(true); 
    }
	
	
	
	private class SolveListener implements ActionListener
    {
        private String type;
        
        /**
         * Takes in a strign to define which type of search it will execute.
         * @param type String "BF" for breadth first search, "DF" for depth first and any other for A*
         */
        private SolveListener(String type)
        {
            this.type = type;
        }
                
        public void actionPerformed(ActionEvent e){
			int i,j;
            
            if(type == "DF"){
                
            } else if(type == "BF"){
				
				
				
				
                for(i=0;i<4;i++)
					   for(j=0;j<4;j++)
					   {
						   if(pz[i][j]==16)
						   {
							   k=i;
							   l=j;
						  
						   break;}
					   }
				
				
				          if(k!=3){
						   pz[k][l]=pz[k+1][l];
					            pz[k+1][l]=16;
						  draw();}
						    
                
            }
              else if(type == "left"){
				
				
				
				
                for(i=0;i<4;i++)
					   for(j=0;j<4;j++)
					   {
						   if(pz[i][j]==16)
						   {
							   k=i;
							   l=j;
						  
						   break;}
					   }
				
				
				            if(l!=3){
						   pz[k][l]=pz[k][l+1];
					            pz[k][l+1]=16;
						         draw();
						    }
                
            }

			
			else if(type == "right"){
				
				
				
				
                for(i=0;i<4;i++)
					   for(j=0;j<4;j++)
					   {
						   if(pz[i][j]==16)
						   {
							   k=i;
							   l=j;
						  
						   break;}
					   }
				
				
				          if(l!=0){
						   pz[k][l]=pz[k][l-1];
					            pz[k][l-1]=16;
						         draw();
						  }
                
            }


			else {
				
                for(i=0;i<4;i++)
					   for(j=0;j<4;j++)
					   {
					   if((pz[i][j]==16)||(pz[i][j]==0))
					   {k=i;
				        l=j;
						   break;
					   }   
					   }
					   if(k!=0){
					 pz[k][l]=pz[k-1][l];
					            pz[k-1][l]=16;
						         draw();
					   }
					   
            }
                   
        }
    }
	
	void MakeSquare()
	{
		
		int k=1;
		int o,p;
		for(o=0;o<4;o++)
			for(p=0;p<4;p++)
			{
				
				pz[o][p]=k;
				k++;
				
			}
		 
		
		
	}
	
	int GetSquare(int o,int p)
	{
	  return pz[o][p];
	
	}
	
    
     
    
    public static void main(String[] args)
    {
        new Gui();
    }
}