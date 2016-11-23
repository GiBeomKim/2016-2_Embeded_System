package kr.a60100108.test03ver1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.widget.TextView;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }

    Context mContext;
    private static String num;

    @Override
    public void onReceive(Context mContext, Intent intent)
    {
        try {
            String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
            if(state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
                num = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
                if (num.equals("070")){
                    Toast.makeText(mContext, num +" 번호는 스팸입니다", Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(mContext, num +" 번호로 전화 왔습니다", Toast.LENGTH_LONG).show();
            }
            if(state.equals(TelephonyManager.EXTRA_STATE_OFFHOOK))
                Toast.makeText(mContext, "전화 받았습니다", Toast.LENGTH_LONG).show();

            if (state.equals(TelephonyManager.EXTRA_STATE_IDLE))
                Toast.makeText(mContext, "전화 끊었습니다", Toast.LENGTH_LONG).show();

        }
        catch(Exception e) {}
    }


}
