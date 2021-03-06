package com.sonda.cisco.util;

import java.awt.*;
import java.awt.image.*;
import java.io.*;


/**
 * Created by JanCarlo on 13/05/2016.
 */



public class CIPImage {

    public final int MAX_DEPTH = 8;
    public final int DEFAULT_DEPTH = 2;
    private String cipHexData;
    private int[] cipData;
    private int cipWidth, cipHeight, cipX, cipY, cipDepth;
    private String cipTitle, cipPrompt;

    /**
     * This default constructor creates a new CIPImage object with contains an empty image.
     * Call a load command after instantiation to initialize the image.
     */
    public CIPImage() {
        cipWidth = 0;
        cipHeight = 0;
        cipDepth = 0;
        cipX = 0;
        cipY = 0;
        cipHexData = "";
        cipTitle = "";
        cipPrompt = "";
        cipData = new int[0];
    }



    /**
     * This constructor creates a CIPImage object from a java.awt.Image.BufferedImage object.
     * Any image type supported by the BufferedImage class should work fine with CIPImage.
     * If an error occurs while loading the BufferedImage, the CIPImage will contain invalid data.
     * If detection of loading errors is required, use the default CIPImage constructor and then call
     * loadImage(BufferedImage image) which will return true if the Image loaded successfully.
     *
     * @param i BufferedImage object to be loaded
     */
    public CIPImage(BufferedImage i) {
        loadImage(i);
    }

    public CIPImage(BufferedImage i, int depth) {
        loadImage(i, depth);
    }

    /**
     * This method returns a java.awt.Image.BufferedImage object based on the CIPImage.
     * The BufferedImage will be of type TYPE_INT_ARGB.
     * If the CIPImage object has not been intialized with a successful load command, this returns null.
     *
     * @return Returns a BufferedImage reference if CIPImage contains a valid image, otherwise returns null
     */
    public synchronized BufferedImage getBufferedImage() {
        if (cipWidth == 0 || cipHeight == 0 || cipDepth == 0) {
            return null;
        }

        BufferedImage image = new BufferedImage(cipWidth, cipHeight, BufferedImage.TYPE_INT_ARGB);
        WritableRaster raster = image.getRaster();
        int byteIndex = 0;
        int bitIndex = 0;
        int pixel = 0;
        int column = 0;
        int row = 0;
        int allOnesPixel = (int) Math.pow(2, cipDepth) - 1;

        for (int i = 0; i < cipWidth * cipHeight; i++) {
            pixel = allOnesPixel - ((cipData[byteIndex] & (allOnesPixel << bitIndex)) >>> bitIndex);
            int luminance = (255 / allOnesPixel) * pixel;
            int[] color = {luminance, luminance, luminance, 255};
            raster.setPixel(column, row, color);
            if (bitIndex >= 8 - cipDepth) {
                bitIndex = 0;
                byteIndex++;
            } else {
                for (int j = 0; j < cipDepth; j++) {
                    bitIndex++;
                }
            }

            if (column == cipWidth - 1) {
                column = 0;
                row++;
            } else {
                column++;
            }
        }
        return image;
    }

    /**
     * This method loads a java.awt.Image.BufferedImage object into the CIPImage object performing
     * the necessary color conversion automatically. The CIPImage color depth used is determined by the
     * static int MAX_DEPTH.
     * Any image type supported by the BufferedImage class should work fine with CIPImage.
     * loadImage(BufferedImage image) which will return
     *
     * @param image BufferedImage object to be loaded
     * @return Returns true if the Image loaded successfully, false if the Image was larger than MAX_WIDTH or MAX_HEIGHT.
     */
    public synchronized boolean loadImage(BufferedImage image) {
        WritableRaster raster = image.getRaster();
        ColorModel model = image.getColorModel();
        cipWidth = raster.getWidth();
        cipHeight = raster.getHeight();

        cipDepth = DEFAULT_DEPTH;

        // Calculate size of image data and allocate cipData buffer
        int imageBytes = cipWidth * cipHeight * cipDepth;
        if (Math.floor(imageBytes / 8) == ((double) imageBytes) / 8)
            imageBytes = imageBytes / 8;
        else
            imageBytes = (imageBytes / 8) + 1;
        cipData = new int[imageBytes];

        int allOnesPixel = (int) Math.pow(2, cipDepth) - 1;

        int bitIndex = 0;
        int byteIndex = 0;
        for (int y = 0; y < cipHeight; y++) {
            for (int x = 0; x < cipWidth; x++) {
                Object data = raster.getDataElements(x, y, null);
                int luminance = (model.getRed(data) + model.getBlue(data) + model.getGreen(data)) / 3;
                int pixel = allOnesPixel - (int) (luminance * (allOnesPixel + 0.5) / 255);
                cipData[byteIndex] = cipData[byteIndex] | (pixel << bitIndex);
                if (bitIndex >= 8 - cipDepth) {
                    bitIndex = 0;
                    byteIndex++;
                } else {
                    for (int j = 0; j < cipDepth; j++) {
                        bitIndex++;
                    }
                }
            }
        }

        createHexData();
        return true;
    }

