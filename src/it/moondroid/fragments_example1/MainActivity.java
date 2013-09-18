package it.moondroid.fragments_example1;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

public class MainActivity extends FragmentActivity 
implements FirstFragment.FragmentListener {

	private FragmentManager fragmentManager;
	//private FirstFragment fragment1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		fragmentManager = getSupportFragmentManager();
		
		if (savedInstanceState==null){ //only when the app is started by the user, not recreated by the system
			
			//programmatically add the first fragment			
			FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();					
			FirstFragment fragment1 = new FirstFragment();
			fragmentTransaction.add(R.id.fragment_container, fragment1);
						
			fragmentTransaction.commit();
		}
		
		
	}

	@Override
	public void onFragment1Click(View v) {
		
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		
		//set animation  for the fragments that are entering and exiting in this transaction
		//setCustomAnimations (int enter, int exit, int popEnter, int popExit)
		//The popEnter and popExit animations will be played for enter/exit operations specifically when popping the back stack		
		fragmentTransaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
		
		//replace first fragment with second fragment
		SecondFragment fragment2 = new SecondFragment();
		fragmentTransaction.replace(R.id.fragment_container, fragment2);
		
		//you might want to call addToBackStack(), in order to add the transaction to a back stack of fragment transactions. 
		//This back stack is managed by the activity and allows the user to return to the previous fragment state, by pressing the Back button.
		fragmentTransaction.addToBackStack(null);
				
		fragmentTransaction.commit();
	}

	

}
