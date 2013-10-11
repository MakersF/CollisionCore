package com.makersf.frameworks.shared.collisioncore.pixelperfect.masks.implementations;

public interface IBitmap {
	/**
	 * IMPORTANT NOTE: the (0,0) coordinate is the top left corner of the image rectangle!!
	 *
	 *
	 *
	 * This interface is used to access to the information of an image as a bitmap.
	 * Since some adjustment can be needed (like rotations, inverting, etc) due to differences
	 * in the coordinate system, this method splits the paramenters.
	 * If the coordinate syste is the same for the library and the image and the full image has to
	 * be analyzed, you can just use the offsetX and offsetY paramenters, since baseX and baseY will
	 * be 0 and the widht and height will coincide with the image one's.
	 *
	 * baseX, basseY, width and height define the rectangle that will be querried.
	 *
	 * @param offsetX The offset to the right of baseX of the pixel currently querried
	 * @param offsetY The offset to the top of baseY of the pixel currently querried
	 * @param baseX The coordinate of the rightmost vertices of the rectangle querried
	 * @param baseY The coordinate of the upper vertices of the rectangle querried
	 * @param width The width of the rectangle querried
	 * @param height The height of the rectangle querried
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
	public int getPixel(int offsetX, int offsetY, int baseX, int baseY, int width, int height);
}
