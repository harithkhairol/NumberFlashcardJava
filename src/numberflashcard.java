

import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.*;
import java.applet.*;

public class numberflashcard extends JApplet implements ActionListener 
{
	JLabel display = new JLabel();

	JButton back=new JButton("back");
	JButton stop=new JButton("stop");
	JButton next=new JButton("next");
	JButton play=new JButton("play");
	JButton pause=new JButton("pause");
   AudioClip audioClip[] = new AudioClip[10];

	
	
	int currentImage=-1;
	String images[]={"image0.jpg","image1.jpg","image2.jpg","image3.jpg","image4.jpg","image5.jpg","image6.jpg","image7.jpg","image8.jpg","image9.jpg"};

	
	public void init() 
{
	JPanel buttons=new JPanel(new FlowLayout());
	buttons.add(back);
	buttons.add(next);
	buttons.add(play);
	buttons.add(pause);
	
	getContentPane().setLayout(new BorderLayout());
	getContentPane().add("Center",new JScrollPane(display));
	getContentPane().add("South",buttons);
	
	back.addActionListener(this);
	next.addActionListener(this);
	play.addActionListener(this);
	pause.addActionListener(this);
	
	    
	audioClip[0] = getAudioClip(getCodeBase(), "sound0.wav");
	audioClip[1] = getAudioClip(getCodeBase(), "sound1.wav");
	audioClip[2] = getAudioClip(getCodeBase(), "sound2.wav");
	audioClip[3] = getAudioClip(getCodeBase(), "sound3.wav");
	audioClip[4] = getAudioClip(getCodeBase(), "sound4.wav");
	audioClip[5] = getAudioClip(getCodeBase(), "sound5.wav");
	audioClip[6] = getAudioClip(getCodeBase(), "sound6.wav");
	audioClip[7] = getAudioClip(getCodeBase(), "sound7.wav");
	audioClip[8] = getAudioClip(getCodeBase(), "sound8.wav");
	audioClip[9] = getAudioClip(getCodeBase(), "sound9.wav");

}

	public void showCurrentImage(){
		
		display.setIcon(new ImageIcon(images[currentImage]));

	}
	
	public void showNextImage(){
		
		currentImage=currentImage+1;
		if(currentImage>=images.length)
			currentImage=0;
		showCurrentImage();
		System.out.print(currentImage);
		
	}
	
	public void showPreviousImage(){
		
		currentImage=currentImage-1;
		if(currentImage<0)
			currentImage=images.length-1;
		showCurrentImage();
		System.out.print(currentImage);
			}
	


public void actionPerformed(ActionEvent e){
	
	if(e.getSource()==next)
		showNextImage();
	else if(e.getSource()==back)
		showPreviousImage();
	if (e.getSource() == play){
        switch(currentImage){
        	case 0: audioClip[0].play(); break;
        	case 1: audioClip[1].play(); break;
        	case 2: audioClip[2].play(); break;
        	case 3: audioClip[3].play(); break;
        	case 4: audioClip[4].play(); break;
        	case 5: audioClip[5].play(); break;
        	case 6: audioClip[6].play(); break;
        	case 7: audioClip[7].play(); break;
        	case 8: audioClip[8].play(); break;
        	case 9: audioClip[9].play(); break;
        
        	}
      }  
      else if(e.getSource() == pause){
         audioClip[0].stop();
         audioClip[1].stop();
         audioClip[2].stop();
         audioClip[3].stop();
         audioClip[4].stop();
         audioClip[5].stop();
         audioClip[6].stop();
         audioClip[7].stop();
         audioClip[8].stop();
         audioClip[9].stop();
         
         
         
      }
			
	
}

}