package org.jfree.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.jfree.data.Range;
import org.junit.*;

public class RangeTest {
	/**
	Examples from practical
	private Range rangeObjectUnderTest;

	@Before
	public void setUp() throws Exception {
		rangeObjectUnderTest = new Range(-1, 1);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	
	@Test
	public void testCentralValueShouldBeZero() {
		assertEquals("The central value of -1 and 1 should be 0", 0, rangeObjectUnderTest.getCentralValue(),
				0.000000001d);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testGetLengthBothPositiveAndEqual() {
		Range r1 = new Range(2, 2);
		assertEquals("getLength: Did not return the expected output", 0.0, r1.getLength());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testGetLengthBothPositiveAndNotEqual() {
		Range r2 = new Range(4, 9);
		assertEquals("getLength: Did not return the expected output", 5.0, r2.getLength());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testGetLengthBothNegativeAndEqual() {
		Range r3 = new Range(-99, -99);
		assertEquals("getLength: Did not return the expected output", 0.0, r3.getLength());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testGetLengthBothNegativeAndNotEqual() {
		Range r4 = new Range(-11, -4);
		assertEquals("getLength: Did not return the expected output", 7.0, r4.getLength());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testGetLengthOnePositiveOneNegative() {
		Range r5 = new Range(-5, 3);
		assertEquals("getLength: Did not return the expected output" + r5.getLength(), 8.0, r5.getLength());
	}
	**/
	
	@Test
	public void testGetLowerBoundValidRange() {
	    Range actual = new Range(2, 6);
	    double expected = 2;
	    double delta = 0.0001;

	    assertEquals("getLowerBound: Did not return the expected output of " + expected, 
	    		expected, actual.getLowerBound(), delta);
	}
	
	@Test
	public void testGetLowerBoundTestRangeIsNull() {
	    Range validRange = null;
	    
	    assertNull("getLowerBound: Expected null for a null range", validRange);
	}
	
	@Test
	public void testGetLowerBoundNegativeValue() {
	    Range actual = new Range(-2, 6);
	    double expected = -2;
	    double delta = 0.0001;

	    assertEquals("getLowerBound: Did not return the expected output of " + expected, 
	    		expected, actual.getLowerBound(), delta);
	}
	
	@Test
	public void testGetUpperBoundTestValidRange() {
	    Range actual = new Range(2, 6);
	    double expected = 6;
	    double delta = 0.0001;

	    assertEquals("getUpperBound: Did not return the expected output", 
	    		expected, actual.getUpperBound(), delta);
	}
	
	@Test
	public void testGetUpperBoundTestRangeIsNull() {
	    Range validRange = null;
	    
	    assertNull("getLowerRange: Expected null for a null range", validRange);
	}
	
	@Test
	public void testGetUpperBoundNegativeValue() {
	    Range actual = new Range(-6, -2);
	    double expected = -2;
	    double delta = 0.0001;

	    assertEquals("getUpperBound: Did not return the expected output of " + expected, 
	    		expected, actual.getUpperBound(), delta);
	}
	
	@Test
	public void testCombineRangesThatDoNotOverlap() {
	    Range range1 = new Range(2, 6);
	    Range range2 = new Range(8, 12);
	    Range expected = new Range(2, 12);
	    Range actual = null;
	    try {
	        actual = Range.combine(range1, range2);
	        
	    } catch (IllegalArgumentException e) {
	        fail("Combination failed unexpectedly with IllegalArgumentException: " + e.getMessage());
	    }
	    
	    assertEquals("Combine: Failed combining valid ranges with lower and upper bounds that do not overlap", 
	                     expected, actual);
	}
	
	@Test
	public void testCombineRangesThatOverlap() {
		Range range1 = new Range(2, 6);
        Range range2 = new Range(5, 10);
        Range expected = new Range(2, 10);
        Range actual = null;
        try {
	        actual = Range.combine(range1, range2);
        } catch (IllegalArgumentException e) {
            // If an IllegalArgumentException occurs during combination, fail the test
            fail("Combination failed unexpectedly with IllegalArgumentException: " + e.getMessage());
        }	        
        assertEquals("Combine: Failed combining valid ranges which overlap each other", expected, actual);
	}
	
