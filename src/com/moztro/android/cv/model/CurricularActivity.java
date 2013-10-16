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
public class CurricularActivity extends ChronologyActivity implements Parcelable{
	public String Title;
	public String Description;
	
	public CurricularActivity(){
		super();
	}
	
	public CurricularActivity(String _title, String _description){
		this.Title = _title;
		this.Description = _description;
	}
	
	public CurricularActivity(Date _initDate, Date _finalDate,
			String _title, String _description){
		super(_initDate, _finalDate);
		new CurricularActivity(_title, _description);
	}

	private CurricularActivity(Parcel in){
		readFromParcel(in);
	}
	
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void readFromParcel(Parcel in){
		Title = in.readString();
		Description = in.readString();
	}

	@Override
	public void writeToParcel(Parcel out, int flags) {
		// TODO Auto-generated method stub
		out.writeString(Title);
		out.writeString(Description);
	}
	
	public static final Parcelable.Creator<CurricularActivity> CREATOR = new Parcelable.Creator<CurricularActivity>() {
		
		@Override
		public CurricularActivity[] newArray(int size) {
			// TODO Auto-generated method stub
			return new CurricularActivity[size];
		}
		
		@Override
		public CurricularActivity createFromParcel(Parcel source) {
			// TODO Auto-generated method stub
			return new CurricularActivity(source);
		}
	};
	
	@Override
	public String toString(){
		return this.Title
				+"\n"+this.Description
				+"\n";
	}
}
