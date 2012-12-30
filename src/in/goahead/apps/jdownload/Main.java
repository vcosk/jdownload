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

package in.goahead.apps.jdownload;

import in.goahead.apps.jdownload.enums.FileDownloadStatus;
import in.goahead.apps.log.AppLogger;
import in.goahead.apps.util.CSVReader;
import in.goahead.apps.util.URLUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Arrays;

public class Main {

	private static AppLogger Logger = AppLogger.getLogger(URLUtils.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileObj[] downloadObjArray = (FileObj[])CSVReader.parseCSV("download.csv", "in.goahead.apps.jdownload.FileObj", new String[]{"setURL", "setSaveLocation"});

		for(FileObj fileObj : downloadObjArray) {
			try {
				fileObj.setStatus(FileDownloadStatus.INPROGRESS);
				URLUtils.DownloadFileFromURL(fileObj.getURL(), fileObj.getSaveLocation());
				fileObj.setStatus(FileDownloadStatus.COMPLETED);
			} catch (MalformedURLException e) {
				fileObj.setStatus(FileDownloadStatus.ERROR);
				e.printStackTrace();
			} catch (IOException e) {
				fileObj.setStatus(FileDownloadStatus.ERROR);
				e.printStackTrace();
			}
			catch(Exception e) {
				fileObj.setStatus(FileDownloadStatus.ERROR);
				e.printStackTrace();
			}
		}
	}

}