	@Test
	public void testCombineRangesWithSameValues() {
		Range range1 = new Range(2, 6);
        Range range2 = new Range(2, 6);
        Range expected = new Range(2, 6);
        Range actual = null;
        try {
	        actual = Range.combine(range1, range2);
		} catch (IllegalArgumentException e) {
	        fail("Combination failed unexpectedly with IllegalArgumentException: " + e.getMessage());
	    }	        
        assertEquals("Combine: Failed combining valid ranges which have the same value", expected, actual);
	}
	
	@Test
	public void testCombineRangesWhereOneContainsAnother() {
		Range range1 = new Range(2, 10);
        Range range2 = new Range(5, 7);
        Range expected = new Range(2, 10);
        Range actual = null;
        try {
        	actual = Range.combine(range1, range2);
        } catch (IllegalArgumentException e) {
            fail("Combination failed unexpectedly with IllegalArgumentException: " + e.getMessage());
        }         	
        assertEquals("Combine: Failed combining valid ranges where one contains another", expected, actual);
    }
	
	@Test
	public void testCombineOneNegativeRange() {
		Range range1 = new Range(-6, -2);
        Range range2 = new Range(5, 7);
        Range expected = new Range(-6, 7);
        Range actual = null;
        try {
        	actual = Range.combine(range1, range2);
        } catch (IllegalArgumentException e) {
            fail("Combination failed unexpectedly with IllegalArgumentException: " + e.getMessage());
        }         	
        assertEquals("Combine: Failed combining valid ranges where one is negative", expected, actual);
    }
	
	@Test
	public void testCombineBothNegativeRanges() {
		Range range1 = new Range(-6, -2);
        Range range2 = new Range(-4, -1);
        Range expected = new Range(-6, -1);
        Range actual = null;
        try {
        	actual = Range.combine(range1, range2);
        } catch (IllegalArgumentException e) {
            fail("Combination failed unexpectedly with IllegalArgumentException: " + e.getMessage());
        }         	
        assertEquals("Combine: Failed combining valid ranges where both are negative", expected, actual);
    }
	
	@Test
	public void testCombineNegativeEqualRanges() {
		Range range1 = new Range(-6, -2);
        Range range2 = new Range(-6, -2);
        Range expected = new Range(-6, -2);
        Range actual = null;
        try {
        	actual = Range.combine(range1, range2);
        } catch (IllegalArgumentException e) {
            fail("Combination failed unexpectedly with IllegalArgumentException: " + e.getMessage());
        }         	
        assertEquals("Combine: Failed combining valid ranges where both are negative and equal", expected, actual);
    }
	
	@Test
	public void testExpandToIncludeValueInsideRange() {
		Range range = new Range(2, 6);
		double number = 4;
		Range expected = new Range(2, 6);
		Range actual = null;
        try {
            actual = Range.expandToInclude(range, number);
        } catch (IllegalArgumentException e) {
            fail("Unexpected IllegalArgumentException caught:" + e);
        }
		assertEquals("ExpandToInclude: Failed to keep Range the same when value is inside Range", 
				expected, actual);
	}
	
	@Test
	public void testExpandToIncludeValueInsideRangeWithOneNegative() {
		Range range = new Range(-2, 6);
		double number = 4;
		Range expected = new Range(-2, 6);
		Range actual = null;
        try {
            actual = Range.expandToInclude(range, number);
        } catch (IllegalArgumentException e) {
            fail("Unexpected IllegalArgumentException caught:" + e);
        }
		assertEquals("ExpandToInclude: Failed to not change when a value already contained in Range is entered and one boundary is negative", 
				expected, actual);
	}
	
	@Test
	public void testExpandToIncludeValueInsideRangeWhereBothNegative() {
		Range range = new Range(-6, -2);
		double number = -4;
		Range expected = new Range(-6, -2);
		Range actual = null;
        try {
            actual = Range.expandToInclude(range, number);
        } catch (IllegalArgumentException e) {
            fail("Unexpected IllegalArgumentException caught:" + e);
        }
		assertEquals("ExpandToInclude: Failed to not change when a value already contained in Range is entered and all values are negative", 
				expected, actual);
	}
	
