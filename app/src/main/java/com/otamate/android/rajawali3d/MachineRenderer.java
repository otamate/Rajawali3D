package com.otamate.android.rajawali3d;

import android.content.Context;
import android.view.MotionEvent;

import org.rajawali3d.Object3D;
import org.rajawali3d.animation.Animation3D;
import org.rajawali3d.lights.PointLight;
import org.rajawali3d.loader.LoaderOBJ;
import org.rajawali3d.loader.ParsingException;
import org.rajawali3d.math.vector.Vector3;
import org.rajawali3d.renderer.RajawaliRenderer;

public class MachineRenderer extends RajawaliRenderer {
    private PointLight mLight;
    private Object3D mObjectGroup;
    private Animation3D mCameraAnim, mLightAnim;

    public MachineRenderer(Context context) {
        super(context);
        setFrameRate(60);
    }


    public void onTouchEvent(MotionEvent event){
    }

    public void onOffsetsChanged(float x, float y, float z, float w, int i, int j){
    }

    protected void initScene() {
        mLight = new PointLight();
        mLight.setPosition(0, 0, 4);
        mLight.setPower(3);
        //mCamera.setZ(12);

        try {
            LoaderOBJ objParser = new LoaderOBJ(mContext.getResources(), mTextureManager, R.raw.generator_obj);
            objParser.parse();
            mObjectGroup = objParser.getParsedObject();
            //mObjectGroup.addLight(mLight);
            getCurrentScene().addChild(mObjectGroup);

            //mCameraAnim = new RotateAnimation3D(Vector3.Axis.Y, 360);
            //mCameraAnim.setDuration(8000);
            //mCameraAnim.setRepeatCount(Animation3D.INFINITE);
            //mCameraAnim.setTransformable3D(mObjectGroup);
        } catch(ParsingException e) {
            e.printStackTrace();
        }

        //mLightAnim = new RotateAroundAnimation3D(new Number3D(), Vector3.Axis.Z, 10);
        //mLightAnim.setDuration(3000);
        //mLightAnim.setRepeatCount(Animation3D.INFINITE);
        //mLightAnim.setTransformable3D(mLight);
    }

    @Override
    public void onRender(final long elapsedTime, final double deltaTime) {
        super.onRender(elapsedTime, deltaTime);
        mObjectGroup.rotate(Vector3.Axis.Y, 0.25);
    }
}