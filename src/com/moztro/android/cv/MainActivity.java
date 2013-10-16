package com.moztro.android.cv;

import java.util.ArrayList;

import com.moztro.android.cv.model.CV;
import com.moztro.android.cv.model.CurricularActivity;
import com.moztro.android.cv.model.Education;
import com.moztro.android.cv.model.Job;

import android.os.Bundle;
import android.app.ListActivity;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends ListActivity {
	private CV cv;
	private ArrayList<Job> jobs = new ArrayList<Job>();
	private ArrayList<Education> edus = new ArrayList<Education>();
	private ArrayList<CurricularActivity> extras = new ArrayList<CurricularActivity>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_activity_main);
		
		cv = new CV("Software Developer", 
				new String[]{"dev","software","it"});
		
		addJobs();
		addEducation();
		addExtraActivity();		
		
		
		Toast.makeText(this, 
				cv.Title
				+"\nTAGS: "+cv.getTags()+"\n"
				+"\nJOBS\n"+printJobs()
				+"\nEDUCATION\n"+printEducation()
				+"\nEXTRA\n"+printExtraActivities(),
				Toast.LENGTH_LONG).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private void addJobs(){
		jobs.add(new Job("Java Developer",
				"Development of a large-scale project based on Java Technologies"));
		
		jobs.add(new Job("Performance Testing Enginner",
				"Development of performance unit test for different scenarios"));
	}
	
	private void addEducation(){
		edus.add(new Education("Bachelor on Computer Science",
				"Specialized in mobile apps development"));
	}

	private void addExtraActivity(){
		extras.add(new CurricularActivity("Co-Founder at MoztroDev, Inc.",
				"MoztroDev is an IT Startup-Company for Software Services"));
	}

	private String printJobs(){
		String s="";
		for(Job job : jobs){
			s += job.toString();
		}
		return s;
	}
	
	private String printEducation(){
		String s="";
		for(Education edu : edus){
			s += edu.toString();
		}
		return s;
	}
	
	private String printExtraActivities(){
		String s="";
		for(CurricularActivity extra : extras){
			s += extra.toString();
		}
		return s;
	}
}