	@Test
	public void testExpandToIncludeValueGreaterThanRange() {
		Range range = new Range(2, 6);
		double number = 10;
		Range expected = new Range(2, 10);
		Range actual = null;
        try {
            actual = Range.expandToInclude(range, number);
        } catch (IllegalArgumentException e) {
            fail("Unexpected IllegalArgumentException caught:" + e);
        }
		assertEquals("ExpandToInclude: Failed to not expand to include range above boundary", 
				expected, actual);
	}
	
	@Test
	public void testExpandToIncludeValueGreaterThanRangeWithOneNegativeBoundary() {
		Range range = new Range(-2, 6);
		double number = 10;
		Range expected = new Range(-2, 10);
		Range actual = null;
        try {
            actual = Range.expandToInclude(range, number);
        } catch (IllegalArgumentException e) {
            fail("Unexpected IllegalArgumentException caught:" + e);
        }
		assertEquals("ExpandToInclude: Failed to expand to include Range above boundary when one boundary is negative", 
				expected, actual);
	}
	
	@Test
	public void testExpandToIncludeValueGreaterThanRangeWhenBothBoundariesNegative() {
		Range range = new Range(-6, -2);
		double number = 10;
		Range expected = new Range(-6, 10);
		Range actual = null;
        try {
            actual = Range.expandToInclude(range, number);
        } catch (IllegalArgumentException e) {
            fail("Unexpected IllegalArgumentException caught:" + e);
        }
		assertEquals("ExpandToInclude: Failed to expand to include Range above boundary when both boundaries are negative", 
				expected, actual);
	}
	
	@Test
	public void testExpandToIncludeValueBelowLowerRange() {
		Range range = new Range(2, 6);
		double number = 1;
		Range expected = new Range(1, 6);
		Range actual = null;
        try {
            actual = Range.expandToInclude(range, number);
        } catch (IllegalArgumentException e) {
            fail("Unexpected IllegalArgumentException caught:" + e);
        }
		assertEquals("ExpandToInclude: Failed to expand to include value below lower Range", 
				expected, actual);
	}
	
	@Test
	public void testExpandToIncludeValueBelowLowerRangeWithOneNegative() {
		Range range = new Range(-2, 6);
		double number = -3;
		Range expected = new Range(-3, 6);
		Range actual = null;
        try {
            actual = Range.expandToInclude(range, number);
        } catch (IllegalArgumentException e) {
            fail("Unexpected IllegalArgumentException caught:" + e);
        }
		assertEquals("ExpandToInclude: Failed to expand to include value below lower Range when one boundary is negative", 
				expected, actual);
	}
	
	@Test
	public void testExpandToIncludeValueBelowLowerRangeWhereBothNegative() {
		Range range = new Range(-6, -2);
		double number = -7;
		Range expected = new Range(-7, -2);
		Range actual = null;
        try {
            actual = Range.expandToInclude(range, number);
        } catch (IllegalArgumentException e) {
            fail("Unexpected IllegalArgumentException caught:" + e);
        }
		assertEquals("ExpandToInclude: Failed to expand to include value below lower Range when both boundaries are negative", 
				expected, actual);
	}
	
	@Test
	public void testExpandToIncludeWithNegativeValues() {
		Range range = new Range(2, 6);
		double number = -8;
		Range expected = new Range(-8, 6);
		Range actual = null;
        try {
            actual = Range.expandToInclude(range, number);
        } catch (IllegalArgumentException e) {
            fail("Unexpected IllegalArgumentException caught:" + e);
        }
		assertEquals("ExpandToInclude: Failed to expand the Range to include a negative value",
				expected, actual);
	}
	
	@Test
	public void testExpandToIncludeWithNegativeValuesWhereRangeHasOneNegative() {
		Range range = new Range(-2, 6);
		double number = -8;
		Range expected = new Range(-8, 6);
		Range actual = null;
        try {
            actual = Range.expandToInclude(range, number);
        } catch (IllegalArgumentException e) {
            fail("Unexpected IllegalArgumentException caught:" + e);
        }
		assertEquals("ExpandToInclude: Failed to expand the Range to include a negative value when one boundary is negative",
				expected, actual);
	}
	