    /**
     * This method loads a java.awt.Image.BufferedImage object into the CIPImage object performing
     * the necessary color conversion automatically. The CIPImage color depth used is determined by the
     * static int MAX_DEPTH.
     * Any image type supported by the BufferedImage class should work fine with CIPImage.
     * loadImage(BufferedImage image) which will return
     *
     * @param image BufferedImage object to be loaded
     * @return Returns true if the Image loaded successfully, false if the Image was larger than MAX_WIDTH or MAX_HEIGHT.
     */
    public synchronized boolean loadImage(BufferedImage image, int depth) {
        WritableRaster raster = image.getRaster();
        ColorModel model = image.getColorModel();
        cipWidth = raster.getWidth();
        cipHeight = raster.getHeight();

        cipDepth = depth;

        // Calculate size of image data and allocate cipData buffer
        int imageBytes = cipWidth * cipHeight * cipDepth;
        if (Math.floor(imageBytes / 8) == ((double) imageBytes) / 8)
            imageBytes = imageBytes / 8;
        else
            imageBytes = (imageBytes / 8) + 1;
        cipData = new int[imageBytes];

        int allOnesPixel = (int) Math.pow(2, cipDepth) - 1;

        int bitIndex = 0;
        int byteIndex = 0;
        for (int y = 0; y < cipHeight; y++) {
            for (int x = 0; x < cipWidth; x++) {
                Object data = raster.getDataElements(x, y, null);
                int luminance = (model.getRed(data) + model.getBlue(data) + model.getGreen(data)) / 3;
                int pixel = allOnesPixel - (int) (luminance * (allOnesPixel + 0.5) / 255);
                cipData[byteIndex] = cipData[byteIndex] | (pixel << bitIndex);
                if (bitIndex >= 8 - cipDepth) {
                    bitIndex = 0;
                    byteIndex++;
                } else {
                    for (int j = 0; j < cipDepth; j++) {
                        bitIndex++;
                    }
                }
            }
        }

        createHexData();
        return true;
    }




    private void createHexData() {
        cipHexData = "";
        for (int i = 0; i < cipData.length; i++) {
            if (cipData[i] < 16) {
                cipHexData = cipHexData + "0";
            }
            cipHexData = cipHexData + Integer.toHexString(cipData[i]).toUpperCase();
        }
    }




    /**
     * This method returns the raw ASCII Hex data contained in the CIPImage object - no XML tags.
     *
     * @return String containing the CiscoIPPhoneImage ASCII Hex data
     */
    public synchronized String saveCIPDataToBuffer() {
        return cipHexData;
    }


    /**
     * @return Returns a String containing the Title of the CiscoIPPhoneImage
     */
    public synchronized String getTitle() {
        return cipTitle;
    }

    /**
     * @param title Sets the Title of the CiscoIPPhoneImage equal to title
     */
    public synchronized void setTitle(String title) {
        cipTitle = title;
    }

    /**
     * @return Returns a String containing the Prompt of the CiscoIPPhoneImage
     */
    public synchronized String getPrompt() {
        return cipPrompt;
    }

    /**
     * @param prompt Sets the Prompt of the CiscoIPPhoneImage equal to prompt
     */
    public synchronized void setPrompt(String prompt) {
        cipPrompt = prompt;
    }

    /**
     * @return Returns the current LocationX value of the CiscoIPPhoneImage
     */
    public synchronized int getX() {
        return cipX;
    }

    /**
     * @return Returns the current LocationY value of the CiscoIPPhoneImage
     */
    public synchronized int getY() {
        return cipY;
    }

    /**
     * @param x Sets the current LocationX of the CiscoIPPhoneImage x
     */
    public synchronized void setX(int x) {
        cipX = x;
    }

    /**
     * @param y Sets the current LocationY of the CiscoIPPhoneImage y
     */
    public synchronized void setY(int y) {
        cipY = y;
    }

    /**
     * @return Returns the current LocationX,Y of the CiscoIPPhoneImage in the form of a java.awt.Point
     */
    public synchronized Point getLocation() {
        Point p = new Point(cipX, cipY);
        return p;
    }

    /**
     * @param p Sets the current Location of the CiscoIPPhoneImage to the specified java.awt.Point
     */
    public synchronized void setLocation(Point p) {
        cipX = p.x;
        cipY = p.y;
    }

    /**
     * @param x LocationX of the CiscoIPPhoneImage
     * @param y LocationY of the CiscoIPPhoneImage
     */
    public synchronized void setLocation(int x, int y) {
        cipX = x;
        cipY = y;
    }

    /**
     * @return Returns the Width of the CiscoIPPhoneImage
     */
    public synchronized int getWidth() {
        return cipWidth;
    }

    /**
     * @return Returns the Height of the CiscoIPPhoneImage
     */
    public synchronized int getHeight() {
        return cipHeight;
    }

    /**
     * @return Returns the color Depth (in bits) of the CiscoIPPhoneImage
     */
    public synchronized int getDepth() {
        return cipDepth;
    }
}
