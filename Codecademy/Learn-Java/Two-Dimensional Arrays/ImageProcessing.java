import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.Random;
import javax.imageio.ImageIO;
public class ImageProcessing {
	public static void main(String[] args) {
// start of main method
    /* 
     * The provided images are apple.jpg, flower.jpg, and kitten.jpg 0r load your own image using a URL!
		 * int[][] imageData = imgToTwoD("https://content.codecademy.com/projects/project_thumbnails/phaser/bug-dodger.png");
    */

    // creates an array of pixels from image
    int[][] imageData = imgToTwoD("./images/apple.jpg");

    // code to view imageData
//    viewImageData(imageData); 

  //editing pixels
//create a trimmed image
    //creates a trimmed array
		int[][] trimmed = trimBorders(imageData, 60);
    //creates an image from new trimmed array
		twoDToImage(trimmed, "./apple/trimmed_apple.jpg");
//create a negative image
    //creates a negative array
    int[][] negative = negativeColor(imageData);
    //creates an image from new negative array
    twoDToImage(negative, "./apple/negative_apple.jpg");
// create a horizontally stretched image
    //creates a stretched array
    int[][] stretched = stretchHorizontally(imageData);
    //creates an image from stretched array
    twoDToImage(stretched, "./apple/stretched_apple.jpg");
// create a vertically shrunk image
    //creates a shrunk array
    int[][] shrunk = shrinkVertically(imageData);
    //creates an image from shrunk array
   twoDToImage(shrunk, "./apple/shrunk_apple.jpg");
// creates an inverted image
    //creates an inverted array
    int[][] inverted = invertImage(imageData);
    //create an image from inverted array
    twoDToImage(inverted, "./apple/inverted_apple.jpg");
// creates an color filtered image
    //creates an color filtered array
    int[][] filtered = colorFilter(imageData, 0, 24, 51);
    //create an image from  array
    twoDToImage(filtered, "./apple/filtered_apple.jpg");

    // create an image using all filters
		int[][] allFilters = stretchHorizontally(shrinkVertically(colorFilter(negativeColor(trimBorders(invertImage(imageData), 50)), 200, 20, 40)));
    // stores the image
    twoDToImage(allFilters, "./apple/all_filters_apple.jpg");


  	// Painting with pixels
// creates a painted image
    //creates a random pixel array
    int[][] randomPixel = paintRandomImage(imageData);
    //create an image from array
    twoDToImage(randomPixel, "./random_apple.jpg");
// creates an painted rectangle on the apple image
    //creates an rectangle on apple array
    int[][] paintRectangleOnApple = paintRectangle(imageData, 125, 153, 112, 153, 231);
    //create an image from array
    twoDToImage(paintRectangleOnApple, "./painted_apple.jpg");
// creates an random painted rectangle on image
    //creates a randomly generated rectangle on apple array
    int[][] randomRectangleOnApple = generateRectangles(imageData, 7);
    //create an image from  array
    twoDToImage(randomRectangleOnApple, "./random_rectangle_apple.jpg");
	}
// end of main method

	// Image Processing Methods
	public static int[][] trimBorders(int[][] imageTwoD, int pixelCount) {
		// Example Method
		if (imageTwoD.length > pixelCount * 2 && imageTwoD[0].length > pixelCount * 2) {
			int[][] trimmedImg = new int[imageTwoD.length - pixelCount * 2][imageTwoD[0].length - pixelCount * 2];
			for (int i = 0; i < trimmedImg.length; i++) {
				for (int j = 0; j < trimmedImg[i].length; j++) {
					trimmedImg[i][j] = imageTwoD[i + pixelCount][j + pixelCount];
				}
			}
			return trimmedImg;
		} else {
			System.out.println("Cannot trim that many pixels from the given image.");
			return imageTwoD;
		}
	}


// start of methods created by me
  /*
   * replace the color of each pixel in the image with the negative version of the pixel. This means that each color component of the pixel (R, G, and B) will be replaced with 255  
   * minus the current value.
   */
	public static int[][] negativeColor(int[][] imageTwoD) {
    // new 2D array of ints which is the same size as the input image
		int[][] negativeImageColor = new int[imageTwoD.length][imageTwoD[0].length];
    // iterate through every pixel in the input image (row-major order)
    for (int i = 0; i < imageTwoD.length; i++){
      for (int j = 0; j < imageTwoD[i].length; j++){
        // get the R, G, B, and A values from each pixel.
        int[] rgba = getRGBAFromPixel(imageTwoD[i][j]);
        // set the first three elements to 255 minus itself
        rgba[0] = 255 - rgba[0];
        rgba[1] = 255 - rgba[1];
        rgba[2] = 255 - rgba[2];
        // gets the int hexadecimal pixel data from the RGBA array.
        negativeImageColor[i][j] = getColorIntValFromRGBA(rgba);
      }
    }
		return negativeImageColor;
	}

