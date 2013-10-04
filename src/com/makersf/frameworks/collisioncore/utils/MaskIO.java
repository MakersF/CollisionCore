package com.makersf.frameworks.collisioncore.utils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

import com.makersf.frameworks.collisioncore.pixelperfect.masks.IPixelPerfectMask;
import com.makersf.frameworks.collisioncore.pixelperfect.masks.factory.IPixelPerfectMaskFactory;
import com.makersf.frameworks.collisioncore.pixelperfect.masks.factory.PixelPerfectMaskFactory;

public class MaskIO {
	private static final int HEADER_INTESTATION = ('M' << 24) | ('A' << 16) | ('S' << 8) | ('K');
	private static final int BITS_PER_BYTE = 8;
	private static final int BYTES_PER_INT = 4;

	public static void writeMask(IPixelPerfectMask pMask, File pFile) throws IOException {
		FileOutputStream fos = new FileOutputStream(pFile);
		DataOutputStream dos = new DataOutputStream(fos);

		ByteBuffer byteBuffer = ByteBuffer.allocate(pMask.getWidth() * pMask.getHeight() / BITS_PER_BYTE + 4 * BYTES_PER_INT);
		byteBuffer.position(0);

		int headerInfo;
		//an int in order to store version, flags or other information in the future
		/*
		 * first byte = version number
		 * 23° bit = endianess (1 = big endian)
		 * the remaining 22 bit are free for future use.
		 */
		headerInfo = (1 << 24) | (1 << 23);
		byteBuffer.putInt(HEADER_INTESTATION);
		byteBuffer.putInt(headerInfo);
		byteBuffer.putInt(pMask.getWidth());
		byteBuffer.putInt(pMask.getHeight());

		int counter = 0;
		byte container = 0;
		for(int x = 0; x < pMask.getWidth(); x++) {
			for(int y = 0; y < pMask.getHeight(); y++) {
				container |= (pMask.isSolid(x, y) ? 1 : 0) << counter;
				counter++;
				if(counter > 7) {
					counter = 0;
					byteBuffer.put(container);
					container = 0;
				}
			}
		}

		dos.write(byteBuffer.array());
		dos.close();
	}

	public static IPixelPerfectMask readMask(File pFile, IPixelPerfectMaskFactory pFactory) throws IOException {
		FileInputStream fis = new FileInputStream(pFile);
		DataInputStream dis = new DataInputStream(fis);
	
		final int headerIntestation = dis.readInt();
		if(headerIntestation != HEADER_INTESTATION) {
			dis.close();
			throw new IOException("The file is not a valid mask file.");
		}
	
		final int headerInfos = dis.readInt();
		if((headerInfos & 0xff000000) >> 24 != 1) {
			dis.close();
			throw new IOException("Unsupported mask version.");
		}
	
		final int width = dis.readInt();
		final int height = dis.readInt();
	
		byte[] byteArray = new byte[width * height / BITS_PER_BYTE];
		dis.read(byteArray);
		dis.close();
	
		ByteBuffer byteBuffer = ByteBuffer.wrap(byteArray);
	
		return pFactory.getIPixelPerfectMask(width, height, byteBuffer);
	}

	public static IPixelPerfectMask readMask(File pFile) throws IOException {
		return readMask(pFile, new PixelPerfectMaskFactory());
	}
}
