import java.lang.Math;
public class Fraction extends Number implements Comparable<Fraction>{
    private int numerator;
    private int denominator;
    private int sign;
    
    
    public void reset(){
        this.numerator = 1;
        this.denominator = 1;
        this.sign = 1;
    }
    public void setFraction(int numerator, int denominator, int sign){
        if(denominator == 0){
            throw new IllegalArgumentException("Argument 'denominator' is 0");
        }
        this.numerator = Math.abs(numerator);
        this.denominator = Math.abs(denominator);
        this.sign = sign;
    }
    public void setFraction(int numerator, int denominator){
        this.numerator = Math.abs(numerator);
        this.denominator = Math.abs(denominator);
        this.sign = 1;
    }
    public int getNum() {
        return this.numerator;
    }
    public int getDen() {
        return this.denominator;
    }
    public int getSign(){
        return this.sign;
    }
    public void setNum(int Num) {
        if(Num >= 0){
            this.numerator = Num;
        }else{
            throw new IllegalArgumentException("Unable to set numerator to " + Num + "; only positive values is/are allow.");
        }
    }
    public void setDen(int Den) {
        this.denominator = Den;
    }
    public void setSign(int sign){
        if(sign == 1 || sign == -1){
            this.sign = sign;
        }else{
            throw new IllegalArgumentException("Unable to set numerator to " + sign + "; only -1 for negative and 1 for positive are allow.");
        }
    }
    public Fraction add(Fraction toAdd){
        if(this.denominator == toAdd.denominator){
            this.numerator += toAdd.numerator;
            this.sign *= toAdd.sign;
        }else{
            int newDenom = this.denominator * toAdd.denominator;
            int newNum = this.numerator * toAdd.denominator + toAdd.numerator * this.denominator;
            this.numerator = newNum;
            this.denominator = newDenom;
            this.sign *= toAdd.sign;
        }
        return this.simplifyInPlace();
    }
    public Fraction subtract(Fraction toSub){
        if(this.denominator == toSub.denominator){
            this.numerator -= toSub.numerator;
            this.sign *= toSub.sign;
        }else{
            int newDenom = this.denominator * toSub.denominator;
            int newNum = this.numerator * toSub.denominator - toSub.numerator * this.denominator;
            this.numerator = newNum;
            this.denominator = newDenom;
            this.sign *= toSub.sign;
        }
        return this.simplifyInPlace();
    }
    public Fraction multiply(Fraction toMult){
        this.numerator *= toMult.numerator;
        this.denominator *= toMult.denominator;
        this.sign *= toMult.sign;
        return this.simplifyInPlace();
    }
    public Fraction divide(Fraction toDiv){
        this.numerator *= toDiv.denominator;
        this.denominator *= toDiv.numerator;
        this.sign *= toDiv.sign;
        return this.simplifyInPlace();
    }
    public Fraction simplify(Fraction toSimplify){
        int gcd = GreatestCommonDivisor.gcd_r(toSimplify.numerator, toSimplify.denominator);
        this.numerator = toSimplify.numerator / gcd;
        this.denominator = toSimplify.denominator / gcd;
        return toSimplify;
    }
    public Fraction simplifyInPlace(){
        int gcd = GreatestCommonDivisor.gcd_r(this.numerator, this.denominator);
        this.numerator /= gcd;
        this.denominator /= gcd;
        return this;
    }
    @Override
    public boolean equals(Object test){
        if(test.getClass() == this.getClass()){
            Fraction temp1 = (Fraction)test;
            if(temp1.numerator/temp1.denominator == this.numerator/this.denominator){
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString(){
        if(sign == 1){
            return "Fraction " + this.numerator +"/" + this.denominator;
        }else{
            return "Fraction -" + this.numerator +"/" + this.denominator;
        }
        
    }
    @Override
    public int intValue() {
        return numerator / denominator;
    }

    @Override
    public long longValue() {
        return (long) numerator / denominator;
    }

    @Override
    public float floatValue() {
        return (float) numerator / denominator;
    }

    @Override
    public double doubleValue() {
        return (double) numerator / denominator;
    }

    // Implement compareTo method for Comparable interface
    @Override
    public int compareTo(Fraction other) {
        // To compare fractions, you can cross-multiply and compare the results
        int thisNumerator = this.numerator * other.denominator;
        int otherNumerator = other.numerator * this.denominator;

        return Integer.compare(thisNumerator, otherNumerator);
    }
}