package com.yocn.meida.view.activity;

import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.view.WindowManager;

import com.yocn.media.R;
import com.yocn.meida.camera.Camera1;
import com.yocn.meida.camera.Camera2Provider;
import com.yocn.meida.util.CameraUtil;

/**
 * @Author yocn
 * @Date 2019/8/4 9:46 AM
 * @ClassName Camera1PreviewActivity
 */
public class Camera1PreviewActivity extends BaseCameraActivity {
    TextureView mPreviewView;
    Camera1 mCamera2Provider;
    public static String DESC = "使用Camera2，最基本API，直接输出到TextureView进行预览";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        View rootView = getLayoutInflater().inflate(R.layout.activity_pure_preview, null);
        setContentView(rootView);
        initView(rootView);
        initData();
    }

    @Override
    protected void initView(View root) {
        super.initView(root);
        mPreviewView = root.findViewById(R.id.tv_camera);
        CameraUtil.transTextureView(mPreviewView);
    }

    @Override
    protected void initData() {
        mCamera2Provider = new Camera1();
        mCamera2Provider.setTextureView(mPreviewView);
    }

    @Override
    protected void onDestroy() {
        mCamera2Provider.stopPreview();
        super.onDestroy();
    }

}
