package com.kakao.talk.theme.ryan;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {
    private static final String KAKAOTALK_SETTINGS_THEME_URI = "kakaotalk://settings/theme/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (!hasKakaoTalk()) {
            Toast.makeText(this, "카카오톡이 설치되어 있지 않습니다.", Toast.LENGTH_LONG).show();
            finish();
        } else {
            final Intent intent = new Intent(Intent.ACTION_VIEW);
            Toast.makeText(this,"적용되는 중이니 잠시만 기다려주세요.",Toast.LENGTH_LONG).show();
            intent.setData(Uri.parse(KAKAOTALK_SETTINGS_THEME_URI + getPackageName()));
            startActivity(intent);
            finish();
        }
    }

    public boolean hasKakaoTalk() {
        try {
            this.getPackageManager().getApplicationInfo("com.kakao.talk", 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
}
