import java.util.ArrayList;

public class Eval
{
    public Eval()
    {

    }

/// Calacule sans les parenthèses
    private String calcule_simple(String expression)
    {
        String[] l = expression.split("[+\\-*/]");
        String[] o = expression.split("[\\d.]+");
        ArrayList<String> list  = new ArrayList<>();
        ArrayList<String> operator = new ArrayList<>();       

        for(String s : l) list.add(s);
        for(String s : o) operator.add(s);

    /// Si il y a du sigen moins dès le première 
        if(operator.size() > 0)
        {
            if(operator.get(0).compareTo("-") == 0)
            {
                list.set(1, Double.toString(-1*Double.parseDouble(list.get(1))));
                list.remove(0);
            }
        }
        
        if(list.size() > 1)
        {
        /// Pour le multiplication et le division
            for(int i=0 ; i < operator.size() ; i++)
            {
                if( operator.get(i).compareTo("*") == 0 )
                {
                    double d = Double.parseDouble(list.get(i-1))*Double.parseDouble(list.get(i));
                    list.set(i-1, Double.toString(d));
                    list.remove(i);
                    operator.remove(i);
                }
                else if( operator.get(i).compareTo("/") == 0 )
                {
                    double d = Double.parseDouble(list.get(i-1))/Double.parseDouble(list.get(i));
                    list.set(i-1, Double.toString(d));
                    list.remove(i);
                    operator.remove(i);
                }
            }

        /// Pour l'addition et le soustraction
            for(int i=0 ; i < operator.size() ; i++)
            {
                if( operator.get(i).compareTo("+") == 0 )
                {
                    double d = Double.parseDouble(list.get(i-1))+Double.parseDouble(list.get(i));
                    list.set(i-1, Double.toString(d));
                    list.remove(i);
                    operator.remove(i);
                    i--;
                }
                else if( operator.get(i).compareTo("-") == 0 )
                {
                    double d = Double.parseDouble(list.get(i-1))-Double.parseDouble(list.get(i));
                    list.set(i-1, Double.toString(d));
                    list.remove(i);
                    operator.remove(i);
                    i--;
                }
            }
        }

        return list.get(0);
    }

/// Caclule avec des parenthèses
    private String calcule_complexe(String expression)
    {
        ArrayList<String> list  = new ArrayList<>();
        ArrayList<String> operator = new ArrayList<>();
        String new_expression = ""; 
        int p=0, n=0, l=0, k=0;

        list.add("");
        for(int i=0;i<expression.length();i++)
        {
            if(expression.charAt(i) == '(') p++;
            else if(expression.charAt(i) == ')') p--;
            
            if(p==0 && expression.charAt(i) != ')' && expression.charAt(i) != '(')
            {
                if(expression.charAt(i) == '*' || expression.charAt(i) == '/' || expression.charAt(i) == '+' || expression.charAt(i) == '-')
                {
                    operator.add(""+expression.charAt(i));
                    list.add("");
                    n++;
                }
                else 
                {
                    list.set(n, list.get(n)+expression.charAt(i));
                }
            }
            else if( (p!=0  && expression.charAt(i) != '(') || p>1 )
            {
                list.set(n, list.get(n)+expression.charAt(i));                
            }
            else if( p==0 && expression.charAt(i) == ')')
            {
                list.add("");
                n++;
            }
        }

        for(int i=0;i<list.size();i++)
        {
            if(list.get(i).compareTo("") != 0)
            {
                if(list.get(i).charAt(0) == '*' || list.get(i).charAt(0) == '/' || list.get(i).charAt(0) == '+' && list.get(i).charAt(0) == '-')
                {
                    operator.add(""+list.get(i).charAt(0));
                    list.set(i, list.get(i).substring(1, list.get(i).length()));
                }
            }
        }

        for(int i=0;i<list.size();i++)
        {
            if(list.get(i).compareTo("") != 0)
            {
                list.set(i, calcule(list.get(i)));
            }
        }

        new_expression=list.get(0);
        for(int  i=1;i<list.size();i++)
        {
            if(list.get(i).compareTo("") != 0)
            {
                new_expression += (operator.get(l)+list.get(i));
                l++;
            }
        }
        
        return calcule(new_expression);
    }

/// Vérifier si il y a des paranthèses 
    private boolean There_are_parenthese(String expression)
    {
        boolean verifie=false;
        for(int i=0;i<expression.length();i++)
        {
            if(expression.charAt(i) == '(')
            {
                verifie = true;
            }
        }
        return verifie;
    }

/// La methode de la calcule générale
    public String calcule(String expression)
    {
        if(expression.length() == 0)
        {
            return "0";
        }
        else
        {
            if(There_are_parenthese(expression))
            {
                return calcule_complexe(expression);
            }
            else
            {
                return calcule_simple(expression);
            }
        }
    }
}
