/**
 * 
 */
package com.moztro.android.cv.model;

import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;


/**
 * @author DANIEL
 *
 */
public class CV implements Parcelable{
	public String Title;
	public String[] Tags;
	public String Image;
	public List<ChronologyActivity> Activities;
	public List<CurricularActivity> ExtraCurricularActivities;
	
	public CV(){
		super();
	}
	
	public CV(String _title, String[] _tags){
		this.Title = _title;
		this.Tags = _tags;
	}
	
	private CV(Parcel in){
		readFromParcel(in);
	}
	
	public String getTags(){
		String tags="";
		
		for(String tag : Tags){
			tags += ", "+tag;
		}
		tags = tags.substring(2, tags.length());
		return tags;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void readFromParcel(Parcel in){
		Title = in.readString();
		Tags = new String[5];
		in.readStringArray(Tags);
		Image = in.readString();
		in.readTypedList(Activities, ChronologyActivity.CREATOR);
		in.readTypedList(ExtraCurricularActivities, CurricularActivity.CREATOR);
	}
	
	@Override
	public void writeToParcel(Parcel out, int arg1) {
		// TODO Auto-generated method stub
		out.writeString(Title);
		out.writeStringArray(Tags);
		out.writeString(Image);
		out.writeTypedList(Activities);
		out.writeTypedList(ExtraCurricularActivities);
	}
	
	public static final Parcelable.Creator<CV> CREATOR= new Parcelable.Creator<CV>(){

		@Override
		public CV createFromParcel(Parcel in) {
			// TODO Auto-generated method stub
			return new CV(in);
		}

		@Override
		public CV[] newArray(int size) {
			// TODO Auto-generated method stub
			return new CV[size];
		}
		
	};
}
