public class Planet {
	public static double G = 6.67e-11;
	double xxPos;
	double yyPos;
	double xxVel;
	double yyVel;
	double mass;
	String imgFileName;
	
	/** initialize */
	public Planet(double xP, double yP, double xV, double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}
	public Planet(Planet p){
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}

	/** calculation the distance  */
	public double calcDistance(Planet p) {
		double xD;
		double yD;
		double r;
		xD = this.xxPos - p.xxPos;
		yD = this.yyPos - p.yyPos;
		r = xD * xD + yD * yD;
		return Math.sqrt(r);
	}

	/** calc gravity */
	public double calcForceExertedBy(Planet p){
		double r = this.calcDistance(p);
		return G * this.mass * p.mass / (r * r);
	}
}
