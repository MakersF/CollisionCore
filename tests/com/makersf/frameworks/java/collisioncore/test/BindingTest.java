package com.makersf.frameworks.java.collisioncore.test;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import org.junit.Test;

import com.makersf.frameworks.java.collisioncore.bindings.BufferedImageBitmapAdpater;
import com.makersf.frameworks.java.collisioncore.utils.MaskUtils;
import com.makersf.frameworks.shared.collisioncore.pixelperfect.masks.IPixelPerfectMask;
import com.makersf.frameworks.shared.collisioncore.pixelperfect.masks.implementations.BitmapPixelPerfectMask;

public class BindingTest {

	@Test
	public void testCorrectMask() throws IOException {
		InputStream imageSteam = ClassLoader.getSystemResourceAsStream("test/testImage.png");
		BufferedImage bufferedImage = ImageIO.read(imageSteam);

		BufferedImageBitmapAdpater bufImageAdapter = new BufferedImageBitmapAdpater(bufferedImage);
		IPixelPerfectMask mask = new BitmapPixelPerfectMask(bufImageAdapter, 0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), 0);
		File file = new File("res/test/testMaskOutput.png");
		if(!file.exists())
			file.createNewFile();
		OutputStream os = new FileOutputStream(file);
		MaskUtils.MaskToBitmap(mask, new BufferedOutputStream(os));
	}

}
