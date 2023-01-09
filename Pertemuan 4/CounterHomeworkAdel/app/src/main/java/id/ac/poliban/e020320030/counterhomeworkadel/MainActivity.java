package id.ac.poliban.e020320030.counterhomeworkadel;

import static androidx.core.content.PackageManagerCompat.LOG_TAG;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.prefs.AbstractPreferences;

public class MainActivity extends AppCompatActivity {
    private int mCount = 0;
    private TextView mShowCount;
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Adelia");
        mShowCount = (TextView) findViewById(R.id.show_count);
        if (savedInstanceState != null){
            mCount = savedInstanceState.getInt("result");
            mShowCount.setText(Integer.toString(mCount));
            getSupportActionBar().setTitle("Adelia");
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        outState.putInt("result", mCount);
        super.onSaveInstanceState(outState);
    }

    public void showCount(View view){
        mCount++;
        if (mShowCount != null){
            mShowCount.setText(Integer.toString(mCount));
        }
    }

    public void showToast(View view){
        Toast toast = Toast.makeText(this, "Hello Toast !",
                Toast.LENGTH_SHORT);
        toast.show();
    }

    public void countUp(View view){
        mCount++;
        if(mShowCount != null){
            mShowCount.setText(Integer.toString(mCount));
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"onDestroy");
    }
}