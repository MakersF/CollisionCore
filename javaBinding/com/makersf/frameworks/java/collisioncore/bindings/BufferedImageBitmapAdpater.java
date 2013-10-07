package com.makersf.frameworks.java.collisioncore.bindings;

import java.awt.image.BufferedImage;

import com.makersf.frameworks.shared.collisioncore.pixelperfect.masks.implementations.IBitmap;

public class BufferedImageBitmapAdpater implements IBitmap {

	private final int[] mPixelColors;
	private final int mScanSize;

	public BufferedImageBitmapAdpater(BufferedImage pBufferedImage) {
		final int width = pBufferedImage.getWidth();
		final int height = pBufferedImage.getHeight();
		mPixelColors = new int[width * height];
		mScanSize = width;
		pBufferedImage.getRGB(0, 0, width, height, mPixelColors, 0, mScanSize);
	}

	@Override
	public int getPixel(int x, int y) {
		return mPixelColors[y * mScanSize + x];
	}
}
