package com.makersf.frameworks.java.collisioncore.utils;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import com.makersf.frameworks.shared.collisioncore.pixelperfect.masks.IPixelPerfectMask;

/**
 * 
 * @author Francesco Zoffoli
 * @since 01.08.2012
 *
 */
public class MaskUtils {

	public static void MaskToBitmap(IPixelPerfectMask pMask, OutputStream pOutputStream) throws IOException {
		BufferedImage bi = new BufferedImage(pMask.getWidth(), pMask.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
		for(int x = 0; x < pMask.getWidth(); x++)
			for(int y = 0; y < pMask.getHeight(); y++) {
				int color;
				if(pMask.isSolid(x, y))
					color = Color.BLACK.getRGB();
				else
					color = Color.WHITE.getRGB();
				bi.setRGB(x, y, color);
			}
		ImageIO.write(bi, "PNG", pOutputStream);
	}

	public static boolean compare(IPixelPerfectMask pA, IPixelPerfectMask pB) {
		if(pA.getWidth() != pB.getWidth() || pA.getHeight() != pB.getHeight())
			return false;
		for(int x = 0; x < pA.getWidth(); x++)
			for(int y = 0; y < pA.getHeight(); y++)
				if(pA.isSolid(x, y) != pB.isSolid(x, y))
					return false;
		return true;
	}
}
