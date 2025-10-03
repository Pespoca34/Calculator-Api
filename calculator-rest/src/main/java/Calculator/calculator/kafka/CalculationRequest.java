package Calculator.calculator.kafka;

public class CalculationRequest {
    private String operator;
    private double a;
    private double b;

    public CalculationRequest(){}

    public CalculationRequest(String operator, double a, double b){
        this.operator = operator;
        this.a = a;
        this.b = b;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }
}
