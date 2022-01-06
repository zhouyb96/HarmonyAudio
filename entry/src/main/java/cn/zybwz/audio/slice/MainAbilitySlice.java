package cn.zybwz.audio.slice;

import cn.zybwz.audio.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.agp.components.PositionLayout;
import ohos.agp.components.Text;
import ohos.agp.utils.Color;
import ohos.agp.colors.RgbColor;
import ohos.agp.components.element.ShapeElement;
import ohos.agp.components.ComponentContainer.LayoutConfig;
import ohos.agp.window.dialog.ToastDialog;

public class MainAbilitySlice extends AbilitySlice implements Component.ClickedListener {
    // Load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("hello");
    }

    private Button startRecord;
    private Button stopRecord;
    private Button startPlay;

    private String path;
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_main_ability_slice);
        startRecord = (Button) findComponentById(ResourceTable.Id_start_record_button);
        stopRecord = (Button) findComponentById(ResourceTable.Id_stop_record_button);
        startPlay = (Button) findComponentById(ResourceTable.Id_play_record_button);

        startRecord.setClickedListener(this);
        stopRecord.setClickedListener(this);
        startPlay.setClickedListener(this);
        path=getContext().getExternalFilesDir("record").getPath()+"/1.pcm";
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native void startRecord(String path);
    public native void stopRecord();
    public native void playRecord(String path);

    @Override
    public void onClick(Component component) {
        switch (component.getId()){
            case ResourceTable.Id_start_record_button:
                startRecord.setText("录音中...");
                ToastDialog toastDialog = new ToastDialog(this);
                toastDialog.setText("开始录音");
                toastDialog.setDuration(1000);
                toastDialog.show();
                startRecord(path);
                break;

            case ResourceTable.Id_stop_record_button:
                stopRecord();
                ToastDialog toastDialog2 = new ToastDialog(this);
                toastDialog2.setText("文件保存至："+path);
                toastDialog2.setDuration(1000);
                toastDialog2.show();
                startRecord.setText("开始录音");
                break;

            case ResourceTable.Id_play_record_button:
                ToastDialog toastDialog3 = new ToastDialog(this);
                toastDialog3.setText("开始播放");
                toastDialog3.setDuration(1000);
                toastDialog3.show();
                playRecord(path);
                break;
        }
    }


}
