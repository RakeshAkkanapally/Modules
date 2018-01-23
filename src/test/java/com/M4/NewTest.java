package com.M4;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import com.epam.tat.module4.Calculator;

public class NewTest {

  private Calculator calculator=new Calculator();

  @BeforeMethod
  public void beforeMethod() {
	  Reporter.log("\nStarting Test method...");
  }

  @AfterMethod
  public void afterMethod() {
	  Reporter.log("Test method Complete...");
  }
  
  @Test(groups={"Sanity"})
  public void addingTwoPositiveNumbers() {
	  long a=10;
	  long b=20;
	  long sum=calculator.sum(a, b);
	  Reporter.log("a:"+a+"\t b:"+b+"\t sum:"+sum);
	  
	  Assert.assertEquals(sum, a+b);
	  
  }
  
  @Test()
  public void addingPositiveAndNegativeNumbers() {
	  long a=10;
	  long b=-20;
	  long sum=calculator.sum(a, b);
	  Reporter.log("a:"+a+"\t b:"+b+"\t sum:"+sum);
	  
	  Assert.assertEquals(sum, a+b);
	  
  }
  
  @Test()
  public void addingNegativeAndPositiveNumbers() {
	  long a=-10;
	  long b=20;
	  long sum=calculator.sum(a, b);
	  Reporter.log("a:"+a+"\t b:"+b+"\t sum:"+sum);
	  
	  Assert.assertEquals(sum, a+b);
	  
  }

  @Test(groups={"Sanity"})
  public void subtractingTwoNumbers() {
	  long a=10;
	  long b=20;
	  long diff=calculator.sub(a, b);
	  Reporter.log("a:"+a+"\t b:"+b+"\t diff:"+diff);
	  
	  Assert.assertEquals(diff, a-b);
	  
  }
  
  @Test()
  public void subtractingNegativeAndPositiveNumbers() {
	  long a=-10;
	  long b=20;
	  long diff=calculator.sub(a, b);
	  Reporter.log("a:"+a+"\t b:"+b+"\t diff:"+diff);
	  
	  Assert.assertEquals(diff, a-b);
	  
  }
  
  @Test()
  public void subtractingPositiveAndNegativeNumbers() {
	  long a=10;
	  long b=-20;
	  long diff=calculator.sub(a, b);
	  Reporter.log("a:"+a+"\t b:"+b+"\t diff:"+diff);
	  
	  Assert.assertEquals(diff, a-b);
	  
  } 
  
  @Test(expectedExceptions={NumberFormatException.class},groups={"Negative"},dependsOnGroups={"Sanity"})
  public void divideByZero() {
	  long a=10;
	  long b=0;
	  long quotient=calculator.div(a, b);
	  Reporter.log("a:"+a+"\t b:"+b+"\t quotient:"+quotient);
	  
	  Assert.assertEquals(quotient, a/b);
	  
  }   

  @Test(groups={"Negative"},dependsOnGroups={"Sanity"})
  public void divideZerobyANumber() {
	  long a=0;
	  long b=1;
	  long quotient=calculator.div(a, b);
	  Reporter.log("a:"+a+"\t b:"+b+"\t quotient:"+quotient);
	  
	  Assert.assertEquals(quotient, a/b);
	  
  }
  @Test(expectedExceptions={NumberFormatException.class},groups={"Negative"},dependsOnGroups={"Sanity"})
  public void squareRootOfNegativeNumber() {
	  long a=-25;
	  double SquareRoot=calculator.sqrt(a);
	  Reporter.log("a:"+a+"\t SquareRoot:"+SquareRoot);
	  
	  Assert.assertEquals(SquareRoot, Math.sqrt(SquareRoot));
	  
  } 
  @Test(groups={"Negative"},dependsOnGroups={"Sanity"})
  public void cosine() {
	  long a=0;
	  double cos=calculator.cos(a);
	  Reporter.log("a:"+a+"\t cos:"+cos);
	  
	  Assert.assertEquals(cos, Math.cos(a));
	  
  } 
  
  @Test(groups={"Negative"},dependsOnGroups={"Sanity"})
  public void isPositive() {
	  long a=-1;
	  boolean IsPositive=calculator.isPositive(a);
	  Reporter.log("a:"+a+"\t IsPositive:"+IsPositive);
	  
	  Assert.assertEquals(IsPositive, a>0);
	  
  } 
  
  @Test(groups={"Negative"},dependsOnGroups={"Sanity"})
  public void isNegative() {
	  long a=1;
	  boolean IsNegative=calculator.isNegative(a);
	  Reporter.log("a:"+a+"\t IsNegative:"+IsNegative);
	  
	  Assert.assertEquals(IsNegative, a<0);
	  
  } 
  
  @Test(groups={"Negative"},dependsOnGroups={"Sanity"},dataProvider="DataProviderValues")
  public void multiplyingNumbers(long a, long b, long c) {
	  long product=calculator.mult(a, b);
	  Reporter.log("a:"+a+"\t b:"+b+"\t product:"+product);
	  
	  Assert.assertEquals(product, c);
	  
  } 
  
  @DataProvider(name="DataProviderValues")
  public Object[][] Data(){
	  return new Object[][]{
			  {10,20,200},
			  {20,10,200},
			  {0,5,0},
			  {-5,0,0}
	  };
	  }
  
  
}
