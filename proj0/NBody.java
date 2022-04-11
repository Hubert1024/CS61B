import java.io.*;
public class NBody{
	public static double readRadius(String fl){
		double Radius = 0;
		try{
		BufferedReader br = new BufferedReader(new FileReader(fl));
		String line = "";
			line = br.readLine();
			if((line = br.readLine()) != null);
			Radius = Double.parseDouble(line);
			br.close();
		}
		catch(FileNotFoundException e1){
			System.out.println("File Not Found");
		}
		catch(IOException e2){
			System.out.println("NBody Mistake");
		}
		return Radius;
	}
}
