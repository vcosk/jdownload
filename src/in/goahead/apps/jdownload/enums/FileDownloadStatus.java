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

package in.goahead.apps.jdownload.enums;

public enum FileDownloadStatus {

	NOTSTARTED, INPROGRESS, COMPLETED, ERROR;

	public static FileDownloadStatus ValueOf(String q) {
		FileDownloadStatus v = NOTSTARTED;
		q = q.trim();
		if(q != null) {
			if(q.equalsIgnoreCase("NOTSTARTED") || q.equalsIgnoreCase("PENDING")) {
				v = NOTSTARTED;
			}
			else if(q.equalsIgnoreCase("INPROGRESS") || q.equalsIgnoreCase("PROGRESS")) {
				v = INPROGRESS;
			}
			else if(q.equalsIgnoreCase("COMPLETED")) {
				v = COMPLETED;
			} 
			else if(q.equalsIgnoreCase("ERROR")) {
				v = ERROR;
			}
			else {
				try {
					v=valueOf(q);
				}
				catch(IllegalArgumentException ile) {
					ile.printStackTrace();
					v=NOTSTARTED;
				}
			}
		}
		return v;
	}
}
