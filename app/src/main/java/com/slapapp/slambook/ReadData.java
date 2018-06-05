package com.slapapp.slambook;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Set;

/**
 * Created by $ukesh $hetty on 30-04-2017.
 */

public class ReadData extends AppCompatActivity {
    TextView data ;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_details);
        sharedPreferences=getSharedPreferences("SlamPref", Context.MODE_PRIVATE);
        String savedFiles=sharedPreferences.getString("savedFiles","");
        data=(TextView)findViewById(R.id.read_value);
        if(!savedFiles.equals("")) {
            String text = "";
            String file[]=savedFiles.split(";");
            for (int j=0;j<file.length;j++) {
                 text=text+readFromFile(getApplicationContext(),file[j]);
            }
            data.setText(text);
        }
        else{
            data.setText("NOT YET GIVEN ANY DETAIL");
        }
    }
    private String readFromFile(Context context,String name) {

//savedFiles.add(emailFor+".txt");
        String ret = "";

        try {
            InputStream inputStream = context.openFileInput(name);

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString+"\n");
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }

        return ret;
    }
}
