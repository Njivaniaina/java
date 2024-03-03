public class Desc extends Fonction
{
    public Desc()
    {

    }
    public void resolve(double a, double b)
    {
        double center = 0;
        double n=0, m=0;

    	if(f(a)*f(b) < 0)
    	{
           	while((b-a) > 0.0001)
    		{   
                n = (f(a)-f(b))/(a-b);
                m = f(a)-n*a;

            	center = (-m)/n;

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