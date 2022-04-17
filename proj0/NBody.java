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
	
	public static Planet[] readPlanets(String fl){
		int planetsnum = 0;
		try{
			BufferedReader br = new BufferedReader(new FileReader(fl));
			planetsnum = readInt(br);
			br.close();
		}
		catch(Exception e1){
			System.out.println("readPlanet 1");
		}
		Planet[] ps = new Planet[planetsnum];
		try{
			BufferedReader br = new BufferedReader(new FileReader(fl));
			br.readLine();
			br.readLine();
			for(int i = 0;i < planetsnum;i++){
				ps[i] = new Planet(readDouble(br), readDouble(br), readDouble(br), readDouble(br), readDouble(br), readString(br));
			}
			br.close();
		}
		catch(Exception e2){
			System.out.println("readPlanet 2");
		}
		return ps;
	}

	public static int readInt(BufferedReader br){
		String str = "";
		try{
			char c = (char)br.read();
			while(c == ' ' || c == '\n'|| c == '\r'){
				c = (char)br.read();
			}
			//windows中\r和\n都能换行
			while(c != ' ' && c != '\n' && c != '\r'){
				str += c;
				c = (char)br.read();
			}
		}
		catch(Exception e){
			System.out.println("readInt");
		}
		int n = 0;
		if(str != null && !str.isEmpty()){
			n = Integer.parseInt(str);	
		}
		return n;
		//return Integer.parseInt(str);
	}
	public static Double readDouble(BufferedReader br){
		String str = "";
		try{
			char c = (char)br.read();
			while(c == ' ' || c == '\n' || c == '\r'){
				c = (char)br.read();
			}
			while(c != ' ' && c != '\n' && c != '\r'){
				str += c;
				c = (char)br.read();
			}
		}
		catch(Exception e){
			System.out.println("readDouble");
		}
		double t = 0;
		 if(str != null && !str.isEmpty()){
			t = Double.parseDouble(str);
		} 
		return t;
	}
	public static String readString(BufferedReader br){
		String str = "";
		try{
			str += br.readLine();
		}
		catch(Exception e){}
		while(str.charAt(0) == ' '){
			str = str.substring(1,str.length());
		}
		return str;
	}
	public static void main(String[] args){
		double T =  Double.parseDouble(args[0]);
		double dT =  Double.parseDouble(args[1]);
		String filename = args[2];
		double n =0;
		try{
			n = readInt(new BufferedReader(new FileReader(filename)));
		}
		catch(Exception e1){}
		double universRadius = readRadius(filename);
		Planet[] planets = readPlanets(filename);
		String Background = "./images/starfield.jpg";
		StdDraw.setScale(-universRadius,universRadius);
		StdDraw.enableDoubleBuffering();
		for(double j = 0;j < T; j = j + dT){	
			StdDraw.clear();
			StdDraw.picture(0, 0, Background);
			for(int i = 0;i < n; i++){
				double fx = planets[i].calcNetForceExertedByX(planets);
				double fy = planets[i].calcNetForceExertedByY(planets);
				planets[i].update(dT,fx,fy);
				planets[i].draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
		}
	}
}
