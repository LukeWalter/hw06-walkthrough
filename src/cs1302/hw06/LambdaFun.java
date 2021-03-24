package cs1302.hw06;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Function;

/**
 * This class contains methods related to {@code cs1302-hw06}.
 */
public class LambdaFun {

    /** Standard Input scanner. */
    private static Scanner input = new Scanner(System.in);

    /**
     * Main entry-point into the application.
     * @param args the command-line arguments.
     */
    public static void main(String[] args) {

        String[] myStrings = new String[] {
            "CSCI",        "1302",    "is", "an", "awesome", "course!",
            "Lambda", "expressions", "scare", "me",     "but",       "I",
            "will",   "persevere"
        };

        Email[] inbox = new Email[] {
            new Email("bjb211@uga.edu", "yellowjacket@gatech.edu",
                      LocalDate.of(2019, 2, 4), "Go GA Tech!"),
            new Email("bjb211@uga.edu", "mom@aol.com",
                      LocalDate.of(2019, 2, 5), "Have a good day!"),
            new Email("bjb211@uga.edu", "steve@anyotherschool.edu",
                      LocalDate.of(2019, 2, 6), "I wish I would've chosen UGA"),
            new Email("bjb211@uga.edu", "student1@uga.edu",
                      LocalDate.of(2019, 2, 7), "Thanks for teaching us!"),
            new Email("bjb211@uga.edu", "yellowjacket@gatech.edu",
                      LocalDate.of(2019, 2, 8), "Go GA Tech!")
        };

//-----------------------------------------------------------------------------------------

        // The Predicate interface is used to test some
        // object to see if it meets some condition.
        //
        // Predicate<T> contains the abstract method
        // [boolean test(T t)]
        // Input: T (object being tested)
        // Output: boolean (result of test)
        // 
        // Implementing classes of Predicate<T> must provide:
        // (a) A data type to replace the generic type T
        // (b) An implementation for the abstract method
        // 
        // Example: Predicate<Integer> i
        //
        // Integer replaces T, so the implementing class
        // contains this method signature:
        // [boolean test(Integer t)]
        // Input: Integer 
        // Output: boolean
        //
        // [!] The name of the input variables in a method
        // signature are arbitrary. The variable "t" in the
        // test method could be anything as long as it is 
        // still an integer.
        // 
        // The lambda expression for the variable "i" 
        // tests whether or not its input variable is a
        // positive integer.

        Predicate<Integer> i = x -> { return x >= 0; };
        
        // Try inputting different values for a!
        int a = -1;
        System.out.println(i.test(a));

//-----------------------------------------------------------------------------------------

    } // main

    /**
     * Prints the elements of the array that pass the test specified by the given predicate.
     * More formally, this method prints all elements {@code e} in the array referred to by
     * {@code t} such that {@code p.test(e)}. Each element will be printed on its own line.
     *
     * @param <T> the type of the array elements
     * @param t the specified array
     * @param p the specified predicate
     * @throws NullPointerException if the specified predicate is {@code null}
     */
    private static <T> void printlnMatches(T[] t, Predicate<T> p) {
        throw new UnsupportedOperationException("not yet implemented");

    } // printlnMatches

    /**
     * Prints the elements of the array that pass the test specified by the given predicate
     * using a string mapper. More formally, this method prints the string mapped elements
     * {@code f.apply(e)} in the array referred to by {@code t} for each {@code e} such that
     * {@code p.test(e)}. Each string mapped element will be printed on its own line.
     *
     * @param <T> the type of the array elements
     * @param t the specified array
     * @param p the specified predicate
     * @param f the specified string mapper
     * @throws NullPointerException if the specified predicate or string mapper is {@code null}
     */
    private static <T> void printlnMappedMatches(T[] t, Predicate<T> p, Function<T, String> f) {
        throw new UnsupportedOperationException("not yet implemented");

    } // printlnMappedMatches

} // LambdaFun
