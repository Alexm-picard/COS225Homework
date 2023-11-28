//The equation is {1 if n == 0}
//                {2^n - 1 for n > 0}

//You get this equation by setting the first one to the fastest option, 
// ex. 0 in this case, and for the second you get it as you need to move 
//each disc above it twice to move the current one, so it needs to be 
//2 for the two moves and to the power of n for the amount of discs in the hanoi.

public class TowerOfHanoi {
    public static void towerOfHanoi(int n, String source, String destination, String auxiliary){
        if(n == 0){
            return;
        }
        towerOfHanoi(n-1, source, auxiliary, destination);
        towerOfHanoi(n-1, auxiliary, destination, source);
    }
    public static void main(String[] args){
        towerOfHanoi(3, "First Rod", "Second Rod", "Third Rod");
    }
}
