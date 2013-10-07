package com.makersf.frameworks.shared.collisioncore.pixelperfect.masks.factory;

import java.nio.ByteBuffer;

import com.makersf.frameworks.shared.collisioncore.pixelperfect.masks.IPixelPerfectMask;

public interface IPixelPerfectMaskFactory {

	public IPixelPerfectMask getIPixelPerfectMask(int pWidth, int pHeight, ByteBuffer pByteBuffer);
}
