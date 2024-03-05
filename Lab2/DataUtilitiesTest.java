package org.jfree.data.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class DataUtilitiesTest {
	private Values2D values2D;
	DefaultKeyedValues2D data;
	/*@Before
	public void setUp() {
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		values2D = testValues;
		testValues.addValue(1, 0, 0);
		testValues.addValue(4, 1, 0);
	} */
	
	@Before
	public void setUp() {
	 data = new DefaultKeyedValues2D();
	values2D = data;
	
	}
	
	

	@After
	public void tearDown() {
		values2D = null;
	} 
/*
	@Test
	public void testValidDataAndColumnColumnTotal() {
		assertEquals("Wrong sum returned. It should be 5.0", 5.0, DataUtilities.calculateColumnTotal(values2D, 0),
				0.0000001d);
	}
	
	@Test
	public void testNullDataColumnTotal() 
	{ 
	try
	 { 
	 DataUtilities.calculateColumnTotal(null, 0); 
	 fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException"); 
	 } 
	catch (Exception e) 
	 { 
	 assertTrue("Incorrect exception type thrown", 
	 e.getClass().equals(IllegalArgumentException.class)); 
	 } 
	} */
	  // Method to test calculateColumnTotal method and print results
   
	@Test
	public void testCalculateColumnTotal_Case1StandardInput() {
	    // Test Case 1: Regular matrix
	    data.addValue(1, 2, 3);
	    data.addValue(4, 5, 6);
	    int column = 1;
	    double expectedOutcome = 7; //2+5 =7
	    assertEquals(expectedOutcome, DataUtilities.calculateColumnTotal(values2D, column), 0.0001);
	}
	@Test
	public void testCalculateColumnTotal_Case2Negative() {
	    data.addValue(-1, 2, 3);
	    data.addValue(4, 5, 6);
	    int column = 0;
	    double expectedOutcome = 3; //4+-1 =3
	    assertEquals(expectedOutcome, DataUtilities.calculateColumnTotal(values2D, column), 0.0001);
	}
	@Test
	public void testCalculateColumnTotal_OutOfBoundsPositive() {
	    data.addValue(1, 2, 3);
	    data.addValue(4, 5, 6);
	    int column = 7;
	    
	    try {
	        DataUtilities.calculateColumnTotal(values2D, column);
	        
	        fail("Expected an IndexOutOfBoundsException to be thrown");
	    } catch (IndexOutOfBoundsException e) {
	     
	       assertEquals("Index 7 out of bounds for length 2", e.getMessage());
	    }
	 
	}
	@Test
	public void testCalculateColumnTotal_OutOfBoundsNegatives() {
	    data.addValue(1, 2, 3);
	    data.addValue(4, 5, 6);
	    int column = -1; 

	    
	    try {
	        DataUtilities.calculateColumnTotal(values2D, column);
	       
	        fail("Expected an IndexOutOfBoundsException to be thrown");
	    } catch (IndexOutOfBoundsException e) {
	     
	       assertEquals("Index -1 out of bounds for length 2", e.getMessage());
	    }
	}

	
	//TEST calculateRowTotal
	@Test
	public void testCalculateRowTotal_Case1() {
	    data.addValue(1, 2, 3);
	    data.addValue(4, 5, 6);
	    int column = 1;
	    double expectedOutcome = 15; //4+5+6 =15
	    assertEquals(expectedOutcome, DataUtilities.calculateRowTotal(values2D, column), 0.0001);
	}
	
	@Test
	public void testCalculateRowTotal_Case2NegativeValue() {
	    data.addValue(1, 2, 3);
	    data.addValue(4, -5, 6);
	    int column = 1;
	    double expectedOutcome = 7; //4+-5+6 =7
	    assertEquals(expectedOutcome, DataUtilities.calculateRowTotal(values2D, column), 0.0001);
	}
	@Test
	public void testCalculateRowTotal_Case3OutOfBoundsPositive() {
	    data.addValue(1, 2, 3);
	    data.addValue(4, 5, 6);
	    data.addValue(4, 5, 6);
	    int column = 7; // Index out of bounds

	    
	    try {
	        DataUtilities.calculateRowTotal(values2D, column);
	        
	        fail("Expected an IndexOutOfBoundsException to be thrown");
	    } catch (IndexOutOfBoundsException e) {
	    	assertEquals("Index 7 out of bounds for length 2", e.getMessage());
	    }
	}
	@Test
	public void testCalculateRowTotal_Case3OutOfBoundsNegative() {
	    data.addValue(1, 2, 3);
	    data.addValue(4, 5, 6);
	    data.addValue(4, 5, 6);
	    int column = -1; // Negative index, out of bounds

	    
	    try {
	        DataUtilities.calculateRowTotal(values2D, column);
	       
	        fail("Expected an IndexOutOfBoundsException to be thrown");
	    } catch (IndexOutOfBoundsException e) {
	        assertEquals("Index -1 out of bounds for length 2", e.getMessage());
	    }
	}

	
//Testing createNumberArray
	  
	    @Test
	    public void testCreateNumberArray_Case1StandardInput() {
	        //input array of double primitives
	        double[] inputData = {1.0, 2.0, 3.0};
	        
	        // Expected outcome: array of Number objects
	        Number[] expectedOutcome = {1.0, 2.0, 3.0};
	        
	        // convert double array to Number array
	        Number[] actualOutcome = DataUtilities.createNumberArray(inputData);
	        
	        
	        for (int i = 0; i < actualOutcome.length; i++) {
	            assertEquals("Element at index " + i + " should match", expectedOutcome[i], actualOutcome[i]);
	        }
	    
	}
	    
	    @Test
	    public void testCreateNumberArray_Case2StandardInput() {
	        // input array of double primitives
	        double[] inputData = {1.0, 2.0, 3.0, 4.0, 5.0};
	        
	        // Expected outcome: array of Number objects
	        Number[] expectedOutcome = {1.0, 2.0, 3.0, 4.0, 5.0};
	        
	        //convert double array to Number array
	        Number[] actualOutcome = DataUtilities.createNumberArray(inputData);
	        
	        
	        for (int i = 0; i < actualOutcome.length; i++) {
	            assertEquals("Element at index " + i + " should match", expectedOutcome[i], actualOutcome[i]);
	        }
	    
	}
	    
	    @Test
	    public void testCreateNumberArray_Case3Negatives() {
	        //input array of double primitives
	        double[] inputData = {-1.0, -2.0, -3.0};
	        
	        // Expected outcome: array of Number objects
	        Number[] expectedOutcome = {-1.0, -2.0, -3.0};
	        
	        //convert double array to Number array
	        Number[] actualOutcome = DataUtilities.createNumberArray(inputData);
	        
	        
	        for (int i = 0; i <=actualOutcome.length; i++) {
	            assertEquals("Element at index " + i + " should match", expectedOutcome[i], actualOutcome[i]);
	        }
	    
	}
	  

	  //Testing createNumberArray2D
	    
	    
	    @Test
        public void testCreateNumberArray2D_Case1StandardInput() {
            // input data
            double[][] data = {{1.0, 2.0}, {3.0, 4.0}, {5.0, 6.0}};
            
            // Expected outcome
            Number[][] expected = {{1.0, 2.0}, {3.0, 4.0}, {5.0, 6.0}};
            
            
            Number[][] actual = DataUtilities.createNumberArray2D(data);
     
     
            
            for (int i = 0; i < expected.length; i++) {
                assertArrayEquals("Sub-array at index " + i + " should match the expected values.", expected[i], actual[i]);
            }
        }
	  

	        @Test
	        public void testCreateNumberArray2D_Case2DifferentSizedArrays() {
	            // Setup input data
	            double[][] data = {{1.0, 2.0, 3.0, 4.0}, {1.0, 2.0, 3.0}};
	            
	            // Expected outcome
	            Number[][] expected = {{1.0, 2.0, 3.0, 4.0}, {1.0, 2.0, 3.0}, };
	            
	           
	            Number[][] actual = DataUtilities.createNumberArray2D(data);
	     
	     
	            
	            for (int i = 0; i < expected.length; i++) {
	                assertArrayEquals("Sub-array at index " + i + " should match the expected values.", expected[i], actual[i]);
	            }
	        }
	        
	        @Test
	        public void testCreateNumberArray2D_Case3Zeros() {
	            // Setup input data
	            double[][] data = {{0.0, 0.0}, {0.0, 0.0}, {0.0, 0.0}};
	            
	            // Expected outcome
	            Number[][] expected = {{0.0, 0.0}, {0.0, 0.0}, {0.0, 0.0}};
	            
	            
	            Number[][] actual = DataUtilities.createNumberArray2D(data);
	            
	            
	            for (int i = 0; i < expected.length; i++) {
	                assertArrayEquals("Sub-array at index " + i + " should match the expected values.", expected[i], actual[i]);
	            }
	        }
	        
	        @Test
	        public void testCreateNumberArray2D_Case4EmptyArray() {
	            // Setup input data
	            double[][] data = {{}, {}, {}};
	            
	            // Expected outcome
	            Number[][] expected = {{}, {}, {}};
	            
	           
	            Number[][] actual = DataUtilities.createNumberArray2D(data);
	            
	            
	            for (int i = 0; i < expected.length; i++) {
	                assertArrayEquals("Sub-array at index " + i + " should match the expected values.", expected[i], actual[i]);
	            }
	        }
	        
	        
	        
	        //Testing getCumulativePercentages()
	        @Test
	        public void testGetCumulativePercentages_Case1StandardInput() {
	            // Initialize a KeyedValues object with test data
	            DefaultKeyedValues keyValues = new DefaultKeyedValues();
	            keyValues.addValue("Key1", 5); 
	            keyValues.addValue("Key2", 9);
	            keyValues.addValue("Key3", 2);

	            // Expected cumulative percentages
	            double[] expectedPercentages = {0.3125, 0.875, 1.0}; 

	            // Execute the method under test
	            KeyedValues cumulativePercentages = DataUtilities.getCumulativePercentages(keyValues);

	            // Verify the results
	            for (int i = 0; i < keyValues.getItemCount(); i++) {
	                double expected = expectedPercentages[i];
	                double actual = cumulativePercentages.getValue(i).doubleValue();
	                assertEquals("Cumulative percentage for key " + i + " should match expected value.", expected, actual, 0.0001);
	            }
	        }

	        @Test
	        public void testGetCumulativePercentages_Case2Negatives() {
	            // Initialise a KeyedValues object with test data
	            DefaultKeyedValues keyValues = new DefaultKeyedValues();
	            keyValues.addValue("Key1", -5); 
	            keyValues.addValue("Key2", 9);
	            keyValues.addValue("Key3", 2);

	            // Expected cumulative percentages
	            double[] expectedPercentages = {-0.3125, 0.25, 0.375}; 

	            // Execute the method under test
	            KeyedValues cumulativePercentages = DataUtilities.getCumulativePercentages(keyValues);

	            // Verify the results
	            for (int i = 0; i < keyValues.getItemCount(); i++) {
	                double expected = expectedPercentages[i];
	                double actual = cumulativePercentages.getValue(i).doubleValue();
	                assertEquals("Cumulative percentage for key " + i + " should match expected value.", expected, actual, 0.0001);
	            }
	        }
	        @Test
	        public void testGetCumulativePercentages_Case3SingleValue() {
	            // Initialize a KeyedValues object with test data
	            DefaultKeyedValues keyValues = new DefaultKeyedValues();
	            keyValues.addValue("Key1", 5); 


	            // Expected cumulative percentages
	            double[] expectedPercentages = {1.0}; 

	            // Execute the method under test
	            KeyedValues cumulativePercentages = DataUtilities.getCumulativePercentages(keyValues);

	            // Verify the results
	            for (int i = 0; i < keyValues.getItemCount(); i++) {
	                double expected = expectedPercentages[i];
	                double actual = cumulativePercentages.getValue(i).doubleValue();
	                assertEquals("Cumulative percentage for key " + i + " should match expected value.", expected, actual, 0.0001);
	            }
	        }
	        
	        @Test
	        public void testGetCumulativePercentages_Case4StandardInputIncludingZero() {
	            // Initialize a KeyedValues object with test data
	            DefaultKeyedValues keyValues = new DefaultKeyedValues();
	            keyValues.addValue("Key1", 5); 
	            keyValues.addValue("Key2", 9); 
	            keyValues.addValue("Key3", 0); 


	            // Expected cumulative percentages
	            double[] expectedPercentages = {0.357,1.0, 1.0}; 

	            // Execute the method under test
	            KeyedValues cumulativePercentages = DataUtilities.getCumulativePercentages(keyValues);

	            // Verify the results
	            for (int i = 0; i < keyValues.getItemCount(); i++) {
	                double expected = expectedPercentages[i];
	                double actual = cumulativePercentages.getValue(i).doubleValue();
	                assertEquals("Cumulative percentage for key " + i + " should match expected value.", expected, actual, 0.0001);
	            }
	        }
}
    

	



	



