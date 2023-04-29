package com.example.demo.entity;

public class Result {

    Params param;

    public Params getParam() {
        return param;
    }

    public void setParam(Params param) {
        this.param = param;
    }

    double sum;
    double sub;
    double mul;
    double div;
    public Result(double sum, double sub, double mul, double div,Params param){
        this.sum = sum;
        this.sub = sub;
        this.div = div;
        this.mul = mul;
        this.param = param;
    }
    public Result(){
        this.sum = 0;
        this.sub = 0;
        this.div = 0;
        this.mul = 0;
        this.param.setParam1(0);
        this.param.setParam2(0);
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public void setSub(double sub) {
        this.sub = sub;
    }

    public void setMul(double mul) {
        this.mul = mul;
    }

    public void setDiv(double div) {
        this.div = div;
    }
    public double getSub() {
        return sub;
    }

    public double getMul() {
        return mul;
    }

    public double getDiv() {
        return div;
    }

}
