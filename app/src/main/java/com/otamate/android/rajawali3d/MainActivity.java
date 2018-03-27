package com.otamate.android.rajawali3d;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import org.rajawali3d.Object3D;
import org.rajawali3d.materials.textures.TextureManager;
import org.rajawali3d.surface.IRajawaliSurface;
import org.rajawali3d.surface.RajawaliSurfaceView;

public class MainActivity extends AppCompatActivity {

    EarthRenderer mEarthRenderer;
    MachineRenderer mMachineRenderer;

    protected TextureManager mTextureManager; // Texture manager for ALL textures across ALL scenes.
    private Object3D mObjectGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RajawaliSurfaceView surface = new RajawaliSurfaceView(this);
        surface.setFrameRate(60.0);
        surface.setRenderMode(IRajawaliSurface.RENDERMODE_WHEN_DIRTY);

        // Add mSurface to your root view
        addContentView(surface, new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT));

        //mEarthRenderer = new EarthRenderer(this);
        mMachineRenderer = new MachineRenderer(this);

        //surface.setSurfaceRenderer(mEarthRenderer);
        surface.setSurfaceRenderer(mMachineRenderer);
    }}
