package qihoo360.testbadge;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.qihoo360.mobilesafe.shortcutsdk.api.ShortcutSDK;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mAddBtn=findViewById(R.id.addBtn);
        Button mDelBtn=findViewById(R.id.delBtn);
        mAddBtn.setOnClickListener(this);
        mDelBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
       int id=view.getId();
        int ret=-99;
        Intent intent=MainActivity.this.getApplicationContext().getPackageManager().getLaunchIntentForPackage(this.getPackageName());
        if (id==R.id.addBtn){

           //  ret=ShortcutSDK.setBadge(MainActivity.this,"TestBadge",intent,2,null);
          //  ComponentName cn=new ComponentName("com.android.settings", "com.android.settings.Settings$DataUsageSummaryActivity");
            ComponentName cn=new ComponentName("com.android.phone", "com.android.phone.MobileNetworkSettings");
            Intent i = new Intent(Settings.ACTION_DATA_ROAMING_SETTINGS);
            i.setComponent(cn);
          //  i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
        }else {
            ret=ShortcutSDK.setBadge(MainActivity.this,"TestBadge",intent,0,null);
        }

        Log.e("TestBadge", "onClick: ret="+ret);
        Toast.makeText(MainActivity.this,"ret:"+ret,Toast.LENGTH_LONG).show();
    }
}
