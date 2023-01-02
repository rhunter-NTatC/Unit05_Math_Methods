package tests_DO_NOT_EDIT;

import org.junit.jupiter.api.*;
import labs.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Arrays;

class Test_Lab02 {

	public static InOutMimic inOut;
	
	@BeforeAll
	static void beforeAll() {
		inOut = new InOutMimic();
	}

	
	@Test
	@DisplayName("Test problem #1")
	void test1() {
		String problemNumber = "Problem #1";
		
		String[][] tests = {{"27", "14"},
							{"14", "27"},
							{"12", "18"},
							{"-2", "89"},
							{"4", "140"},
							{"67", "18"},
							};


		int i = 0, min = 0, max = 0;
		boolean upperbound = true;
		boolean lowerbound = true;
		String test = "";
		int tooHigh = 0;
		String[] output = {""};

		try {

			for (; i < tests.length; i++) {
				upperbound = true;
				lowerbound = true;
				max = Math.max(Integer.valueOf(tests[i][0]), Integer.valueOf(tests[i][1]));
				min = Math.min(Integer.valueOf(tests[i][0]), Integer.valueOf(tests[i][1]));
				test = String.valueOf(tests[i][0] + "\n" + tests[i][1]);
				inOut.resetOutputStream();
				inOut.overridePrintStatements();
				inOut.provideInput(test);
				Lab02.problem1();
				
				output = inOut.getOutputStream().split(" ");
				
				for (int j = 8; j < 108; j++) {
					if (Integer.valueOf(output[j]) < min) {
						tooHigh++;
						lowerbound = false;
					}
					if (Integer.valueOf(output[j]) > max) {
						upperbound = false;
					}
				}
				
				assertTrue(lowerbound);
				assertTrue(upperbound);

			}

			inOut.resetSystem();
			
			System.out.println("Test " + problemNumber + ": Passed all tests\n\n\n\n");

		} catch (Error e) {
			inOut.resetSystem();
			String error = "";
			if (!upperbound) {
				error += "Output too high\n   ";
			}
			if (!lowerbound) {
				error += "Output too low\n   ";
			}
			
			System.out.println("Error " + problemNumber + ": " 
							+ "\n   Failed test " + (i + 1) + " of " + tests.length
							+ "\n   Input tested: " + tests[i][0] + " and " + tests[i][1]
							+ "\n   " + error
							+ "Your output: \n" + inOut.getOutputStream()
							+ "\n\n\n\n");
			fail();
		}
		
	}
	
	
	@Test
	@DisplayName("Test problem #2")
	void test2() {
		String problemNumber = "Problem #2";
		
		String[][] tests = {{"10\n8", "2513.274122871834"},
							{"14\n2.5", "1539.380400258998"},
							{"0.3\n1.7", "0.480663675999238"},
							{"14\n3.7", "2278.28299238331"},
							{"2.75\n5", "118.7914722138640"},
							};

				
		int i = 0;
		
		try {

			for (; i < tests.length; i++) {
				
				inOut.resetOutputStream();
				inOut.overridePrintStatements();
				inOut.provideInput(tests[i][0]);
				Lab02.problem2();

				assertTrue(inOut.getOutputStream().contains(tests[i][1]));

			}
			int count = 0;
			for (int j = 0; j < tests.length; j++) {
				if (inOut.getOutputStream().contains(tests[j][1])) {
					count++;
				}
			}
			if (count == tests.length) {
				throw new RuntimeException("huh?");
			}
			
			
			inOut.resetSystem();

			System.out.println("Test " + problemNumber + ": Passed all tests\n\n\n\n");

		} catch (Exception e) {
			inOut.resetSystem();
			System.out.println("Error " + problemNumber + ": " 
					   + "\n   Something tells me you cheated on this one."
					   + "\n\n\n\n");
	
			fail();
		} catch (Error e) {
			inOut.resetSystem();
			
			System.out.println("Error " + problemNumber + ": " 
					+ "\n   Failed test " + (i + 1) + " of " + tests.length 
					+ "\n   Input tested: " + tests[i][0] 
					+ "\n   Expected Output Should Contain: " + tests[i][1]
					+ "\n   Your output: \n" + inOut.getOutputStream() 
					+ "\n\n\n\n");
			fail();
		}
		
	}
	
	
	@Test
	@DisplayName("Test problem #3")
	void test3() {
		String problemNumber = "Problem #3";
		
		String[][] tests = {{"2\n3\n5\n7", "Distance between points = 5.0"},
							{"1.2\n2.3\n5.7\n-8", "Distance between points = 11.24010676105881"},
							{"12\n-15.8\n28\n-16", "Distance between points = 16.0012499511756"},
							{"1\n1\n1\n50", "Distance between points = 49.0"},
							{"-2.3\n5.7\n4.8\n-8.4", "Distance between points = 15.78670326572334"},
							{"-1\n-2\n-3\n-4", "Distance between points = 2.828427124746190"},
							};
				

	
		int i = 0;
		boolean huh = false;
		
		try {
		
			for (; i < tests.length; i++) {
				
				inOut.resetOutputStream();
				inOut.overridePrintStatements();
				inOut.provideInput(tests[i][0]);
				Lab02.problem3();
			
				assertTrue(inOut.getOutputStream().contains(tests[i][1]));
			
			}
			
			int count = 0;
			for (int j = 0; j < tests.length; j++) {
				if (inOut.getOutputStream().contains(tests[j][1])) {
					count++;
				}
			}
			if (count == tests.length) {
				huh = true;
				throw new RuntimeException("huh?");
			}
			
			
			inOut.resetSystem();
			
			System.out.println("Test " + problemNumber + ": Passed all tests\n\n\n\n");
		
		} catch (Exception e) {
			inOut.resetSystem();
			System.out.println("Error " + problemNumber + ": " 
					   + "\n   Something tells me you cheated on this one."
					   + "\n\n\n\n");
	
			fail();
		} catch (Error e) {
			inOut.resetSystem();
			
			if (huh) {
				System.out.println("Error " + problemNumber + ": " 
								   + "\n   Something tells me you cheated on this one."
								   + "\n\n\n\n");
				
				fail();
			}
		
		
			System.out.println("Error " + problemNumber + ": " 
					+ "\n   Failed test " + (i + 1) + " of " + tests.length 
					+ "\n   Input tested: " + tests[i][0] 
					+ "\n   Expected Output Should Contain: " + tests[i][1]
					+ "\n   Your output: \n" + inOut.getOutputStream() 
					+ "\n\n\n\n");
			fail();
		}
		
		
	}
	
	
	@Test
	@DisplayName("Test problem #4")
	void test4() {
		String problemNumber = "Problem #4";
		
		String[][] tests = {{"2\n-14\n24", "4.0", "3.0"},
							{"3\n3\n-36", "-4.0", "3.0"},
							{"2\n-9\n-35", "7.0", "-2.5"},
							{"-3.23\n5.7\n9.8", "-1.070235709911348", "2.834941592264289"},
							{"4\n16\n9", "-0.677124344467704", "-3.322875655532295"},
							{"7.2\n1\n-2", "0.4621572002501288", "-0.601046089139017"},
							{"5\n7\n-3", "0.3440306508910550", "-1.744030650891055"},
							{"0.2\n5\n0.4", "-0.0802576516257791", "-24.9197423483742"},
							{"1\n8\n3", "-0.394448724536010", "-7.60555127546399"},
							};
	


		int i = 0;
		boolean huh = false;
		
		try {
		
			for (; i < tests.length; i++) {
				
				inOut.resetOutputStream();
				inOut.overridePrintStatements();
				inOut.provideInput(tests[i][0]);
				Lab02.problem4();
			
				assertTrue(inOut.getOutputStream().contains(tests[i][1]));
				assertTrue(inOut.getOutputStream().contains(tests[i][2]));
			
			}
			
			int count = 0;
			for (int j = 0; j < tests.length; j++) {
				if (inOut.getOutputStream().contains(tests[j][1])
					&& inOut.getOutputStream().contains(tests[j][2])) {
					count++;
				}
			}
			if (count == tests.length) {
				huh = true;
				throw new RuntimeException("huh?");
			}
			
			
			inOut.resetSystem();
			
			System.out.println("Test " + problemNumber + ": Passed all tests\n\n\n\n");
			
		} catch (Exception e) {
			inOut.resetSystem();
			System.out.println("Error " + problemNumber + ": " 
					   + "\n   Something tells me you cheated on this one."
					   + "\n\n\n\n");
			
			fail();
		} catch (Error e) {
			inOut.resetSystem();
			
			if (huh) {
				System.out.println("Error " + problemNumber + ": " 
								   + "\n   Something tells me you cheated on this one."
								   + "\n\n\n\n");
				
				fail();
			}
			
			
			System.out.println("Error " + problemNumber + ": " 
					+ "\n   Failed test " + (i + 1) + " of " + tests.length 
					+ "\n   Input tested: " + tests[i][0] 
					+ "\n   Expected Output Should Contain: "
					+ "\n      x1 = " + tests[i][1]
					+ "\n      x2 = " + tests[i][2]
					+ "\n   Your output: \n" + inOut.getOutputStream() 
					+ "\n\n\n\n");
			fail();
		}
		
		
	}
	
	
}
