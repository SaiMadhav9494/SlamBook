package com.slapapp.slambook;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.ArraySet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by $ukesh $hetty on 30-04-2017.
 */

public class WriteForm extends AppCompatActivity {
    ListView questionsView ;
    List<String> question = new ArrayList<>();
    Button submit;
    String[] answers;
    private  String emailFor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collect_details);
        //questionsView=(ListView) findViewById(R.id.qstens);
        submit=(Button) findViewById(R.id.submit);
        emailFor=getIntent().getStringExtra("emailFor");


       /*
        question.add("Your Name?");
        question.add("Your Nick Name?");
        question.add("Your birthday?");
        question.add("Your Hobbies?");
        question.add("Most Skilled POst?");
        question.add("Favourite Movies?");
        question.add("Favourite action?");
        question.add("Favourite Sportsman?");
        question.add("Favourite Place?");
        question.add("Future Goal?");
        question.add("Favourite Color?");
        question.add("Somthing You care About?");
        answers = new String[question.size()];


*/
        ((EditText)findViewById(R.id.qust1)).setHint("Your Name?");
        ((EditText)findViewById(R.id.qust2)).setHint("Your Nick Name?");
        ((EditText)findViewById(R.id.qust3)).setHint("Your birthday?");
        ((EditText)findViewById(R.id.qust4)).setHint("Your Hobbies?");
        ((EditText)findViewById(R.id.qust5)).setHint("Most Skilled Post?");
        ((EditText)findViewById(R.id.qust6)).setHint("Favourite Movies?");
        ((EditText)findViewById(R.id.qust7)).setHint("Favourite action?");
        ((EditText)findViewById(R.id.qust8)).setHint("Favourite Sportsman?");
        ((EditText)findViewById(R.id.qust9)).setHint("Favourite Place?");
        ((EditText)findViewById(R.id.qust10)).setHint("Future Goal");
        ((EditText)findViewById(R.id.qust11)).setHint("Favourite Color?");
        ((EditText)findViewById(R.id.qust12)).setHint("Something you care about");
        ((EditText)findViewById(R.id.qust13)).setHint("Something about our FriendShip");
        ((EditText)findViewById(R.id.qust14)).setHint("Opinion on Me?");








        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text= emailFor+" Details=";
//                for(int j=0;j<question.size();j++){
//                    //Log.e("WriteForm:",j+") "+answers[j]);
//                    text=text+(j>0&&j<question.size()-1?";":"")+answers[j];
//
//                }
                //"Your Name?"
                text=text+"Your Name? : "+((EditText)findViewById(R.id.qust1)).getText().toString()+";";
                text=text+"Your Nick Name? : "+((EditText)findViewById(R.id.qust2)).getText().toString()+";";
                text=text+"Your birthday? : "+((EditText)findViewById(R.id.qust3)).getText().toString()+";";
                text=text+"Your Hobbies? : "+((EditText)findViewById(R.id.qust4)).getText().toString()+";";
                text=text+"Most Skilled Post? : "+((EditText)findViewById(R.id.qust5)).getText().toString()+";";
                text=text+"Favourite Movies? : "+((EditText)findViewById(R.id.qust6)).getText().toString()+";";
                text=text+"Favourite action? : "+((EditText)findViewById(R.id.qust7)).getText().toString()+";";
                text=text+"Favourite Sportsman? : "+((EditText)findViewById(R.id.qust8)).getText().toString()+";";
                text=text+"Favourite Place? : "+((EditText)findViewById(R.id.qust9)).getText().toString()+";";
                text=text+"Future Goal : "+((EditText)findViewById(R.id.qust10)).getText().toString()+";";
                text=text+"Favourite Color? : "+((EditText)findViewById(R.id.qust11)).getText().toString()+";";
                text=text+"Something you care about : "+((EditText)findViewById(R.id.qust12)).getText().toString()+";";
                text=text+"Something about our FriendShip : "+((EditText)findViewById(R.id.qust13)).getText().toString()+";";
                text=text+"Opinion on Me? : "+((EditText)findViewById(R.id.qust14)).getText().toString();

                Log.e("WriteForm:","Answers="+text);
                writeToFile(text,WriteForm.this,emailFor+".txt");
                Intent intent = new Intent(WriteForm.this,UserHome.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private void writeToFile(String data,Context context,String name) {
        try {

            SharedPreferences sharedPreferences = getSharedPreferences("SlamPref", Context.MODE_PRIVATE);
            String savedFiles=sharedPreferences.getString("savedFiles","");
            SharedPreferences.Editor edit=sharedPreferences.edit();
            edit.putString("savedFiles",savedFiles+name+";");
            edit.commit();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput(name, Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File wrsite failed: " + e.toString());
        }
    }
/*

    class QuestionAdaptor extends ArrayAdapter<String>{
        public QuestionAdaptor(Context context) {
            super(context, 0, question);
        }

        @Override
        public int getCount() {
            return question.size();    // total number of elements in the list
        }

        @Override
        public String getItem(int i) {
            return question.get(i);    // single item in the list
        }

        @Override
        public long getItemId(int i) {
            return i;                   // index number
        }

        @Override
        public View getView(final int index, View view, final ViewGroup parent) {

            if (view == null) {
                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
                view = inflater.inflate(R.layout.list_data, parent, false);
            }

            final String qust=question.get(index);

            final EditText qustText = (EditText) view.findViewById(R.id.answer);
            qustText.setHint(""+qust);
            qustText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    Log.e("WriteForm.java:","Write=\t"+qustText.getText());
                    answers[index]=qustText.getText().toString();
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });

            qustText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    Log.e("WriteForm.java:","Write=\t"+qustText.getText());
                    return true;
                }
            });


            return view;
        }
    }

*/

/*    public class QuestionAdaptor extends BaseAdapter {
        private LayoutInflater mInflater;


        public QuestionAdaptor() {
            mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            notifyDataSetChanged();
        }

        public int getCount() {
            return question.size();
        }

        public Object getItem(int position) {
            return question.get(position);
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = mInflater.inflate(R.layout.list_data, null);
                holder.caption = (EditText) convertView
                        .findViewById(R.id.answer);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            //Fill EditText with the value you have in data source
            holder.caption.setText(question.get(position));
            holder.caption.setId(position);

            //we need to update adapter once we finish with editing
            holder.caption.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public void onFocusChange(View v, boolean hasFocus) {
                    if (!hasFocus){
                        final int position = v.getId();
                        final EditText Caption = (EditText) v;
                        answers[position] = Caption.getText().toString();
                    }
                }
            });

            return convertView;
        }
    }

  */
}


