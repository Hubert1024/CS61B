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

	/** calculate the distance  */
	public double calcDistance(Planet p) {
		double xD;
		double yD;
		double r2;
		xD = this.xxPos - p.xxPos;
		yD = this.yyPos - p.yyPos;
		r2 = xD * xD + yD * yD;
		return Math.sqrt(r2);
	}

	/** calculate the gravity by */
	public double calcForceExertedBy(Planet p){
		double r = this.calcDistance(p);
		return G * this.mass * p.mass / (r * r);
	}
	
	/** calculate the force from x,y axis */
	public double calcForceExertedByX(Planet p){
		double xratio = (p.xxPos - this.xxPos) / this.calcDistance(p);
		return this.calcForceExertedBy(p) * xratio;
	}
	public double calcForceExertedByY(Planet p){
		double yratio = (p.yyPos - this.yyPos) / this.calcDistance(p);
		return this.calcForceExertedBy(p) * yratio;
	}

	public double calcNetForceExertedByX(Planet[] Ps){
		double xNetForce = 0;
		for(int i = 0; i < Ps.length; i++){
			if(this.equals(Ps[i])){
				continue;
			}
			xNetForce += this.calcForceExertedByX(Ps[i]);
		}
		return xNetForce;
	}
	public double calcNetForceExertedByY(Planet[] Ps){
		double yNetForce = 0;
		for(int i = 0; i < Ps.length; i++){
			if(this.equals(Ps[i])){
				continue;
			}
			yNetForce += this.calcForceExertedByY(Ps[i]);
		}
		return yNetForce;
	}
	public boolean equals(Planet p){
		if(this.xxPos == p.xxPos && this.yyPos == p.yyPos){
			return true;
		}
		return false;
	}
	public void update(double dt, double fX, double fY){
		double ax = fX / this.mass;
		double ay = fY / this.mass;
		this.xxVel = this.xxVel + ax * dt;
		this.yyVel = this.yyVel + ay * dt;
		this.xxPos = this.xxPos + this.xxVel * dt;
		this.yyPos = this.yyPos + this.yyVel * dt;
	}
}
