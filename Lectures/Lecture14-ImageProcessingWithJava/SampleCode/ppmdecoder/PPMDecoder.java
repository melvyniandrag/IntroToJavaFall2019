package ppmdecoder;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class PPMDecoder{
	private String _fileName;
	private ArrayList<String> _lines;
	private ArrayList<Integer> _dimensions; // Width, Height
	private ArrayList<ArrayList<Byte>> _pixelValues = new ArrayList<ArrayList<Byte>>(); // Array of RGB 3-tuples
	public boolean isValidData = true;
	private ArrayList<Byte> encodedBytes = new ArrayList<Byte>();

	public static void main(String[] args){
		try{
			String fileToDecode = args[0];
			PPMDecoder ppmdecoder = new PPMDecoder(fileToDecode);
			if( !ppmdecoder.isValidData ){
				System.out.println("Can't continue. Corrupt image format");
			}
			else{
				String message = ppmdecoder.decode();
				System.out.println(message);
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
		for( int pixel = 0; pixel < _pixelValues.size(); ++pixel){
			for( int channel = 0; channel < 3; ++channel ){
				byte tmp = (byte)0x03; // b00000011
				encodedBytes.add( new Byte( (byte)(tmp & _pixelValues.get(pixel).get(channel).byteValue() ) ) );
			}
		}
		byte[] bytes = new byte[4]; // to improve code we need to remove hard coding. For this example, we know the message contains 4 ascii characters.
		int shift = 6;
		byte shiftByte = (byte)0x00;
		int currentIndex = 0;
		for( int b = 0; b < encodedBytes.size() - 2; ++b){ // we know we will ignore the last two, because we are ignoring the last 4 bits.
			shiftByte |= (byte)(encodedBytes.get(b).byteValue() << shift );
			if ( shift == 0 ){
				shift = 6;
				bytes[currentIndex] = shiftByte;
				currentIndex++;
				shiftByte = (byte)0x00;
			}
			else{
				shift -= 2;
			}
		}
		Charset UTF8_CHARSET = Charset.forName("UTF-8");
		return new String(bytes, UTF8_CHARSET);
	}

	private ArrayList<Integer> getDimensions(String line){
		String[] split = line.split(" "); // assumes only spaces. We could improve by splitting on white space in case of a tab.
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
