package com.techelevator.calculator;

public class CalculatorApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Calculator calculator = new Calculator(0);
		
		ScientificCalculator scientificCalculator = new ScientificCalculator(0);
	
		TrignometricCalculator trigCalc = new TrignometricCalculator();
		
		// Can cast to any superclass higher in the hierarchy
		// This is widening to it is implicit and for classes is call upcasting
		Calculator scientificCalculatorAsCalculator = scientificCalculator;
		Object trigCalcAsObj = trigCalc;
		
		
		// Can cast from a superclass to a subclass as long as the object IS-A of the subclass
		// being cast to.  This is narrowing so explicit and for classes called downcasting
		ScientificCalculator sci2 = (ScientificCalculator) scientificCalculatorAsCalculator;
		
		// This line will fail during runtime because calculator was never a scientificcalculator
		//ScientificCalculator goingToFail = (ScientificCalculator) calculator;
		
		
		// Safe downcasting using instanceof
		if (scientificCalculatorAsCalculator instanceof ScientificCalculator) {
			ScientificCalculator sci3 = (ScientificCalculator) scientificCalculatorAsCalculator;
		}
		
	}
	
	@Override
	public boolean equals(Object obj) {
		
		// instanceof will return true if the object can be cast (so IS-A) to the data type given
		//   object instanceof class
		if (obj instanceof Calculator) {
			Calculator objAsCalculator = (Calculator) obj;
		}
		
		// returning false just to get ride of the Eclipse error
		return false;
	}
}
