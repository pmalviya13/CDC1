package com.eg2.kafka;

import java.util.*;
import com.google.gson.*;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import com.eg2.properties.ProducerProperties;
import java.io.*;
import com.google.gson.Gson;
import com.eg2.dto.EmployeeDTO;
public class KProducer {
    public static void sendRecords(List<EmployeeDTO> employees)
    {	
    	Properties prop=ProducerProperties.getProperties();
    	Producer<String, String> producer = new KafkaProducer(prop);
    	Gson gson=new Gson();
    	String employeeString=null;
    	for(EmployeeDTO e:employees)
    	{	
    		employeeString =gson.toJson(e);
    		ProducerRecord<String, String> rec = new ProducerRecord<String, String>("employee", Integer.toString(e.getCode()),employeeString);
    		producer.send(rec);
    	}
        
    }
}