	@Test
	public void testExpandToIncludeWithNegativeValuesWhereRangeIsNegative() {
		Range range = new Range(-6, -2);
		double number = -8;
		Range expected = new Range(-8, -2);
		Range actual = null;
        try {
            actual = Range.expandToInclude(range, number);
        } catch (IllegalArgumentException e) {
            fail("Unexpected IllegalArgumentException caught:" + e);
        }
		assertEquals("ExpandToInclude: Failed to expand the Range to include a negative value when both boundaries are negative",
				expected, actual);
	}
	
	@Test
	public void testExpandToIncludeValueOnLowerBoundary() {
		Range range = new Range(2, 6);
		double number = 2;
		Range expected = new Range(2, 6);
		Range actual = null;
        try {
            actual = Range.expandToInclude(range, number);
        } catch (IllegalArgumentException e) {
            fail("Unexpected IllegalArgumentException caught:" + e);
        }
		assertEquals("ExpandToInclude: Failed to keep Range the same when a value on the lower boundary is used",
				expected, actual);
	}
	
	@Test
	public void testExpandToIncludeValueOnLowerBoundaryWithOneNegative() {
		Range range = new Range(-2, 6);
		double number = -2;
		Range expected = new Range(-2, 6);
		Range actual = null;
        try {
            actual = Range.expandToInclude(range, number);
        } catch (IllegalArgumentException e) {
            fail("Unexpected IllegalArgumentException caught:" + e);
        }
		assertEquals("ExpandToInclude: Failed to keep Range the same when a value on the lower boundary is used and it is negative",
				expected, actual);
	}
	
	@Test
	public void testExpandToIncludeValueOnLowerBoundaryWhereBothNegative() {
		Range range = new Range(-6, -2);
		double number = -6;
		Range expected = new Range(-6, -2);
		Range actual = null;
        try {
            actual = Range.expandToInclude(range, number);
        } catch (IllegalArgumentException e) {
            fail("Unexpected IllegalArgumentException caught:" + e);
        }
		assertEquals("ExpandToInclude: Failed to keep Range the same when a value on the lower boundary is used and both boundaries are negative",
				expected, actual);
	}
	
	@Test
	public void testExpandToIncludeValueOnUpperBoundary() {
		Range range = new Range(2, 6);
		double number = 6;
		Range expected = new Range(2, 6);
		Range actual = null;
        try {
            actual = Range.expandToInclude(range, number);
        } catch (IllegalArgumentException e) {
            fail("Unexpected IllegalArgumentException caught:" + e);
        }
		assertEquals("ExpandToInclude: Failed to keep Range the same when a value on the upper boundary is used",
				expected, actual);
	}
	
	@Test
	public void testExpandToIncludeValueOnUpperBoundaryWithOneNegative() {
		Range range = new Range(-2, 6);
		double number = 6;
		Range expected = new Range(-2, 6);
		Range actual = null;
        try {
            actual = Range.expandToInclude(range, number);
        } catch (IllegalArgumentException e) {
            fail("Unexpected IllegalArgumentException caught:" + e);
        }
		assertEquals("ExpandToInclude: Failed to keep Range the same when a value on the upper boundary is used and one boundary is negative",
				expected, actual);
	}
	
	@Test
	public void testExpandToIncludeValueOnUpperBoundaryWhereBothNegative() {
		Range range = new Range(-6, -2);
		double number = -2;
		Range expected = new Range(-6, -2);
		Range actual = null;
        try {
            actual = Range.expandToInclude(range, number);
        } catch (IllegalArgumentException e) {
            fail("Unexpected IllegalArgumentException caught:" + e);
        }
		assertEquals("ExpandToInclude: Failed to keep Range the same when a value on the upper boundary is used and both boundaries are negative",
				expected, actual);
	}
	
	@Test
	public void testConstrainValueInsideRange() {
	    Range range = new Range(2, 6);
	    double number = 4;
	    double actual = range.constrain(number);
	    double expected = 4;
	    assertEquals("Constrain: Failed to return closest double when double is inside range",
	            expected, actual, 0.0001);
	}
	
