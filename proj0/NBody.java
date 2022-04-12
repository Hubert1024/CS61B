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
		//double xp,yp,xv,yv,m;
		String str = "";
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
			//double xp = readDouble(br);
			for(int i = 0;i < planetsnum;i++){
				//ps[i] = new Planet(0,0,0,0,0,readString(br));
				ps[i] = new Planet(readDouble(br), readDouble(br), readDouble(br), readDouble(br), readDouble(br), readString(br));
				//System.out.println();
				//Double xp = Double.parseDouble("3.0e+10");
				//yp = readDouble(br);
				//xv = readDouble(br);
				//yv = readDouble(br);
				//m = readDouble(br);
				//str = readString(br);
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
			while(c != ' '&& c != '\n'){
				str += c;
				c = (char)br.read();
			}
		}
		catch(Exception e){
			System.out.println("readInt");
		}
		return Integer.parseInt(str);
	}
	public static Double readDouble(BufferedReader br){
		String str = "";
		try{
			char c = (char)br.read();
			if(c == ' '){
				c = (char)br.read();
			}
			while(c != ' '&& c != '\n'){
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
		//return Double.parseDouble(str);
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
		//System.out.println(str.substring(1,str.length()));
		return str;
	}

}
