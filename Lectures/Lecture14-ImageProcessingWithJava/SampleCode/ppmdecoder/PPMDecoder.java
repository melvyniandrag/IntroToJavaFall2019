/*
 * Going through this code I see a ton of obvious improvements that could be made. 
 * Error handling, optimization, etc.. Don't get mad that they aren't there! 
 * This is just demo code!
 * For example - we don't verify that the ppm file is correct, i.e. contains valid data, correct dimensions, etc..
 */

package ppmdecoder;

import java.io.*;
//import java.util.List;
import java.util.ArrayList;

public class PPMDecoder{
	private String _fileName;
	private ArrayList<String> _lines;
	private ArrayList<Integer> _dimensions; // Width, Height
	private ArrayList<ArrayList<Byte>> _pixelValues = new ArrayList<ArrayList<Byte>>(); // Array of RGB 3-tuples
	public boolean isValidData = true;

	public static void main(String[] args){
		try{
			String fileToDecode = args[0];
			PPMDecoder ppmdecoder = new PPMDecoder(fileToDecode);
			if( !ppmdecoder.isValidData ){
				System.out.println("Can't continue. Corrupt image format");
			}
			else{
				System.out.println("$$$$$$$$$$$$$ Binary Input:   $$$$$$$$$$$$$");
				ppmdecoder.binaryDump();
				System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
				System.out.println("############# Decoded String: #############");
				System.out.println(ppmdecoder.decode());
				System.out.println("###########################################");
			}
		} catch ( Exception e ){
			System.out.println(e.toString());
		}


	}

	public PPMDecoder(String fileName){
		System.out.println("Created new PPMDecoder for file: " + fileName );
		_fileName = fileName;
		_lines = readPPMLines(_fileName);
		for( int i = 0; i < _lines.size(); ++i ){
			System.out.print("Read: ");
			System.out.println(_lines.get(i));
			switch(i){
				case 0:
					break;
				case 1:
					_dimensions = getDimensions(_lines.get(i));
					if( _dimensions.get(1) != _lines.size() - 3 ){
						isValidData = false;
						return;
					}
					break;
				case 2:
					isValidData &= is255(_lines.get(i));
					break;
				default:
					isValidData &= updatePixelValuesArray(_lines.get(i));
					break;
			}
			if (!isValidData){
				System.out.println("Invalid data detected.");
				return;
			}
		}
	}
	
	public String decode(){
		return "Hello World!";
	}

	private void binaryDump(){
		for( int pixel = 0; pixel < _pixelValues.size(); ++pixel ){
			String s = String.format("%8s\t%8s\t%8s",
						Integer.toBinaryString(_pixelValues.get(pixel).get(0) & 0xFF),
						Integer.toBinaryString(_pixelValues.get(pixel).get(1) & 0xFF),
						Integer.toBinaryString(_pixelValues.get(pixel).get(2) & 0xFF)
					).replace(' ', '0');
			System.out.println(s);
		}
	}

	private ArrayList<Integer> getDimensions(String line){
		String[] split = line.split(" "); // assumes only spaces. We could improve by splitting on white space in case of a tab.
		//also we assume there will be two numbers. No error handling in this code for simplicity!
		ArrayList<Integer> ret = new ArrayList<Integer>();
		ret.add(Integer.valueOf(split[0]));
		ret.add(Integer.valueOf(split[1]));
		return ret;
	}

	private boolean is255( String line){
		return true;
	}

	private boolean updatePixelValuesArray(String line){
		String[] split = line.split("\\s+");
		if ( split.length != 3 * _dimensions.get(0) ){
			System.out.println("Invalid number of pixel values. Expected [" + _dimensions.get(0)*3 + "] Got [" + split.length + "]");
			return false;
		}
		ArrayList<Byte> pixel = new ArrayList<Byte>();
		for ( int channel = 0; channel <  split.length; ++channel ){
			try{
				int channelValue = Integer.parseInt(split[channel]);
				pixel.add( new Byte((byte)channelValue));
				if( pixel.size() == 3 ){
					_pixelValues.add(pixel);
					pixel = new ArrayList<Byte>();
				}
			}
			catch( Exception e){
				System.out.println("Error updating pixel value for channel value: '" + split[channel] + "'");
				System.out.println(e.toString());
				return false;
			}
		}
		return true;
	}

	private ArrayList<String> readPPMLines(String fileName) {
		ArrayList<String> ret = new ArrayList<String>();
		try{
			FileReader reader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(reader);
			String line = null;
			while((line = bufferedReader.readLine()) != null){
				ret.add(line);
			}
			bufferedReader.close();
		}
		catch (Exception e){
			System.out.println("Error reading file: " + fileName );
			System.out.println(e.toString());
			ret = new ArrayList<String>();
		}
		return ret;
	}

}
