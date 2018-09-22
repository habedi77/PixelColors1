public enum CalculationMode
{
    OneOnEuclidean,
    OneOnTaxicab,
    CosinByTaxicab,
    CosinByEuclidean,
    HalfCosinEuclidean,
    CosinEuclideanHalfPulse,
    Exp_Euclidean,
    Exp_Taxicab,
    Test03;
    private String name;
    
    CalculationMode()
    {
        this.name = this.toString();
        System.out.println(name);
    }
    
    public String getName()
    {
        return name;
    }
    public  CalculationMode getByName(String name)
    {
        return CalculationMode.valueOf(name);
    }
}
