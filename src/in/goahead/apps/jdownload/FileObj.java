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
import in.goahead.apps.util.URLUtils;

public class FileObj {
	
	private static AppLogger Logger = AppLogger.getLogger(URLUtils.class);
	
	private String URL;
	
	private String SaveLocation;
	
	private FileDownloadStatus Status = FileDownloadStatus.NOTSTARTED;

	/**
	 * 
	 */
	public FileObj() {
		
	}
	
	/**
	 * @param uRL
	 * @param saveLocation
	 * @param status
	 */
	public FileObj(String uRL, String saveLocation, FileDownloadStatus status) {
		URL = uRL;
		SaveLocation = saveLocation;
		Status = status;
	}
	
	/**
	 * @param uRL
	 * @param saveLocation
	 * @param status
	 */
	public FileObj(String uRL, String saveLocation, String status) {
		URL = uRL;
		SaveLocation = saveLocation;
		Status = FileDownloadStatus.ValueOf(status);
	}

	/**
	 * @param fileObj
	 */
	public FileObj(FileObj fileObj) {
		setURL(fileObj.getURL());
		setSaveLocation(fileObj.getSaveLocation());
		setStatus(fileObj.getStatus());
	}
	
	/**
	 * @return the URL
	 */
	public String getURL() {
		return URL;
	}

	/**
	 * @return the saveLocation
	 */
	public String getSaveLocation() {
		return SaveLocation;
	}

	/**
	 * @return the status
	 */
	public FileDownloadStatus getStatus() {
		return Status;
	}

	/**
	 * @param uRL the uRL to set
	 */
	public void setURL(String uRL) {
		URL = uRL;
	}

	/**
	 * @param saveLocation the saveLocation to set
	 */
	public void setSaveLocation(String saveLocation) {
		SaveLocation = saveLocation;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(FileDownloadStatus status) {
		Status = status;
	}
	
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		Status = FileDownloadStatus.ValueOf(status);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((SaveLocation == null) ? 0 : SaveLocation.hashCode());
		result = prime * result + ((Status == null) ? 0 : Status.hashCode());
		result = prime * result + ((URL == null) ? 0 : URL.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof FileObj)) {
			return false;
		}
		FileObj other = (FileObj) obj;
		if (SaveLocation == null) {
			if (other.SaveLocation != null) {
				return false;
			}
		} else if (!SaveLocation.equals(other.SaveLocation)) {
			return false;
		}
		if (Status != other.Status) {
			return false;
		}
		if (URL == null) {
			if (other.URL != null) {
				return false;
			}
		} else if (!URL.equals(other.URL)) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FileObj [URL=");
		builder.append(URL);
		builder.append(", SaveLocation=");
		builder.append(SaveLocation);
		builder.append(", Status=");
		builder.append(Status);
		builder.append("]");
		return builder.toString();
	}
}
