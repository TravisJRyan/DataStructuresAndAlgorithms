/*
    8.10 Paint Fill - Implement the "paint fill" algorithm common on many image editing programs. That is, given a screen
    represented by a two-dimensional array of colors, a point, and a new color, fill the surrounding area until the color
    changes from the original color.
*/
public class PaintFill{
    enum Color { Black, White, Red, Yellow, Green}
    
    public static void main(String[] args){
        Color[][] image = {
            {Color.White, Color.Black, Color.White, Color.Red},
            {Color.White, Color.Black, Color.White, Color.Red},
            {Color.White, Color.Black, Color.White, Color.Red},
            {Color.Black, Color.Black, Color.White, Color.Black},
            {Color.White, Color.White, Color.White, Color.Black}
        };

        paintFill(image, 1, 2, Color.Green, image[1][2]);
        printImage(image);
    }

    // Recursively check all neighbors of a given node. Base case is another color is hit, or tile is out of bounds
    // Each tile can be checked a maximum of 5 times, so runtime should be O(5n) -> O(n) where n is number of tiles
    public static void paintFill(Color[][] image, int i, int j, Color fillColor, Color startColor){
        if(i < 0 || i >= image.length || j < 0 || j >= image[i].length || image[i][j]!=startColor)
            return;
        image[i][j] = fillColor;
        paintFill(image, i+1, j, fillColor, startColor);
        paintFill(image, i-1, j, fillColor, startColor);
        paintFill(image, i, j+1, fillColor, startColor);
        paintFill(image, i, j-1, fillColor, startColor);
    }

    public static void printImage(Color[][] image){
        for(int i = 0; i < image.length; i++){
            for(int j = 0; j < image[i].length; j++)
                System.out.print(image[i][j]+" ");
            System.out.print("\n");
        }
    }

}
