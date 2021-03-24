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
        
        
        // printlnMatches is a generic method, so the
        // generic type T needs to be replaced before
        // the method is usable.
        //
        // Using Email in place of T would result in
        // the following method signature:
        //
        // private static void printlnMatches(Email[] t, Predicate<Email> p, Function<Email, String> f)
        //
        // Input: Integer[], Predicate<T>, Function<Email, String>
        // Output: None
        //
        // [!] Note that the original version of "f"
        // from the generic method header is
        // Function<T, String>. This means that the 
        // input will change based on T, but the output
        // of the Function must always be a String to 
        // be a valid argument for printlnMappedMatches.
        // 
        // Because "inbox" is an Email[],
        // "e" is a Predicate<Email>, and "efunc" 
        // is a Function<Email, String>, they can
        // be used as input arguments for the 
        // <Email>printlnMappedMatches method.

        LambdaFun.<Email>printlnMappedMatches(inbox, e, efunc);
        System.out.println();

        // The function of "e" is to check whether or
        // not the sender of the email is addressed as @uga.edu.
        //
        // [?] Which elements of "inbox" should be printed 
        // when printlnMappedMatches is executed?
        //
        // The function of "efunc" is to return the sender's address
        // when given an email.
        // 
        // [?] What should be printed in place of the email's memory address?

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

//-----------------------------------------------------------------------------------------

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
        
        // Access each object in "t"

        for (T obj : t) {

            // Print if the object passes the test defined in "p"

            if (p.test(obj)) {
                
                // Print a string representation of the object as defined in "f"

                System.out.println(f.apply(obj));

            } // if

        } // for

        // When this method is actually called, the T values
        // in "t", "p", and "f" will change depending on what 
        // data type is used. In any case, the Predicate should
        // be checking the same kind of object that is stored in
        // the array, as both contain T. Additionally, the Function
        // will take in that same type as an input, but it will 
        // return a String regardless of what type T becomes.
        //
        // In this example, "t" is inbox, "p" is e, and "f" is efunc. 

    } // printlnMappedMatches

//-----------------------------------------------------------------------------------------

} // LambdaFun
