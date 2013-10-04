package com.makersf.frameworks.collisioncore.utils;

import com.makersf.frameworks.collisioncore.pixelperfect.masks.IPixelPerfectMask;

/**
 * 
 * @author Francesco Zoffoli
 * @since 01.08.2012
 *
 */
public class MaskUtils {

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
