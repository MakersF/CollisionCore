package com.makersf.frameworks.shared.collisioncore.pixelperfect.masks.implementations;

import com.makersf.frameworks.shared.collisioncore.utils.GenericPool;

/**
 * 
 * @author Francesco Zoffoli
 * @since 01.08.2012
 *
 */
public class RectangularPixelPerfectMaskPool extends GenericPool<RectangularPixelPerfectMask>{

	private static RectangularPixelPerfectMaskPool mInstance;

	private RectangularPixelPerfectMaskPool() {
		super();
	}

	public static RectangularPixelPerfectMaskPool getInstance() {
		if(mInstance == null)
			mInstance = new RectangularPixelPerfectMaskPool();
		return mInstance;
	}

	@Override
	protected RectangularPixelPerfectMask onAllocatePoolItem() {
		return new RectangularPixelPerfectMask(0, 0);
	}

}
