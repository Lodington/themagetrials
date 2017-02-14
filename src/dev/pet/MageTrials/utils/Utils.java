package dev.pet.MageTrials.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Utils {
	
	public static String loadFileAsString(String path){
		StringBuilder builder = new StringBuilder();
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			while((line = br.readLine()) != null)
				builder.append(line + "\n");
			
			br.close();
		}catch(IOException e){
			JOptionPane.showMessageDialog(null,"Error","ERROR! AN ERROR HAS OCCURED!", JOptionPane.ERROR_MESSAGE);
		}
		
		return builder.toString();
	}
	
	public static int parseInt(String number){
		try{
			return Integer.parseInt(number);
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null,"Error","ERROR! AN ERROR HAS OCCURED!", JOptionPane.ERROR_MESSAGE);
			return 0;
		}
	}

}
