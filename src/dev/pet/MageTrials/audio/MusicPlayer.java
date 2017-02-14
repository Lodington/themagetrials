package dev.pet.MageTrials.audio;

import java.io.File;
import java.util.ArrayList;
import javax.sound.sampled.*;


public class MusicPlayer implements Runnable{
	
	private ArrayList<String> musicFiles;//Playlist
	private int currentSongIndex;
	private static Clip song;
	
	public MusicPlayer(String...files){
		musicFiles = new ArrayList<String>();
		for(String file: files)
			musicFiles.add("./res/music/"+ file +".wav");//Add music files to the array
	}//end of MusicPlayer
	
	private void playSound(String fileName){
		try{
			File soundFile = new File(fileName);
			AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
			AudioFormat format = ais.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, format);
			Clip clip = (Clip) AudioSystem.getLine(info);//Open music file
			song = clip;
			clip.open(ais);
			//Changes the volume
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-1);//Lowers by 10
			clip.start();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static Clip getSongClip(){
		return song;
	}
	
	@Override
	public void run(){
		playSound(musicFiles.get(currentSongIndex));//Plays the first song
	}//end of run
	
	public static void stop(Clip clip){
		clip.stop();
	}
	
}//end of class
