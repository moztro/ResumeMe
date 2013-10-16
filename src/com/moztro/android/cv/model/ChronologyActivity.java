/**
 * 
 */
package com.moztro.android.cv.model;

import java.util.Date;

import android.os.Parcel;
import android.os.Parcelable;

import com.moztro.android.cv.enums.EActivity;

/**
 * @author DANIEL
 *
 */
public class ChronologyActivity implements Parcelable {
	public Date InitDate;
	public Date FinalDate;
	public EActivity Activity;
	private int YearsDuration;
	
	public ChronologyActivity(){
		super();
	}
	
	public ChronologyActivity(Date _initDate, Date _finalDate){
		this.InitDate = _initDate;
		this.FinalDate = _finalDate;
		YearsDuration = getYearsDuration();
	}
	
	public ChronologyActivity(Date _initDate, Date _finalDate, EActivity _activity){
		new ChronologyActivity(_initDate, _finalDate);
		this.Activity = _activity;
	}
	
	private ChronologyActivity(Parcel in){
		readFromParcel(in);
	}
	
	public int getYearsDuration(){
		int fin = FinalDate.getYear();
		int ini = InitDate.getYear();
		YearsDuration = fin - ini;
		return YearsDuration;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void readFromParcel(Parcel in){
		InitDate = new Date(in.readString());
		FinalDate = new Date(in.readString());
		YearsDuration = in.readInt();
		Activity = EActivity.valueOf(in.readString());
	}
	
	@Override
	public void writeToParcel(Parcel out, int flags) {
		// TODO Auto-generated method stub
		out.writeString(InitDate.toString());
		out.writeString(FinalDate.toString());
		out.writeString((Activity==null)?"":Activity.name());
		out.writeInt(YearsDuration);
	}
	
	public static final Parcelable.Creator<ChronologyActivity> CREATOR = new Parcelable.Creator<ChronologyActivity>() {

		@Override
		public ChronologyActivity createFromParcel(Parcel source) {
			// TODO Auto-generated method stub
			return new ChronologyActivity(source);
		}

		@Override
		public ChronologyActivity[] newArray(int size) {
			// TODO Auto-generated method stub
			return new ChronologyActivity[size];
		}
	};
}
