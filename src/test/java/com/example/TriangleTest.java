package com.example;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TriangleTest {
    // Valid triangles
    @Test
    public void testScalene() {
        Triangle t = new Triangle(3, 4, 5);
        assertEquals("Scalene", t.getTriangleType());
    }

    @Test
    public void testEquilateral() {
        Triangle t = new Triangle(3, 3, 3);
        assertEquals("Equilateral", t.getTriangleType());
    }

    @Test
    public void testIsoscelesAB() {
        Triangle t = new Triangle(3, 3, 5);
        assertEquals("Isosceles", t.getTriangleType());
    }

    @Test
    public void testIsoscelesBC() {
        Triangle t = new Triangle(5, 3, 3);
        assertEquals("Isosceles", t.getTriangleType());
    }

    @Test
    public void testIsoscelesAC() {
        Triangle t = new Triangle(3, 5, 3);
        assertEquals("Isosceles", t.getTriangleType());
    }

    // Non-positive sides (covering each term in a <= 0 || b <= 0 || c <= 0)
    @Test
    public void testOnlyANegative() {
        Triangle t = new Triangle(-1, 2, 3);
        assertEquals("Error: The length should be positive", t.getTriangleType());
    }

    @Test
    public void testOnlyBNegative() {
        Triangle t = new Triangle(2, -1, 3);
        assertEquals("Error: The length should be positive", t.getTriangleType());
    }

    @Test
    public void testOnlyCNegative() {
        Triangle t = new Triangle(2, 3, -1);
        assertEquals("Error: The length should be positive", t.getTriangleType());
    }

    @Test
    public void testOnlyAZero() {
        Triangle t = new Triangle(0, 4, 5);
        assertEquals("Error: The length should be positive", t.getTriangleType());
    }

    @Test
    public void testOnlyBZero() {
        Triangle t = new Triangle(4, 0, 5);
        assertEquals("Error: The length should be positive", t.getTriangleType());
    }

    @Test
    public void testOnlyCZero() {
        Triangle t = new Triangle(4, 5, 0);
        assertEquals("Error: The length should be positive", t.getTriangleType());
    }

    @Test
    public void testAllNegative() {
        Triangle t = new Triangle(-1, -2, -3);
        assertEquals("Error: The length should be positive", t.getTriangleType());
    }

    // Invalid triangles (covering each sub-condition failure in a < b + c && b < a + c && c < a + b)
    @Test
    public void testNotTriangleAFails() {
        Triangle t = new Triangle(5, 2, 2); // 5 ≥ 2 + 2, but 2 < 5 + 2, 2 < 5 + 2
        assertEquals("Error: Not a triangle", t.getTriangleType());
    }

    @Test
    public void testNotTriangleBFails() {
        Triangle t = new Triangle(2, 5, 2); // 2 < 5 + 2, 5 ≥ 2 + 2, 2 < 2 + 5
        assertEquals("Error: Not a triangle", t.getTriangleType());
    }

    @Test
    public void testNotTriangleCFails() {
        Triangle t = new Triangle(2, 2, 5); // 2 < 2 + 5, 2 < 2 + 5, 5 ≥ 2 + 2
        assertEquals("Error: Not a triangle", t.getTriangleType());
    }

    @Test
    public void testNotTriangleBoundary() {
        Triangle t = new Triangle(1, 1, 2); // 1 + 1 = 2 (not <), boundary case
        assertEquals("Error: Not a triangle", t.getTriangleType());
    }
}