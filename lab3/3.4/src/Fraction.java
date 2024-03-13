public class Fraction extends Number {
    private final int numerator;
    private final int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public String toString() {
        return String.format("%d/%d", this.numerator, this.denominator);
    }

    @Override
    public int intValue() {
        return this.numerator / this.denominator;
    }

    @Override
    public long longValue() {
        return (long) this.numerator / this.denominator;
    }

    @Override
    public float floatValue() {
        return (float) this.numerator / this.denominator;
    }

    @Override
    public double doubleValue() {
        return (double) this.numerator / this.denominator;
    }

    public int[] getNumeratorAndDenominator() {
        return new int[] {this.numerator, this.denominator};
    }

    public boolean equals(Object o) {
        if (o instanceof Fraction fraction) {
            int nod = NOD(this.numerator, this.denominator);

            int objectNumerator = fraction.getNumeratorAndDenominator()[0];
            int objectDenominator = fraction.getNumeratorAndDenominator()[1];
            int objectNod = NOD(objectNumerator, objectDenominator);

            return (this.numerator / nod == objectNumerator / objectNod)
                    && (this.denominator / nod == objectDenominator / objectNod);
        }
        return false;
    }

    public int hashCode() {
        int nod = NOD(this.numerator, this.denominator);
        int numerator = this.numerator / nod;
        int denominator = this.denominator / nod;
        return Float.hashCode((float) numerator / denominator);
    }

    public void print() {
        System.out.println(this);
    }

    public Fraction sum(Fraction other) {
        int resultNumerator = this.numerator *  other.denominator + other.numerator * this.denominator ;
        int resultDenominator = this.denominator * other.denominator;
        int nod = NOD(resultNumerator, resultDenominator);
        return new Fraction(resultNumerator / nod, resultDenominator / nod);
    }

    public Fraction sub(Fraction other) {
        int resultNumerator = this.numerator *  other.denominator - other.numerator * this.denominator ;
        int resultDenominator = this.denominator * other.denominator;
        int nod = NOD(resultNumerator, resultDenominator);
        return new Fraction(resultNumerator / nod, resultDenominator / nod);
    }

    public Fraction mul(Fraction other) {
        int resultNumerator = this.numerator * other.numerator;
        int resultDenominator = this.denominator * other.denominator;
        int nod = NOD(resultNumerator, resultDenominator);
        return new Fraction(resultNumerator / nod, resultDenominator / nod);
    }

    public Fraction division(Fraction other) {
        int resultNumerator = this.numerator * other.denominator;
        int resultDenominator = this.denominator * other.numerator;
        int nod = NOD(resultNumerator, resultDenominator);
        return new Fraction(resultNumerator / nod, resultDenominator / nod);
    }

    private int NOD(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        if (a == 0) {
            return b;
        }

        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        return a;
    }
}
