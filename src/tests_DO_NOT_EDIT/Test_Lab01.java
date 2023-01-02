package tests_DO_NOT_EDIT;

import org.junit.jupiter.api.*;
import labs.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class Test_Lab01 {

	public static InOutMimic inOut;
	
	@BeforeAll
	static void beforeAll() {
		inOut = new InOutMimic();
	}
	
	
	@Test
	@DisplayName("Test Problem #1")
	void test1() {
		String problemNumber = "Problem #1";
		
		String[][] tests = {{"3\n5", "3^5 = 243.0"},
						    {"1\n5", "1^5 = 1.0"},
						    {"5\n3", "5^3 = 125.0"},
						    {"4\n5", "4^5 = "},
						    {"2\n5", "2^5 = 32.0"},
						    {"3\n-2", "3^-2 = 0.1111111111111111"}
						    };	
		
		
		int i = 0;
		String output = "";
		
		try {
			
			
			for (; i < tests.length; i ++) {
				
				inOut.resetOutputStream();
				inOut.overridePrintStatements();
				inOut.provideInput(String.valueOf(tests[i][0]));
				Lab01.problem1();
				
				assertTrue(inOut.getOutputStream().contains(tests[i][1]));
				
			}
			
			inOut.resetSystem();
			System.out.println("Test " + problemNumber + ": Passed all tests\n\n\n\n");

		}
		catch (AssertionError e) {
			inOut.resetSystem();
			
			System.out.println("Error " + problemNumber + ": "
					+ "\n   Failed test " + (i+1) + " of " + tests.length
					+ "\n   Input tested: " +  tests[i][0]
					+ "\n   Expected output: " + tests[i][1] 
					+ "\n   Your output: \n" + inOut.getOutputStream()
					+ "\n\n\n\n");
			fail();
		}
	}

	
	@Test
	@DisplayName("Test Problem #2")
	void test2() {
		String problemNumber = "Problem #2";
		
		int num = (int) (Math.random() * 50000) + 10000;
		double num2 = Math.sqrt(num);

		String[][] tests = {{"30", "The square root of 30 is 5.477225575051661"},
						    {"25", "The square root of 25 is 5.0"},
						    {"8", "The square root of 8 is 2.8284271247461903"},
						    {"95", "The square root of 95 is 9.746794344808963"},
						    {"12", "The square root of 12 is 3.4641016151377544"},
						    {"37", "The square root of 37 is 6.082762530298219"},
						    {String.valueOf(num), String.valueOf("The square root of " + num + " is " + num2)}
						    };	


		int i = 0;
		String output = "";
		
		try {
		
		
		for (; i < tests.length; i ++) {
			
			inOut.resetOutputStream();
			inOut.overridePrintStatements();
			inOut.provideInput(String.valueOf(tests[i][0]));
			Lab01.problem2();
			
			assertTrue(inOut.getOutputStream().contains(tests[i][1]));
			
		}
		
		inOut.resetSystem();
		System.out.println("Test " + problemNumber + ": Passed all tests\n\n\n\n");
		
		}
		catch (AssertionError e) {
		inOut.resetSystem();
		
		System.out.println("Error " + problemNumber + ": "
				+ "\n   Failed test " + (i+1) + " of " + tests.length
				+ "\n   Input tested: " +  tests[i][0]
				+ "\n   Expected output: " + tests[i][1] 
				+ "\n   Your output: \n" + inOut.getOutputStream()
				+ "\n\n\n\n");
		fail();
		}
		
	}
	
	@Test
	@DisplayName("Test problem #3")
	void test3() {
		
		String problemNumber = "Problem #3";
		
		int num1 = (int) (Math.random() * 50000) + 10000;
		int num2 = (int) (Math.random() * 50000) + 10000;
		double num3 = Math.sqrt(Math.pow(num1, 2) + Math.pow(num2,  2));

		String[][] tests = {{"5\n7", "Hypotenuse = 8.602325267042627" },
						    {"7\n5", "Hypotenuse = 8.602325267042627" },
						    {"3\n4", "Hypotenuse = 5.0" },
						    {"12\n19", "Hypotenuse = 22.47220505424423" },
						    {"3\n12", "Hypotenuse = 12.36931687685298" },
						    {String.valueOf(num1+"\n"+num2), String.valueOf("Hypotenuse = " + num3)},
						    };	


		int i = 0;
		String output = "";
		
		try {
		
		
		for (; i < tests.length; i ++) {
			
			inOut.resetOutputStream();
			inOut.overridePrintStatements();
			inOut.provideInput(String.valueOf(tests[i][0]));
			Lab01.problem3();
			
			assertTrue(inOut.getOutputStream().contains(tests[i][1]));
			
		}
		
		inOut.resetSystem();
		System.out.println("Test " + problemNumber + ": Passed all tests\n\n\n\n");
		
		}
		catch (AssertionError e) {
		inOut.resetSystem();
		
		System.out.println("Error " + problemNumber + ": "
				+ "\n   Failed test " + (i+1) + " of " + tests.length
				+ "\n   Input tested: " +  tests[i][0]
				+ "\n   Expected output: " + tests[i][1] 
				+ "\n   Your output: \n" + inOut.getOutputStream()
				+ "\n\n\n\n");
		fail();
		}
		
	}
	
	
	
	
	@Test
	@DisplayName("Test problem #4")
	void test4() {
		
		String problemNumber = "Problem #4";
		String input = "";
		int num = 0;
		int num1 = -200;
		int num2 = 200;
		for (int i = 0; i < 20; i++) {
			num = (int) (Math.random() * 200) - 100;
			if (num == 0) num = 1;
			input += num + "\n";
			num1 = Math.max(num1, num);
			num2 = Math.min(num2, num);
		}
		input += "0";

		String[][] tests = {{"4\n9\n-3\n0", "Max = 9\nMin = -3" },
							{"-5\n-2\n-8\n-16\n0", "Max = 0\nMin = -16" },
							{"4\n9\n37\n0", "Max = 37\nMin = 0" },
						    {String.valueOf(input), String.valueOf("Max = " + num1 + "\nMin = " +  + num2)},
						    };	


		int i = 0;
		String output = "";
		
		try {
		
		
		for (; i < tests.length; i ++) {
			
			inOut.resetOutputStream();
			inOut.overridePrintStatements();
			inOut.provideInput(String.valueOf(tests[i][0]));
			Lab01.problem4();
			
			assertTrue(inOut.getOutputStream().contains(tests[i][1]));
			
		}
		
		inOut.resetSystem();
		System.out.println("Test " + problemNumber + ": Passed all tests\n\n\n\n");
		
		}
		catch (AssertionError e) {
		inOut.resetSystem();
		
		System.out.println("Error " + problemNumber + ": "
				+ "\n   Failed test " + (i+1) + " of " + tests.length
				+ "\n   Input tested: " +  tests[i][0]
				+ "\n   Expected output: " + tests[i][1] 
				+ "\n   Your output: \n" + inOut.getOutputStream()
				+ "\n\n\n\n");
		fail();
		}
		
	}
	
	

	
}
