package it.moondroid.fragments_example1;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class FirstFragment extends Fragment {

	private Button button1;

	//To allow a Fragment to communicate up to its Activity, 
	//you can define an interface in the Fragment class and implement it within the Activity
	private FragmentListener mCallback;
	
	// Container Activity must implement this interface
	public interface FragmentListener {
		public void onFragment1Click(View v);
	}
	
	//The Fragment captures the interface implementation during its onAttach() lifecycle method
	@Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        
        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (FragmentListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement FragmentListener");
        }
    }
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		// Inflate the layout for this fragment
		View v = inflater.inflate(R.layout.fragment_first, container, false);
		
		//create onClickListener for the button
		button1 = (Button)v.findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				//call the Interface methods in order to communicate with the Activity
				mCallback.onFragment1Click(v);
				
			}
		});
		
		return v;
	}
	
}
