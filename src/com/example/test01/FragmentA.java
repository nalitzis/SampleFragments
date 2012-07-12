package com.example.test01;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentA extends Fragment {
	private static final String TAG = "FragmentA";
	
	private Button okButton;
	private TextView textView;
	
	private int cnt;
	
	private static final String BT_VALUE = "BTN_VALUE";
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_a_layout, container, false);
        
        return view;
    }

	
	public void onActivityCreated (Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
		okButton =(Button)getActivity().findViewById(R.id.button1);
		textView  = (TextView)getActivity().findViewById(R.id.textView1);
		if(savedInstanceState != null){
			Log.d(TAG, "savedInstanceState not null, value is " + savedInstanceState.getString(BT_VALUE));
			cnt =  savedInstanceState.getInt(BT_VALUE);
			textView.setText(""+cnt);
		}
        okButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				cnt++;
				TextView text = (TextView)getActivity().findViewById(R.id.textView1);
				text.setText(""+cnt);
			}
        	
        });
	}
	
	public void onSaveInstanceState(Bundle outState){
		super.onSaveInstanceState(outState);
		outState.putInt(BT_VALUE, cnt);
	}
	
}
