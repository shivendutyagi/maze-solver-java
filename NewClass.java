package com.mycompany.maze.solver.minor_proj1;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;



public class NewClass extends JFrame {
    private int [][] maze=
    {{1,1,1,1,1,1,1,1,1,1,1,1,1},
          {1,0,1,0,1,0,1,0,0,0,0,0,1},
          {1,0,1,0,0,0,1,0,1,1,1,0,1},
          {1,0,0,0,1,1,1,0,0,0,0,0,1},
          {1,0,1,0,0,0,0,0,1,1,1,0,1},
          {1,0,1,0,1,1,1,0,1,0,0,0,1},
          {1,0,1,0,1,0,0,0,1,1,1,0,1},
          {1,0,1,0,1,1,1,0,1,0,1,0,1},
          {1,0,0,0,0,0,0,0,0,0,0,9,1},
          {1,1,1,1,1,1,1,1,1,1,1,1,1}
    };
    private List<Integer> path=new ArrayList<>();
    
    public NewClass(){
        setTitle("Maze Solver");
        setSize(640,480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DepthFirst.searchpath(maze,1,1,path);
        System.out.println(path);
        
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.translate(50, 50);
        
        for (int row=0;row<maze.length;row++) {
            for (int col=0;col<maze[0].length;col++) {
                Color color;
                switch(maze[row][col]) {
                    case 1 : color=Color.BLACK; break;
                    case 9 : color=Color.RED; break;
                    default : color=Color.WHITE; break;
                    
                }
                g.setColor(color);
                g.fillRect(30*col,30*row,30,30);
                g.setColor(Color.RED);
                g.drawRect(30*col,30*row,30,30);
              
            }
        }
        for(int p=0;p<path.size();p+=2){
            int pathx=path.get(p);
            int pathy=path.get(p+1);
            System.out.println("path x coordinate"+pathx);
            System.out.println("path y coordinate"+pathy);
            g.setColor(Color.GREEN);
            g.fillRect(pathx*30, pathy*30, 30, 30);
            
            
        }
    }
    
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                NewClass view =new NewClass();
                view.setVisible(true);
            }
            
        });
        
    }
}

