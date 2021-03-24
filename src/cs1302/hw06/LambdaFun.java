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


        // printlnMatches examples

        System.out.println("Test: <Integer>printlnMatches (positive #'s)");
        Predicate<Integer> i1 = x -> { return x >= 0; };        
        LambdaFun.<Integer>printlnMatches(myInts, i1);
        System.out.println();

        System.out.println("Test: <String>printlnMatches (length > 3)");
        Predicate<String> s1 = str -> { return str.length() > 3; };
        LambdaFun.<String>printlnMatches(myStrings, s1);
        System.out.println();

        System.out.println("Test: <String>printlnMatches (ends with an e)");
        Predicate<String> s2 = str -> { return str.endsWith("e"); };
        LambdaFun.<String>printlnMatches(myStrings, s2);
        System.out.println();

        System.out.println("Test: <Email>printlnMatches (from @uga.edu)");
        Predicate<Email> e1 = email -> { return email.getSender().contains("@uga.edu"); };
        LambdaFun.<Email>printlnMatches(inbox, e1);
        System.out.println();

        
        // printlnMappedMatches examples

        System.out.println("Test: <Email>printlnMappedMatches (from @uga.edu, print sender)");
        Predicate<Email> e2 = email -> { return email.getSender().contains("@uga.edu"); };
        Function<Email, String> efunc1 = email -> { return email.getSender(); };
        LambdaFun.<Email>printlnMappedMatches(inbox, e2, efunc1);
        System.out.println();

        System.out.println("Test: <Email>printlnMappedMatches (email contains GA, print date)");
        Predicate<Email> e3 = email -> { return email.getContents().contains("GA"); };
        Function<Email, String> efunc2 = email -> { return email.getDateSent().toString(); };
        LambdaFun.<Email>printlnMappedMatches(inbox, e3, efunc2);
        System.out.println();

        System.out.println("Test: <String>printlnMappedMatches (contains s, print string twice)");
        Predicate<String> s3 = str -> { return str.contains("s"); };
        Function<String, String> strfunc = str -> { return str + str; };
        LambdaFun.<String>printlnMappedMatches(myStrings, s3, strfunc);
        System.out.println();

        System.out.println("Test: <Integer>printlnMappedMatches (no filter, print x^2)");
        Predicate<Integer> i2 = x -> { return true; };
        Function<Integer, String> ifunc = x -> { return "" + (x * x); };
        LambdaFun.<Integer>printlnMappedMatches(myInts, i2, ifunc);
        System.out.println();

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

        for (T obj : t) {

            if (p.test(obj)) {
                System.out.println(f.apply(obj));

            } // if

        } // for

    } // printlnMappedMatches

} // LambdaFun
