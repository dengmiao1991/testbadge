package qihoo360.testbadge;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

/**
 * Created by dengmiao on 2017/11/17.
 */

public class CActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_b);
        TextView textView=findViewById(R.id.contentTv);
        textView.setText("C PAGE");
    }
}