	@Test
	public void testConstrainValueInsideRangeWithOneNegativeBoundary() {
	    Range range = new Range(-2, 6);
	    double number = 4;
	    double actual = range.constrain(number);
	    double expected = 4;
	    assertEquals("Constrain: Failed to return closest double when double is inside Range and one boundary is negative",
	            expected, actual, 0.0001);
	}
	
	@Test
	public void testConstrainValueInsideRangeWhereBothBoundariesNegative() {
	    Range range = new Range(-6, -2);
	    double number = -4;
	    double actual = range.constrain(number);
	    double expected = -4;
	    assertEquals("Constrain: Failed to return closest double when double is inside Range and both boundaries are negative",
	            expected, actual, 0.0001);
	}
	
	@Test
	public void testConstrainValueAboveUpperRange() {
	    Range range = new Range(2, 6);
	    double number = 10;
	    double actual = range.constrain(number);
	    double expected = 6;
	    assertEquals("Constrain: Failed to return closest double when double is above upper range",
	            expected, actual, 0.0001);
	}

	@Test
	public void testConstrainValueAboveUpperRangeWithOneNegativeBoundary() {
	    Range range = new Range(-2, 6);
	    double number = 10;
	    double actual = range.constrain(number);
	    double expected = 6;
	    assertEquals("Constrain: Failed to return closest double when double is above upper Range and one boundary is negative",
	            expected, actual, 0.0001);
	}
	
	@Test
	public void testConstrainValueAboveUpperRangeWhereBothBoundariesNegative() {
	    Range range = new Range(-6, -2);
	    double number = 10;
	    double actual = range.constrain(number);
	    double expected = -2;
	    assertEquals("Constrain: Failed to return closest double when double is above upper Range and both boundaries are negative",
	            expected, actual, 0.0001);
	}
	
	@Test
	public void testConstrainValueBelowLowerBoundary() {
	    Range range = new Range(2, 6);
	    double number = 1;
	    double actual = range.constrain(number);
	    double expected = 2;
	    assertEquals("Constrain: Failed to return closest double when double was lower than lower bound",
	            expected, actual, 0.0001);
	}
	
	@Test
	public void testConstrainValueBelowLowerBoundaryWithOneNegativeBoundary() {
	    Range range = new Range(-2, 6);
	    double number = -3;
	    double actual = range.constrain(number);
	    double expected = -2;
	    assertEquals("Constrain: Failed to return closest double when double was lower than lower bound and one boundary is negative",
	            expected, actual, 0.0001);
	}
	
	@Test
	public void testConstrainValueBelowLowerBoundaryWhereBothBoundariesNegative() {
	    Range range = new Range(-6, -2);
	    double number = -7;
	    double actual = range.constrain(number);
	    double expected = -6;
	    assertEquals("Constrain: Failed to return closest double when double was lower than lower bound and both boundaries are negative",
	            expected, actual, 0.0001);
	}
	
	@Test
	public void testConstrainValueIsNegative() {
	    Range range = new Range(2, 6);
	    double number = -8;
	    double actual = range.constrain(number);
	    double expected = 2;
	    assertEquals("Constrain: Failed to return closest double when double was negative",
	            expected, actual, 0.0001);
	}
	
	@Test
	public void testConstrainValueIsNegativeWithOneNegativeBoundary() {
	    Range range = new Range(-2, 6);
	    double number = -8;
	    double actual = range.constrain(number);
	    double expected = -2;
	    assertEquals("Constrain: Failed to return closest double when double was negative and one boundary is negative",
	            expected, actual, 0.0001);
	}
	
	@Test
	public void testConstrainValueIsNegativeWithNegativeBoundaries() {
	    Range range = new Range(-6, -2);
	    double number = -8;
	    double actual = range.constrain(number);
	    double expected = -6;
	    assertEquals("Constrain: Failed to return closest double when double was negative and both boundaries are negative",
	            expected, actual, 0.0001);
	}
	
	
	@Test
	public void testConstrainValueMatchesLowerBoundary() {
	    Range range = new Range(2, 6);
	    double number = 2;
	    double actual = range.constrain(number);
	    double expected = 2;
	    assertEquals("Constrain: Failed to return closest double when double equals lower boundary",
	            expected, actual, 0.0001);
	}
	
