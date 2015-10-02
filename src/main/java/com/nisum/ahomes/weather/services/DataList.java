package com.nisum.ahomes.weather.services;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataList {

	@XmlElement(name = "hour")
	public List<DataPeerHour> datas;

	public void printDatas(){
		for(DataPeerHour data : datas){
			data.printerData();
		}
	}


	public List<DataPeerHour> getDatasList(String date, String hour){
		List<DataPeerHour> datas2 = new ArrayList<DataPeerHour>();

		for(DataPeerHour data : datas)
			if(data.getDate().equals(date) && data.getHour().equals(hour))
				datas2.add(data);
		return datas2;
	}

}
