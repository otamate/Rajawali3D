package com.otamate.android.rajawali3d;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

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

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
//Remove title bar
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);

//Remove notification bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        View decorView = getWindow().getDecorView();
// Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
// Remember that you should never show the action bar if the
// status bar is hidden, so hide that too if necessary.
        //ActionBar actionBar = getActionBar();
        //actionBar.hide();

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
