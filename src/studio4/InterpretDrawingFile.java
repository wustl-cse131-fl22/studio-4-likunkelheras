package studio4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

import edu.princeton.cs.introcs.StdDraw;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class InterpretDrawingFile {

	public static void main(String[] args) throws FileNotFoundException {
		JFileChooser chooser = new JFileChooser("resources");
		chooser.showOpenDialog(null);
		File f = new File(chooser.getSelectedFile().getPath());
		Scanner in = new Scanner(f); //making Scanner with a File
		
		String shape = in.next();
		int redComponent = in.nextInt();
		int greenComponent = in.nextInt();
		int blueComponent = in.nextInt();
		boolean isFilled = in.nextBoolean();
		double parameterOne = in.nextDouble();
		double parameterTwo = in.nextDouble();
		double parameterThree = in.nextDouble();
		double parameterFour = in.nextDouble();
		double parameterFive = 0;
		double parameterSix= 0;
		StdDraw.setPenColor(redComponent, greenComponent, blueComponent);
		if (shape.equals("triangle")) {
			parameterFive = in.nextDouble();
			parameterSix = in.nextDouble();
			double [] xCorDoubles = {parameterOne,parameterThree,parameterFive};
			double [] yCorDoubles = {parameterTwo,parameterFour,parameterSix};
			if (isFilled) {
				
				StdDraw.filledPolygon(xCorDoubles, yCorDoubles);
				
			}
			else {
				StdDraw.polygon(xCorDoubles, yCorDoubles);
			}
		}
		if (shape.equals("ellipse")) {
			if(isFilled) {
				StdDraw.filledEllipse(parameterOne, parameterTwo, parameterThree, parameterFour);
			}
			else {
				StdDraw.ellipse(parameterOne, parameterTwo, parameterThree, parameterFour);
			}
			
		}
		if (shape.equals("rectangle")) {
			if (isFilled) {
				StdDraw.filledRectangle(parameterOne, parameterTwo, parameterThree, parameterFour);
			}
			else {
				StdDraw.rectangle(parameterOne, parameterTwo, parameterThree, parameterFour);
			}
			
		}
			
		
		
		
		
	}
}
