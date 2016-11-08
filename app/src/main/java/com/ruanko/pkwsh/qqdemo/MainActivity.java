package com.ruanko.pkwsh.qqdemo;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void funQQ(View view){
        if(!isInstalled(this,"com.tencent.mobileqq")){
            Toast.makeText(this,"本机没有安装QQ",Toast.LENGTH_SHORT).show();
        }
        String qq="61489730";
        String url="mqqwpa://im/chat?chat_type=wpa&uin="+qq;
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
    }

    /**
     * 判断应用是否已安装
     *
     * @param context
     * @param packageName
     * @return
     */
    private boolean isInstalled(Context context, String packageName) {
        if(packageName == null || "".equals(packageName)){
            return false;
        }
        final PackageManager packageManager = context.getPackageManager();
        // 获取所有已安装程序的包信息
        List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);
        for ( int i = 0; i < pinfo.size(); i++ )
        {
            if(pinfo.get(i).packageName.equalsIgnoreCase(packageName))
                return true;
        }
        return false;
    }
}