  /*
   * double the width of the provided image data.
   */
	public static int[][] stretchHorizontally(int[][] imageTwoD) {
		// new 2D array of ints to hold the modified image data.
    int[][]horizontalImage = new int[imageTwoD.length][imageTwoD[0].length * 2];
    // additional variable which will keep track of which position we are in for the modified image
    int it = 0;
    // iterate through every pixel in the input image (row-major order)
    for (int i = 0; i < imageTwoD.length; i++){
      for (int j = 0; j < imageTwoD[i].length; j++){
        // copy each pixel from the input image
        horizontalImage[i][it] = imageTwoD[i][j];
        // duplicate each pixel from the input image
        horizontalImage[i][it + 1] = imageTwoD[i][j];
        it = j *2;
      }
    }
		return horizontalImage;
	}

  /*
   * halfing the height of the image and selecting every other pixel down each column to place in the modified image
   */
	public static int[][] shrinkVertically(int[][] imageTwoD) {
		// new 2D array of ints to hold the modified image data.
    int[][] shrunkImage = new int[imageTwoD.length / 2][imageTwoD[0].length];
    // iterate through every pixel in the input image (horizontal-major order)
    for (int i = 0; i < imageTwoD[0].length; i++){
      for (int j = 0; j < imageTwoD.length-1; j+=2){
        // copy each pixel from the input image
        shrunkImage[j/2][i] = imageTwoD[j][i];
      }
    }
		return shrunkImage;
	}

  /*
   * flip the image vertically and horizontally
   */
	public static int[][] invertImage(int[][] imageTwoD) {
		// new 2D array of ints to hold the modified image data.
    int[][]invertedImage = new int[imageTwoD.length][imageTwoD[0].length];
    // iterate through every pixel in the input image
    for (int i = 0; i < imageTwoD.length; i++){
      for (int j = 0; j < imageTwoD[i].length; j++){
        invertedImage[i][j] = imageTwoD[(imageTwoD.length-1)-i][(imageTwoD[i].length-1)-j];
      }
    }
    return invertedImage;
	}

  /*
   * modifies every pixel in the image by provided R, G, and B values as input parameters.
   */
	public static int[][] colorFilter(int[][] imageTwoD, int redChangeValue, int greenChangeValue, int blueChangeValue) {
		// new 2D array of ints which is the same size as the input image
		int[][] colorFilter = new int[imageTwoD.length][imageTwoD[0].length];
    // iterate through every pixel in the input image (row-major order)
    for (int i = 0; i < imageTwoD.length; i++){
      for (int j = 0; j < imageTwoD[i].length; j++){
        // extract the RGBA color values
        int[] rgba = getRGBAFromPixel(imageTwoD[i][j]);
        //store the values of each color plus the modifier value
          //for red
          int newRed = rgba[0] + redChangeValue;
          //checks if the values are out of bounds (1 < x < 256), if they are, sets them to 0
          if (newRed > 255) {
					newRed = 255;
				} else if (newRed < 0) {
					newRed = 0;
				}
          //for green
          int newGreen = rgba[1] + greenChangeValue;
          //checks if the values are out of bounds (1 < x < 256), if they are, sets them to 0
          if (newGreen > 255) {
					newGreen = 255;
				} else if (newGreen < 0) {
					newGreen = 0;
				}
          //for blue
          int newBlue = rgba[2] + blueChangeValue;
          //checks if the values are out of bounds (1 < x < 256), if they are, sets them to 0
				if (newBlue > 255) {
					newBlue = 255;
				} else if (newBlue < 0) {
					newBlue = 0;
				}
        //sets the values in RGBA to new color values
        rgba[0] = newRed;
        rgba[1] = newGreen;
        rgba[2] = newBlue;
        //converts RGBA array to single int containing the hexadecimal pixel data and stores it in the new image
        colorFilter[i][j] = getColorIntValFromRGBA(rgba);
      }
    }
		return colorFilter;
	}
// Painting Methods
  // modify the image passed in by replacing every pixel with a randomly colored pixel
	public static int[][] paintRandomImage(int[][] canvas) {
    // new random object to generate random numbers
		Random rand = new Random();
    // iterate through every pixel in the input image (row-major order)
    for (int i = 0; i < canvas.length; i++){
      for (int j = 0; j < canvas[i].length; j++){
        //generates a randomly colored pixel for each color
        int randRed = rand.nextInt(256);
        int randGreen = rand.nextInt(256);
        int randBlue = rand.nextInt(256);
        //stores red, green, blue and alpha value into an array
        int[] rgba = {randRed, randGreen, randBlue, 255};
        canvas[i][j] = getColorIntValFromRGBA(rgba);
      }
    }
		return canvas;
	}

  // draws a rectangle on an image using a provided width, height, rowPosition, columnPosition, and color
	public static int[][] paintRectangle(int[][] canvas, int width, int height, int rowPosition, int colPosition, int color) {
    // iterate through every pixel in the input image (row-major order)
    for (int i = 0; i < canvas.length; i++){
      for (int j = 0; j < canvas[i].length; j++){
        if ((i >= rowPosition && i <= rowPosition + width) && (j>=colPosition && j<=colPosition + height)){
            canvas[i][j] = color;
        }
      }
    }
		return canvas;
	}

