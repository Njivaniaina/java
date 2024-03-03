import java.lang.Math;

public class Tangente extends Fonction
{
	public Tangente()
	{
	}
	public void resolve(double a, double b)
	{	
		double n = a/(Math.log(a));	

		for(int i=0;i<1000;i++)
		{
			n = n/(Math.log(n));	
		}
		this.setSolution(n);
	}
}
