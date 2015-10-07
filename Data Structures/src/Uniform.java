import java.util.Random;

/**
 * Created by Anthony on 10/7/2015.
 */
public class Uniform {
    public int uniform(int mean, int variant, Random rand)
// JAVA FUNCTION THAT RETURNS A UNIFORMLY RANDOM
// INTEGER IN THE RANGE OF MEAN +- VARIANT
//  Be sure to import java.util.Random
//  Be sure to declare rand in the calling function as follows:
//  Random rand = new Random();
    {
        int small   = mean - variant;
        int range   = 2 * variant + 1;
        return    small + rand.nextInt(range);
    }
}
