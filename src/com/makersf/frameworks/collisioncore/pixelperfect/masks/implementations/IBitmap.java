package com.makersf.frameworks.collisioncore.pixelperfect.masks.implementations;

public interface IBitmap {
	/**
	 * The coordinate system set the (0,0) point as the bottom left corner, and the coordinates raise going up and right
	 * You'll probably need to take into account some adjustements in order to return the correct result.
	 * 
	 * @return the Color at the specified location
	 * 
	 * Colors are represented as packed ints, made up of 4 bytes: alpha, red, green, blue.
	 * The values are unpremultiplied, meaning any transparency is stored solely in the alpha component,
	 * and not in the color components.
	 * The components are stored as follows (alpha << 24) | (red << 16) | (green << 8) | blue.
	 * Each component ranges between 0..255 with 0 meaning no contribution for that component,
	 * and 255 meaning 100% contribution.
	 * Thus opaque-black would be 0xFF000000 (100% opaque but no contributions from red, green, or blue),
	 * and opaque-white would be 0xFFFFFFFF 
	 */
	public int getPixel(int x, int y);
}
