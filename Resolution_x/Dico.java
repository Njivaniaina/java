import java.lang.Math;

public class Dico extends Fonction
{
	
    	public Dico()
    	{

    	}
    	public void resolve(double a, double b)
    	{	
        	double center = 0;
        	if(f(a)*f(b) < 0)
        	{
           		while((b-a) > 0.0001)
            		{
                		center = (a+b)/2;
                		if(f(a)*f(center) < 0)
                		{
                    			b = center;
                		}
                		else
                		{
                    			a = center;
                		}
            		}
        	}
        	else
        	{
            	System.out.println("Il n'y pas de solution f(x)=0 dans l'intervalle."+"\nf(a)="+f(a)+"\nf(b)="+f(b));
        	}
        	this.setSolution(center);
    	}
}
