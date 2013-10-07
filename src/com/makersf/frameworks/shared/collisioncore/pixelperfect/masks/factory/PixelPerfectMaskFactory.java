package com.makersf.frameworks.shared.collisioncore.pixelperfect.masks.factory;

import java.nio.ByteBuffer;

import com.makersf.frameworks.shared.collisioncore.pixelperfect.masks.IPixelPerfectMask;
import com.makersf.frameworks.shared.collisioncore.pixelperfect.masks.implementations.CustomPixelPerfectMask;

public class PixelPerfectMaskFactory implements IPixelPerfectMaskFactory {

	@Override
	public IPixelPerfectMask getIPixelPerfectMask(int pWidth, int pHeight,
			ByteBuffer pByteBuffer) {
		return new CustomPixelPerfectMask(pWidth, pHeight, pByteBuffer);
	}

}
