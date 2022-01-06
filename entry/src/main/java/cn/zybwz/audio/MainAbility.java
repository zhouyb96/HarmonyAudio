package cn.zybwz.audio;

import cn.zybwz.audio.slice.MainAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.agp.window.dialog.ToastDialog;
import ohos.bundle.IBundleManager;
import ohos.security.SystemPermission;

import java.util.Arrays;

public class MainAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(MainAbilitySlice.class.getName());
        requestPermission();
    }
    private void requestPermission() {
        String[] permissions = {
                SystemPermission.WRITE_USER_STORAGE, SystemPermission.MICROPHONE
        };

        requestPermissionsFromUser(Arrays.stream(permissions)
                .filter(permission -> verifySelfPermission(permission) != IBundleManager.PERMISSION_GRANTED).toArray(String[]::new), 0);
    }

//    @Override
//    public void onRequestPermissionsFromUserResult(int requestCode, String[] permissions, int[] grantResults) {
//        if (permissions == null || permissions.length == 0 || grantResults == null || grantResults.length == 0) {
//            return;
//        }
//        if (requestCode == 0) {
//            if (grantResults[0] == IBundleManager.PERMISSION_GRANTED) {
//
//            }else {
//                ToastDialog toastDialog = new ToastDialog(this);
//                toastDialog.setText("请先授权");
//                terminateAbility();
//            }
//        }
//    }
}
