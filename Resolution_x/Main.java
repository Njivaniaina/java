public class Main
{
    public static void main(String argc[])
    {
        Fonction f = new Desc();
        f.resolve(1, 4);
        System.out.println("Le solution est "+f.getSolution());
    }
}
