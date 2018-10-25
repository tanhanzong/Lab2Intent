package my.edu.tarc.lab2intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String MESSAGE_TAG = "my.edu.tarc.lab2intent.MESSAGE" ;
    private static final int REPLY_REQUEST_CODE = 1 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Main", "OnCreate");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Main", "OnPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Main", "OnResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Main", "OnDestroy");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REPLY_REQUEST_CODE && resultCode == RESULT_OK){
            TextView textViewReply;
            textViewReply = findViewById(R.id.textViewReply);
            //TODO: Obtain reply from the intent data
            if(data.hasExtra(SecondActivity.REPLY_TAG)){
                String stringReply = data.getStringExtra(SecondActivity.REPLY_TAG);
                textViewReply.setText(stringReply);
            }
        }

    }

    //Event handler for the SEND button
    public void sendMessage(View view){
        EditText editTextMessage;
        editTextMessage = findViewById(R.id.editTextMessage);
        if(TextUtils.isEmpty(editTextMessage.getText())){
            editTextMessage.setError(getString(R.string.error_message));
            return;
        }
        String stringMsg = editTextMessage.getText().toString();

        //Use an intent and pass data to the SecondActivity
        Intent intent = new Intent(this, SecondActivity.class); //Expicit Intent
        intent.putExtra(MESSAGE_TAG, stringMsg);
        startActivityForResult(intent, REPLY_REQUEST_CODE);
    }


}





