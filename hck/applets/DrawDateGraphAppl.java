// (C) OntoOO Inc 2000
package applets;

import java.util.*;
import java.awt.*;
// import java.awt.image.MemoryImageSource;

public class DrawDateGraphAppl extends java.applet.Applet {
    int width, height;
  //     float fWidth, fHeight;
    float boundaryRatio = (float) 0.05;
    float widthBoundary, heightBoundary;
    int numberOfPairs = 0;
    long minX = 0;
    long maxX = 0;
    int minY = 0;
    int maxY = 0;
    long xs[];
    int ys[];
    String xText, yText, leftBottomSt, rightBottomSt;
  public void init() {
    width = size().width;
    height = size().height;
    widthBoundary = width * boundaryRatio;
    heightBoundary = height * boundaryRatio;
    String numberOfPairsSt = getParameter("numberOfPairs");
    String minXSt = getParameter("minX");
    String maxXSt = getParameter("maxX");
    String minYSt = getParameter("minY");
    String maxYSt = getParameter("maxY");
    String sequenceSt = getParameter("sequence");
    xText = getParameter("xText");
    yText = getParameter("yText");
    leftBottomSt = getParameter("leftBottomSt");
    rightBottomSt = getParameter("rightBottomSt");
    try {
	numberOfPairs = Integer.parseInt(numberOfPairsSt);
	minX = Long.parseLong(minXSt);
	maxX = Long.parseLong(maxXSt);
	minY = Integer.parseInt(minYSt);
	maxY = Integer.parseInt(maxYSt);
	if ( 1 == numberOfPairs ) {
	  xs = new long[2];
	  ys = new int[2];
	} else {
	  xs = new long[numberOfPairs];
	  ys = new int[numberOfPairs];
	}
	int i = 0;
	StringTokenizer st = new StringTokenizer(sequenceSt);
	String xSt, ySt;
	while ( st.hasMoreTokens() ) {
	    xSt = st.nextToken(); ySt = st.nextToken(); 
	    xs[i] = Long.parseLong(xSt);
	    ys[i] = Integer.parseInt(ySt);
	    i++;
	}
	if ( 1 == numberOfPairs ) { 
	  xs[1] = xs[0]; minX = --xs[0]; ys[1] = ys[0]; numberOfPairs = 2;}
	if (minX == maxX) { minX--; maxX++; }
	if (minY == maxY) { minY--; maxY++; }
    }
    catch (Exception ex) {}
  }
  public void start() {
  }
  public void stop() {
  }
  public void update( java.awt.Graphics gc ) {
    paint(gc);
    }
  public void paint( java.awt.Graphics gc ) {
      // gc.drawString("Hello DdC!", 125, 25);
      // gc.drawString("numberOfPairs: " + numberOfPairs, 125, 35);
      // gc.drawString("minX: " + minX + " maxX: " + maxX, 125, 45);
      // gc.drawString("minY: " + minY + " maxY: " + maxY, 125, 55);

    int left = (int) widthBoundary; 
    int right = (int) (width - widthBoundary);
    int top = (int) heightBoundary;
    int bottom = (int) (height - heightBoundary);
    // draw the frame for the graph
    gc.drawLine(left, top, left, bottom); 
    gc.drawLine(right, top, right, bottom); 
    float height2 = (height - 2 * heightBoundary);
    for (int i = 0; i < 5 ; i++) {
      int y2 = top + (int)((i * height2)/ 4);
      gc.drawLine(left, y2, right, y2);
    }
    // calculate the graph points
    int	pxs[] = new int[numberOfPairs];
    int	pys[] = new int[numberOfPairs];
    float width2 = (width - 2 * widthBoundary);
    for (int i = 0; i < numberOfPairs; i++) {
	pxs[i] = left + (int) (width2 * (xs[i] - minX) / (maxX - minX));
	pys[i] = bottom - (int) (height2 * (ys[i] - minY) / (maxY - minY));
	// gc.drawString(pxs[i] + " " + pys[i], 125, 35+10*i);
    }
    // draw the graph
    gc.setColor(Color.blue);
    gc.drawPolyline(pxs, pys, numberOfPairs);
    for (int i = 0; i < numberOfPairs; i++) {
	gc.drawOval(pxs[i]-3, pys[i]-3, 6, 6);
    }
    // add numbers to x and y axis
    gc.setColor(Color.black);
    gc.drawString(leftBottomSt, left+5, bottom+10);
    gc.drawString(rightBottomSt, right-5*rightBottomSt.length(), bottom+10);
    String yBot = ""+minY;
    gc.drawString(yBot, left-10 -5*yBot.length(), bottom+5);
    String yTop = ""+maxY;
    gc.drawString(yTop, left-10 -5*yTop.length(), top+5);
    // do the text here
    gc.drawString(xText, left + (width/2) - 5*xText.length(), bottom+10);
    gc.drawString(yText, left+10, top+10);
    }
}


