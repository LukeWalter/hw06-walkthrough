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

        Integer[] myInts = { -3, -2, -1, 0, 1, 2, 3 };

        Predicate<Integer> i = x -> { return x >= 0; };        
        LambdaFun.<Integer>printlnMatches(myInts, i);
        System.out.println();

        Predicate<String> s1 = str -> { return str.length() > 3; };
        LambdaFun.<String>printlnMatches(myStrings, s1);
        System.out.println();

        Predicate<String> s2 = str -> { return str.endsWith("e"); };
        LambdaFun.<String>printlnMatches(myStrings, s2);
        System.out.println();

//-----------------------------------------------------------------------------------------

        Predicate<Email> e = email -> { return email.getSender().contains("@uga.edu"); };
        

        // The Function interface is used to create a 
        // method with a customizable input and output.
        //
        // Function<T, R> contains the abstract method
        // [R apply(T t)]
        // Input: T (Input object type)
        // Output: R (Output object type)
        // 
        // Implementing classes of Function<T, R> must provide:
        // (a) A data type to replace the generic type T
        // (b) A data type to replace the generic type R
        // (c) An implementation for the abstract method
        // 
        // Example: Function<Email, String> efunc
        //
        // Email replaces T, and String replaces R, so 
        // the implementing class contains this method signature:
        // [String apply(Email t)]
        // Input: Email 
        // Output: String
        //
        // [!] The name of the input variables in a method
        // signature are arbitrary. The variable "t" in the
        // test method could be anything as long as it is 
        // still an integer.
        // 
        // The lambda expression for the variable "efunc" 
        // obtains the "sender" variable (a String) from 
        // the "email" object and returns it.
        // (See getSender() in the Email class)

        Function<Email, String> efunc = email -> { return email.getSender(); };
        
        
        LambdaFun.<Email>printlnMatches(inbox, e);
        System.out.println();

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

        for (T obj : t) {

            if (p.test(obj)) {
                System.out.println(obj);

            } // if

        } // for

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
