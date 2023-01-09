package id.ac.poliban.e020320030.challenge23adelia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

import id.ac.poliban.e020320030.challenge23.R;

public class MainActivity extends AppCompatActivity {
    public static final int TEXT_REQUEST = 1;
    private ButtonList items = new ButtonList ();
    private EditText mLocationEditText;
    private Uri webpage;
    public MainActivity (){

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLocationEditText = findViewById(R.id.location_edittext);

        Intent intent = getIntent();

        if ((savedInstanceState!=null)&&(savedInstanceState.getSerializable("list")!=null)){

            HashMap<String,Integer> buttonlist =(HashMap<String, Integer>)savedInstanceState.getSerializable("list");

            TextView textView = findViewById(R.id.textView);

            textView.setText("");

            for (String goods: buttonlist.keySet()){

                String shopping = buttonlist.get(goods).toString()+ "" + goods + "\n";

                textView.setText(textView.getText() + shopping);

                for(int i = 0; i<buttonlist.get(goods);i++);

                items.addItem(goods);}


        }

    }
    public void launchSecondActivity(View view) {

        Intent intent = new Intent(this, SecondActivity.class);

        startActivityForResult(intent, TEXT_REQUEST);
    }
    @Override

    protected void onSaveInstanceState (Bundle savedInstanceState){

        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putSerializable("list", items.getItems());
    }

    @Override

    public void onActivityResult (int requestCode, int resultCode, Intent data){

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TEXT_REQUEST){

            if (resultCode == RESULT_OK);

            String item = data.getStringExtra(SecondActivity.EXTRA_MESSAGE);

            items.addItem(item);
        }

        drawView();
    }

    private void drawView() {

        HashMap<String,Integer> buttonlist = items.getItems();

        TextView textView = findViewById(R.id.textView);

        textView.setText("");

        for (String goods: buttonlist.keySet()){

            String shopping = buttonlist.get(goods).toString() + "" + goods + "\n";

            textView.setText(textView.getText() + shopping);


        }

    }

    public void openLocation(View view) {
        // Get the string indicating a location. Input is not validated; it is
        // passed to the location handler intact.
        String loc = mLocationEditText.getText().toString();

        // Parse the location and create the intent.
        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

        // Find an activity to handle the intent, and start that activity.
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

}