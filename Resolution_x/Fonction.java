import java.lang.Math;

public abstract class Fonction
{
		private double solution;
    
    	public abstract void resolve(double a, double b); 

		public void setSolution(double solution)
		{
			this.solution = solution;
		}
    	public double getSolution()
    	{
		return this.solution;
    	}
    	public double f(double x)
    	{
        	return Math.log(x)-1;
    	}
}
