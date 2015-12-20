package com.makersf.frameworks.shared.collisioncore.pixelperfect;

public class BaseShape implements IShape {

	private final float mWidth;
	private final float mHeight;
	private final Transformation mTransformation;
	private Transformation mCachedInverse;

	public BaseShape(float pWidth, float pHeight) {
		mWidth = pWidth;
		mHeight = pHeight;
		mTransformation = new Transformation();
	}

	public BaseShape(float pWidth, float pHeight, float xTranslation, float yTranslation, float pClockWiseRotationDegrees) {
		mWidth = pWidth;
		mHeight = pHeight;
		mTransformation = new Transformation(1, 1, pClockWiseRotationDegrees, xTranslation, yTranslation);
	}

	public BaseShape(float pWidth, float pHeight, float xTranslation, float yTranslation, float pClockWiseRotationDegrees, float xScale, float yScale) {
		mWidth = pWidth;
		mHeight = pHeight;
		mTransformation = new Transformation(xScale, yScale, pClockWiseRotationDegrees, xTranslation, yTranslation);
	}

	public BaseShape(float pWidth, float pHeight, float xTranslation, float yTranslation, float xScale, float yScale, float xSkew, float ySkew) {
		mWidth = pWidth;
		mHeight = pHeight;
		mTransformation = new Transformation(xScale, yScale, xSkew, ySkew, xTranslation, yTranslation);
	}

	@Override
	public Transformation getLocalToSceneTransformation() {
		return mTransformation;
	}

	@Override
	public Transformation getSceneToLocalTransformation() {
		if (mCachedInverse == null) {
			mCachedInverse = new Transformation();
			mTransformation.invert(mCachedInverse);
		}
		return mCachedInverse;
	}

	@Override
	public float getWidth() {
		return mWidth;
	}

	@Override
	public float getHeight() {
		return mHeight;
	}
}
