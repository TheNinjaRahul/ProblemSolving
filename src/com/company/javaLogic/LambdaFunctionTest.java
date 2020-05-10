package com.company.javaLogic;


import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

@FunctionalInterface
interface I1{
    public void m1();

}


interface I2{
    default  public void m1(){
        System.out.println("M1 overridden");
    }


    default  public void m2() {
        System.out.println("M2 overridden");
    }
}
public class LambdaFunctionTest  implements  I1,I2{
    public static void main(String[] args) {
        LambdaFunctionTest i=new LambdaFunctionTest();
        i.m4( () -> {
            System.out.println("Data");
        });
    }

    public void m4(I1 i){
        System.out.println("M4 called");
    }
    public void m1() {

    }

    public void m2() {

    }
}
