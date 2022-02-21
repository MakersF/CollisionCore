# **Collision Core**


Collision Core is a simple, lightweight, optimized Java 2D collision library.
The goal of the library is to offer efficient implementations of 2D collision methods applicable in every situation.
This means that you can use the collision detection with entities with any affine transformation applied to them (translation, rotation, scale, skew).

At the moment the following collision pairs are supported:

 - PixelPerfect Entity with PixelPerfect Entity
 - PixelPerfect Entity with Rectangle
 - PixelPerfect Entity with Vector of Points
 - Rectangle with Rectangle (this is not optimized)

Initially the library was developed to work with the [AndEngine Android game engine](https://github.com/nicolasgramlich/AndEngine) (this is the reason why Rectangle vs Rectangle is not optimized, as it is already offered in the engine).
It was later separated into its own project as it was decoupled enough to be easily usable with any Java program.
Bindings are still provided to work with AndEngine though [AndEngineCollisionExtension](https://github.com/MakersF/AndEngineCollisionsExtension).


###**PixelPerfect Collision**
Pixel Perfect Collision is a collision detection method which, opposed to the common bounding-box or convex hull methods, checks if two entities collide for every pixel of the two sprites.
This means that pixel perfect collision is **not** an approximation, and there is no way to have a more precise collision detection in a 2D space.

To the best of my knowledge this is the only library (at least in Java) which implements pixel perfect collision detection with versors opposed to matrix multiplication.
All the libraries I know of try to speed up the matrix multiplication or avoid to support some valid affine transformations (like skew).

####Example Code for Java Binding
```java
BufferedImage bufferedImage = ImageIO.read(yourInputStream);

BufferedImageBitmapAdpater bufImageAdapter = new BufferedImageBitmapAdpater(bufferedImage);

IPixelPerfectMask mask = new BitmapPixelPerfectMask(bufImageAdapter, 0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), 0);

BaseShape centered_on_the_origin = new BaseShape(bufferedImage.getWidth(), bufferedImage.getHeight())

BaseShape translated_and_rotated_45_deg = new BaseShape(bufferedImage.getWidth(), bufferedImage.getHeight(), 500, 150, 45);

PixelPerfectCollisionChecker.checkCollision(centered_on_the_origin, mask, translated_and_rotated_45_deg, mask)
```

The shape and the mask are decoupled because this is supposed to be a framework you build your code upon and the library wants you to be free to compose its pieces as it fits best for your code architecture.


####Example Code for AndEngine Bindings

The example code can be seen in the testing project at [CollisionTest](https://github.com/MakersF/CollisionTest).
