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
public class Education extends ChronologyActivity implements Parcelable{
	public String Degree;
	public String Specialty;
	
	public Education(){
		super();
	}
	
	public Education(String _degree, String _specialty){
		this.Degree = _degree;
		this.Specialty = _specialty;
	}
	
	public Education(String _degree, String _specialty, Date _initDate,
			Date _finalDate){
		super(_initDate, _finalDate);
		new Education(_degree, _specialty);
	}

	private Education(Parcel in){
		readFromParcel(in);
	}
	
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void readFromParcel(Parcel in){
		Degree = in.readString();
		Specialty = in.readString();
	}

	@Override
	public void writeToParcel(Parcel out, int flags) {
		// TODO Auto-generated method stub
		out.writeString(Degree);
		out.writeString(Specialty);
	}
	
	public static final Parcelable.Creator<Education> CREATOR = new Parcelable.Creator<Education>() {

		@Override
		public Education createFromParcel(Parcel source) {
			// TODO Auto-generated method stub
			return new Education(source);
		}

		@Override
		public Education[] newArray(int size) {
			// TODO Auto-generated method stub
			return new Education[size];
		}
		
	};
	
	@Override
	public String toString(){
		return this.Degree
				+"\n"+this.Specialty
				+"\n";
	}
}
