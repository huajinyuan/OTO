package cn.gtgs.base.OTO.activity.home;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;

import java.io.IOException;
import java.util.Vector;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.gtgs.base.OTO.R;
import cn.gtgs.base.OTO.utils.F;
import cn.gtgs.base.OTO.zxing.ViewfinderView;
import cn.gtgs.base.OTO.zxing.camera.CameraManager;
import cn.gtgs.base.OTO.zxing.decode.CaptureActivityHandler;
import cn.gtgs.base.OTO.zxing.decode.InactivityTimer;

public class QrCodeActivity extends AppCompatActivity implements SurfaceHolder.Callback {

    @BindView(R.id.viewfinder_view)
    public ViewfinderView mView;
    private boolean hasSurface;
    private String characterSet;
    private InactivityTimer inactivityTimer;
    private CaptureActivityHandler handler;
    private Vector<BarcodeFormat> decodeFormats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code);
        ButterKnife.bind(this);
        CameraManager.init(getApplication());
        hasSurface = false;
        inactivityTimer = new InactivityTimer(this);
    }

    @OnClick(R.id.img_qrcode_back)
    public void back() {
        this.finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SurfaceView surfaceView = (SurfaceView) findViewById(R.id.preview_view);
        SurfaceHolder surfaceHolder = surfaceView.getHolder();
        if (hasSurface) {
            initCamera(surfaceHolder);
        } else {
            surfaceHolder.addCallback(this);
            surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        }
        decodeFormats = null;
        characterSet = null;

    }


    @Override
    protected void onPause() {
        super.onPause();
        if (handler != null) {
            handler.quitSynchronously();
            handler = null;
        }
        CameraManager.get().closeDriver();
    }

    @Override
    public void onDestroy() {
        inactivityTimer.shutdown();
        super.onDestroy();
    }

    private void initCamera(SurfaceHolder surfaceHolder) {
        try {
            CameraManager.get().openDriver(surfaceHolder);
        } catch (IOException ioe) {
            return;
        } catch (RuntimeException e) {
            return;
        }
        if (handler == null) {
            handler = new CaptureActivityHandler(this, decodeFormats, characterSet);
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        if (!hasSurface) {
            hasSurface = true;
            initCamera(holder);
        }

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        hasSurface = false;

    }

    public ViewfinderView getViewfinderView() {
        return mView;
    }

    public Handler getHandler() {
        return handler;
    }

    public void drawViewfinder() {
        mView.drawViewfinder();
    }

    /**
     * 扫描到二维码或者条形码
     */
    public void handleDecode(Result obj, Bitmap barcode) {

        F.e("二维码：" + obj.getText());
//        ExampleUtil.showToast("扫描结果: " + obj.getText(), this);
//        if (obj.getText().contains("YEQU")) {
//            String[] strs = obj.getText().split("\\|");
//            String OrderNO = strs[1];
//            String anchorId = strs[2];
//            String agentId = strs[3];
//            if (anchorId.equals(loginInfo.id) || agentId.equals(loginInfo.id)) {
//                String url = UriTemplate.fromTemplate(Config.URL_BOOKINGS)
//                        .set("booking_id", OrderNO)
//                        .expand();
//                Request<String> request = null;
//                request = NoHttp.createStringRequest(url, RequestMethod.POST);
//                request.add("key", "z45CasVgh8K3q6300g0d95VkK197291A");
//                request.addHeader("Authorization", "Bearer " + loginInfo.token);
//                requestQueue.add(0, request, responseListener);
//            } else {
//                ExampleUtil.showToast("您没有权限开台", this);
//            }
//
//        } else {
//            ExampleUtil.showToast("请扫描也趣二维码,", this);
//        }
    }

}