	@Test
	public void testConstrainValueMatchesLowerBoundaryWithOneNegative() {
	    Range range = new Range(-2, 6);
	    double number = -2;
	    double actual = range.constrain(number);
	    double expected = -2;
	    assertEquals("Constrain: Failed to return closest double when double equals lower boundary and one boundary is negative",
	            expected, actual, 0.0001);
	}
	
	@Test
	public void testConstrainValueMatchesLowerBoundaryWithNegativeBoundaries() {
	    Range range = new Range(-6, -2);
	    double number = -6;
	    double actual = range.constrain(number);
	    double expected = -6;
	    assertEquals("Constrain: Failed to return closest double when double equals lower boundary and both boundaries are negative",
	            expected, actual, 0.0001);
	}
	
	@Test
	public void testConstrainValuematchesUpperBoundary() {
	    Range range = new Range(2, 6);
	    double number = 6;
	    double actual = range.constrain(number);
	    double expected = 6;
	    assertEquals("Constrain: Failed to return closest double when double equals upper boundary",
	            expected, actual, 0.0001);
	}

	@Test
	public void testConstrainValuematchesUpperBoundaryWithOneNegative() {
	    Range range = new Range(-2, 6);
	    double number = 6;
	    double actual = range.constrain(number);
	    double expected = 6;
	    assertEquals("Constrain: Failed to return closest double when double equals upper boundary and one boundary is negative",
	            expected, actual, 0.0001);
	}

	@Test
	public void testConstrainValuematchesUpperBoundaryWhereBothBoundariesNegative() {
	    Range range = new Range(-6, -2);
	    double number = -2;
	    double actual = range.constrain(number);
	    double expected = -2;
	    assertEquals("Constrain: Failed to return closest double when double equals upper boundary and both boundaries are negative",
	            expected, actual, 0.0001);
	}
	
	// Start of Lab3 Tests
	
	@Test
    public void testGetLength() {
        double lower = 5.0;
        double upper = 10.0;
        Range range = new Range(lower, upper);
        
        double length = range.getLength();
        
        double expectedLength = upper - lower;
        assertEquals(expectedLength, length, 0.001);
    }
	
	@Test
    public void testGetCentralValue() {
        double lower = 5.0;
        double upper = 10.0;
        Range range = new Range(lower, upper);
        
        double centralValue = range.getCentralValue();
        
        double expectedCentralValue = 7.5;
        assertEquals(expectedCentralValue, centralValue, 0.001);
    }
	
    @Test
    public void testIntersectsWhenProvidedRangeIsCompletelyBelow() {
        double rangeLower = 5.0;
        double rangeUpper = 10.0;
        Range range = new Range(rangeLower, rangeUpper);

        assertFalse(range.intersects(1.0, 3.0));
    }

    @Test
    public void testIntersectsWhenProvidedRangeIsCompletelyAbove() {
        double rangeLower = 5.0;
        double rangeUpper = 10.0;
        Range range = new Range(rangeLower, rangeUpper);

        assertFalse(range.intersects(15.0, 20.0));
    }
    
    @Test
    public void testExpandWithNullRange() {
        try {
            Range.expand(null, 0.1, 0.1);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Null 'range' argument.", e.getMessage());
        }
    }

    @Test
    public void testExpandUpperBound() {
        Range range = new Range(5.0, 10.0);
        double lowerMargin = 0.1;
        double upperMargin = 0.1;
        
        Range expandedRange = Range.expand(range, lowerMargin, upperMargin);
        
        assertEquals(4.5, expandedRange.getLowerBound(), 0.0001);
    }
    
    @Test
    public void testExpandLowerBound() {
        Range range = new Range(5.0, 10.0);
        double lowerMargin = 0.1;
        double upperMargin = 0.1;
        
        Range expandedRange = Range.expand(range, lowerMargin, upperMargin);
        
        assertEquals(10.5, expandedRange.getUpperBound(), 0.0001);
    }

