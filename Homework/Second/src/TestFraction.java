public class TestFraction{
    public static void main(String args[]){
        Fraction test1 = new Fraction();
        Fraction test2 = new Fraction();
        Fraction test3 = new Fraction();
        test1.reset();
        System.out.println(test1.getNum());
        test2.setFraction(1,2);
        System.out.println(test2.getDen());
        test3.setFraction(1, 4, -1);
        System.out.println(test3.getSign());
        test1.setNum(2);
        test2.setDen(5);
        test3.setSign(1);
        System.out.println(test2.add(test3));
        System.out.println(test2.subtract(test3));  
        System.out.println(test2.multiply(test3));
        System.out.println(test2.divide(test3));
        test3.setFraction(4,6,1);
        System.out.println(test2.simplify(test3));
        test3.setFraction(4,6,1);
        System.out.println(test3.simplifyInPlace());
        System.out.println(test3.equals(test3));
        System.out.println(test3.toString());
        test2.doubleValue();
        System.out.println(test2.compareTo(test3));
    }
}