  /*
   * will generate randomly positioned, sized, and colored rectangles based on the provided number
   */

	public static int[][] generateRectangles(int[][] canvas, int numRectangles) {
		// new random object to generate random numbers
		Random rand = new Random();
    // iterate for the number of rectangles provided
    for(int i = 0; i < numRectangles; i++) {
        // generates a random number for rectangle height and width
        int randHeight = rand.nextInt(canvas.length);
        int randWidth = rand.nextInt(canvas[0].length);
        // generates a random number for row and column position
        int randRowPosition = rand.nextInt(canvas.length - randHeight);
        int randColumnPosition = rand.nextInt(canvas[0].length - randWidth);
        // create a random color to paint the rectangle
        int[] rgba = {rand.nextInt(256), rand.nextInt(256), rand.nextInt(256), 255};
        int randColor = getColorIntValFromRGBA(rgba);
        canvas = paintRectangle(canvas, randWidth, randHeight, randRowPosition, randColumnPosition, randColor);
        }
		return canvas;
	}
// end of methods created by me 


// Utility Methods
  /* accepts a String which can be a file path or image URL. It returns a 2D array of integers that contains every pixel from 
   * the image stored as int hexadecimal values containing the RGBA values for the pixel. Take a look at how the method works in  
   * the code editor. In the main() method, we can load image data into a 2D array of ints using the imgToTwoD() method.
   */
	public static int[][] imgToTwoD(String inputFileOrLink) {
		try {
			BufferedImage image = null;
			if (inputFileOrLink.substring(0, 4).toLowerCase().equals("http")) {
				URL imageUrl = new URL(inputFileOrLink);
				image = ImageIO.read(imageUrl);
				if (image == null) {
					System.out.println("Failed to get image from provided URL.");
				}
			} else {
				image = ImageIO.read(new File(inputFileOrLink));
			}
			int imgRows = image.getHeight();
			int imgCols = image.getWidth();
			int[][] pixelData = new int[imgRows][imgCols];
			for (int i = 0; i < imgRows; i++) {
				for (int j = 0; j < imgCols; j++) {
					pixelData[i][j] = image.getRGB(j, i);
				}
			}
			return pixelData;
		} catch (Exception e) {
			System.out.println("Failed to load image: " + e.getLocalizedMessage());
			return null;
		}
	}
  /*
   * accepts a 2D array of integers and a String for the file name. It converts the 2D array of int pixel data into an image and 
   * saves it.
   */
	public static void twoDToImage(int[][] imgData, String fileName) {
		try {
			int imgRows = imgData.length;
			int imgCols = imgData[0].length;
			BufferedImage result = new BufferedImage(imgCols, imgRows, BufferedImage.TYPE_INT_RGB);
			for (int i = 0; i < imgRows; i++) {
				for (int j = 0; j < imgCols; j++) {
					result.setRGB(j, i, imgData[i][j]);
				}
			}
			File output = new File(fileName);
			ImageIO.write(result, "jpg", output);
		} catch (Exception e) {
			System.out.println("Failed to save image: " + e.getLocalizedMessage());
		}
	}

  /*
   * accepts an int value representing the pixel hexadecimal value and returns a 4 element int array consisting of the R, G, B, 
   * and A values (between 0 and 255). 
   */
	public static int[] getRGBAFromPixel(int pixelColorValue) {
		Color pixelColor = new Color(pixelColorValue);
		return new int[] { pixelColor.getRed(), pixelColor.getGreen(), pixelColor.getBlue(), pixelColor.getAlpha() };
	}

  /*
   * accepts an array of integers that represent the RGBA values and convert it into a single int value representing the pixel 
   * hexadecimal value.
   */
	public static int getColorIntValFromRGBA(int[] colorData) {
		if (colorData.length == 4) {
			Color color = new Color(colorData[0], colorData[1], colorData[2], colorData[3]);
			return color.getRGB();
		} else {
			System.out.println("Incorrect number of elements in RGBA array.");
			return -1;
		}
	}

  /*
   * used to view the structure of the image data in both the raw pixel form and the extracted RGBA form.
   */
	public static void viewImageData(int[][] imageTwoD) {
		if (imageTwoD.length > 3 && imageTwoD[0].length > 3) {
			int[][] rawPixels = new int[3][3];
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					rawPixels[i][j] = imageTwoD[i][j];
				}
			}
			System.out.println("Raw pixel data from the top left corner.");
			System.out.print(Arrays.deepToString(rawPixels).replace("],", "],\n") + "\n");
			int[][][] rgbPixels = new int[3][3][4];
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					rgbPixels[i][j] = getRGBAFromPixel(imageTwoD[i][j]);
				}
			}
			System.out.println();
			System.out.println("Extracted RGBA pixel data from top the left corner.");
			for (int[][] row : rgbPixels) {
				System.out.print(Arrays.deepToString(row) + System.lineSeparator());
			}
		} else {
			System.out.println("The image is not large enough to extract 9 pixels from the top left corner");
		}
	}
}