    @Test
    public void testShiftLowerBound() {
        Range base = new Range(5.0, 10.0);
        double delta = 2.0;
        
        Range shiftedRange = Range.shift(base, delta);
        
        assertEquals(7.0, shiftedRange.getLowerBound(), 0.0001);
    }
    
    @Test
    public void testShiftUpperBound() {
        Range base = new Range(5.0, 10.0);
        double delta = 2.0;
        
        Range shiftedRange = Range.shift(base, delta);
        
        assertEquals(12.0, shiftedRange.getUpperBound(), 0.0001);
    }

    @Test
    public void testShiftLowerBoundWithZeroCrossingNotAllowed() {
        Range base = new Range(5.0, 10.0);
        double delta = 2.0;
        boolean allowZeroCrossing = false;
        
        Range shiftedRange = Range.shift(base, delta, allowZeroCrossing);
        
        assertEquals(7.0, shiftedRange.getLowerBound(), 0.0001);
    }
    
    @Test
    public void testShiftUpperBoundWithZeroCrossingNotAllowed() {
        Range base = new Range(5.0, 10.0);
        double delta = 2.0;
        boolean allowZeroCrossing = false;
        
        Range shiftedRange = Range.shift(base, delta, allowZeroCrossing);
        
        assertEquals(12.0, shiftedRange.getUpperBound(), 0.0001);
    }
    
    @Test
    public void testShiftLowerBoundWithZeroCrossingAllowed() {
        Range base = new Range(5.0, 10.0);
        double delta = 2.0;
        boolean allowZeroCrossing = true;
        
        Range shiftedRange = Range.shift(base, delta, allowZeroCrossing);
        
        assertEquals(7.0, shiftedRange.getLowerBound(), 0.0001);
    }
    
    @Test
    public void testShiftUpperBoundWithZeroCrossingAllowed() {
        Range base = new Range(5.0, 10.0);
        double delta = 2.0;
        boolean allowZeroCrossing = true;
        
        Range shiftedRange = Range.shift(base, delta, allowZeroCrossing);
        
        assertEquals(12.0, shiftedRange.getUpperBound(), 0.0001);
    }
    
    @Test
    public void testShiftLowerBoundWithZeroCrossingNotAllowedAndNegativeValue() {
        Range base = new Range(-3.0, -1.0);
        double delta = 2.0;
        boolean allowZeroCrossing = false;
        
        Range shiftedRange = Range.shift(base, delta, allowZeroCrossing);
        
        assertEquals(-1.0, shiftedRange.getLowerBound(), 0.0001);
    }
    
    @Test
    public void testShiftUpperBoundWithZeroCrossingNotAllowedAndNegativeValue() {
        Range base = new Range(-3.0, -1.0);
        double delta = 2.0;
        boolean allowZeroCrossing = false;
        
        Range shiftedRange = Range.shift(base, delta, allowZeroCrossing);
        
        assertEquals(1.0, shiftedRange.getUpperBound(), 0.0001);
    }
    
    @Test
    public void testHashCode() {
        Range range1 = new Range(5.5, 10.0);
        Range range2 = new Range(5.5, 10.0);

        assertEquals(range1.hashCode(), range2.hashCode());
    }
   
    @Test
    public void testToString() {
        Range range = new Range(5.5, 10.0);
        String result = range.toString();

        assertEquals("Range[5.5,10.0]", result);
    }
    
    @Test
    public void testEqualsWithDifferentObjectType() {
        Range range = new Range(0.0, 5.0);
        Object obj = "This is not a Range";
        
        boolean result = range.equals(obj);
        
        assertFalse(result);
    }
	
	@Test
    public void testCombineWithNullRange1() {
        Range range2 = new Range(5.0, 10.0);
        
        Range result = Range.combine(null, range2);
        
        assertEquals(range2, result);
    }
    
    @Test
    public void testCombineWithNullRange2() {
        Range range1 = new Range(5.0, 10.0);
        
        Range result = Range.combine(range1, null);
        
        assertEquals(range1, result);
    }
    
}
