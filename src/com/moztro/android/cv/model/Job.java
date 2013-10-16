/**
 * 
 */
package com.moztro.android.cv.model;

import java.util.Date;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author DANIEL
 *
 */
public class Job extends ChronologyActivity implements Parcelable{
	public String JobPosition;
	public String JobActivities;
	
	public Job(){
		super();
	}
	
	public Job(String _jobPosition, String _jobActivities){
		this.JobPosition = _jobPosition;
		this.JobActivities = _jobActivities;
	}
	
	public Job(String _jobPosition, String _jobActivities, 
			Date _initDate, Date _finalDate){
		super(_initDate, _finalDate);
		new Job(_jobPosition, _jobActivities);
	}

	private Job(Parcel in){
		readFromParcel(in);
	}
	
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void readFromParcel(Parcel in){
		JobPosition = in.readString();
		JobActivities = in.readString();
	}

	@Override
	public void writeToParcel(Parcel out, int flags) {
		// TODO Auto-generated method stub
		out.writeString(JobPosition);
		out.writeString(JobActivities);
	}
	
	public static final Parcelable.Creator<Job> CREATOR = new Parcelable.Creator<Job>() {

		@Override
		public Job createFromParcel(Parcel in) {
			// TODO Auto-generated method stub
			return new Job(in);
		}

		@Override
		public Job[] newArray(int size) {
			// TODO Auto-generated method stub
			return new Job[size];
		}
	};
	
	@Override
	public String toString(){
		return this.JobPosition
				+"\n"+this.JobActivities
				+"\n";
	}
}
