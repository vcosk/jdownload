/*
 * This file is part of Yet Another jDownloader.

    jDownloader 
    is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    jDownloader
     is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with jDownloader.
    If not, see <http://www.gnu.org/licenses/>.
 */

package in.goahead.apps.util;

import in.goahead.apps.log.AppLogger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
	
	private static AppLogger Logger = AppLogger.getLogger(URLUtils.class);
	
	public static Object parseCSV(String inputFile, String beanFileClass, String[] setters) {
		List<Object> parsedDataList = new ArrayList<Object>();
		Object parsedDataArrayObject = null;
		BufferedReader br = null;
		
		try {
			Class<?> beanClass = Class.forName(beanFileClass);
			Method[] setterMethods = new Method[setters.length];
			for(int methodIndex=0; methodIndex<setters.length; methodIndex++) {
				setterMethods[methodIndex] = beanClass.getMethod(setters[methodIndex], String.class);
			}
			
			br = new BufferedReader(new FileReader(inputFile));
			while(br.ready()) {
				String dataLine = br.readLine();
				String[] dataArray = dataLine.split(",");
				Object beanObject = beanClass.newInstance();
				for(int index=0; index < setters.length; index++) {
					setterMethods[index].invoke(beanObject, dataArray[index]);
				}				
				parsedDataList.add(beanObject);
			}
			parsedDataArrayObject = Array.newInstance(beanClass, parsedDataList.size());
			for(int dataObjectIndex = 0; dataObjectIndex < parsedDataList.size(); dataObjectIndex++) {
				Array.set(parsedDataArrayObject, dataObjectIndex, parsedDataList.get(dataObjectIndex));
			}
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
		catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		catch(IllegalAccessException iae) {
			iae.printStackTrace();
		}
		catch(InstantiationException ie) {
			ie.printStackTrace();
		}
		catch(NoSuchMethodException nsme) {
			nsme.printStackTrace();
		}
		catch(InvocationTargetException ite) {
			ite.printStackTrace();
		}
		finally {
			if(br != null) {
				try {
					br.close();
				}
				catch(IOException ioe) {
					ioe.printStackTrace();
				}
			}
		}
		
		return parsedDataArrayObject;
	}
}
